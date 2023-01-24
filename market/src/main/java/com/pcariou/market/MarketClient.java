package com.pcariou.market;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Market client.
 *
 */
public class MarketClient
{
    private String host;
    private int port;
    private Socket socket;
    

    public MarketClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void connect() {

        socket = new Socket();
        try {
            socket.connect(new InetSocketAddress(host, port));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void SendMessage(String message) throws IOException {
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
        printWriter.println(message);
        printWriter.flush();
    }

    public static void main( String[] args )
    {
        MarketClient marketClient = new MarketClient("localhost", 5001);
        marketClient.connect();

        while (true) {
            try {
                marketClient.SendMessage("Hello from market");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
