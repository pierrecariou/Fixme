package com.pcariou.broker;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Broker client.
 *
 */
public class BrokerClient
{
    private String host;
    private int port;
    private Socket socket;

    public BrokerClient(String host, int port) {
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
        BrokerClient brokerClient = new BrokerClient("localhost", 5000);
        brokerClient.connect();

        while (true) {
            try {
                brokerClient.SendMessage("Hello from broker");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
