package com.pcariou.routeur;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.*;

/**
 * Routeur
 *
 */
public class MarketConnectivityProvider
{
    private Selector selector;
    private ServerSocketChannel serverSocketChannelBroker;
    private ServerSocketChannel serverSocketChannelMarket;
    private ExecutorService executorService;

    private enum ChannelType {
        BROKER, MARKET
    }

    private static HashMap<SelectionKey, Handler> clients = new HashMap<>();
    
    public MarketConnectivityProvider(String host, int portBroker, int portMarket) throws Exception {
        System.out.println("Starting Routeur");
        selector = Selector.open();

        serverSocketChannelBroker = ServerSocketChannel.open();
        initServerSocketChannel(serverSocketChannelBroker, host, portBroker);

        serverSocketChannelMarket = ServerSocketChannel.open();
        initServerSocketChannel(serverSocketChannelMarket, host, portMarket);

        executorService = Executors.newFixedThreadPool(5);
        executorService.submit(() -> {
            try {
                loop();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void initServerSocketChannel(ServerSocketChannel serverSocketChannel, String host, int port) throws Exception {
        serverSocketChannel.bind(new InetSocketAddress(host, port));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

    private void loop()
    {
        while (true) {
            try {
                selector.select();
                for (SelectionKey key : selector.selectedKeys()) {
                    if (key.isAcceptable()) {
                        if (key.channel() == serverSocketChannelBroker)
                            newConnection(serverSocketChannelBroker.accept(), ChannelType.BROKER);
                        else if (key.channel() == serverSocketChannelMarket)
                            newConnection(serverSocketChannelMarket.accept(), ChannelType.MARKET);
                    } else if (key.isReadable()) {
                        Handler handler = clients.get(key);
                        if (handler != null)
                            handler.read();
                    } else if (key.isWritable()) {
                        System.out.println("Writable");
                        Handler handler = clients.get(key);
                        if (handler != null)
                            handler.write("Hello");
                    }
                }
                selector.selectedKeys().clear();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void newConnection(SocketChannel acceptedChannel, ChannelType channelType) throws Exception {
        acceptedChannel.configureBlocking(false);
        SelectionKey readKey = acceptedChannel.register(selector, SelectionKey.OP_READ);
        String id = UUID.randomUUID().toString().substring(0, 6);
        switch (channelType) {
            case BROKER:
                clients.put(readKey, new BrokerHandler(readKey, acceptedChannel, id));
                break;
            case MARKET:
                clients.put(readKey, new MarketHandler(readKey, acceptedChannel, id));
                break;
        }
    }

    public static void main( String[] args )
    {
        try {
            System.out.println("Starting MarketConnectivityProvider");
            MarketConnectivityProvider marketConnectivityProvider = new MarketConnectivityProvider("localhost", 5000, 5001);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
