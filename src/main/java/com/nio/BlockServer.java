package com.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;

public class BlockServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel server = ServerSocketChannel.open();
        FileChannel fileChannel = FileChannel.open(
                Paths.get("1.JPG"),
                StandardOpenOption.WRITE,
                StandardOpenOption.CREATE
        );
        server.bind(new InetSocketAddress(6666));
        SocketChannel client = server.accept();
        ByteBuffer buffer = ByteBuffer.allocate(1025);

        while (client.read(buffer) != -1) {
            buffer.flip();
            fileChannel.write(buffer);
            buffer.clear();
        }

        buffer.put("img is success".getBytes());
        buffer.flip();
        client.write(buffer);
        buffer.clear();

        fileChannel.close();
        client.close();
        server.close();
    }
}
