package com.pcariou.routeur;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

public class BrokerHandler implements Handler {
    private SelectionKey selectionKey;
    private SocketChannel socketChannel;
    private ByteBuffer buffer;
    private String id;

    public BrokerHandler(SelectionKey selectionKey, SocketChannel socketChannel, String id) throws IOException {
        this.selectionKey = selectionKey;
        this.socketChannel = socketChannel;
        this.id = id;
        buffer = ByteBuffer.allocate(1024);
    }

    public void read() throws IOException {
        int read = socketChannel.read(buffer);
        if (read == -1) {
            System.out.println("Connection closed by client" + socketChannel.socket().getRemoteSocketAddress());
            selectionKey.cancel();
            socketChannel.close();
            return;
        }
        buffer.flip();
        byte[] bytes = new byte[buffer.remaining()];
        buffer.get(bytes);
        String message = new String(bytes);
        System.out.println("Message received: " + message);
        buffer.clear();
    }

    public void write(String message) throws IOException {
        buffer.put(message.getBytes());
        buffer.flip();
        socketChannel.write(buffer);
        buffer.clear();
    }

    public void disconnect() throws IOException {
        socketChannel.close();
        selectionKey.cancel();
    }

}
