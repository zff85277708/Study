package com.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;

public class BlockClient {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open(
                new InetSocketAddress("localhost", 6666));
        FileChannel fileChannel = FileChannel.open(
                Paths.get("E:\\zhuff\\Photos\\IMG_4118.JPG"),
                StandardOpenOption.READ);
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (fileChannel.read(buffer) != -1) {
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
        }

        socketChannel.shutdownOutput();

        int len = 0;
        while ((len = socketChannel.read(buffer)) != -1) {
            buffer.flip();
            System.out.println(new String(buffer.array(), 0, len));
            buffer.clear();
        }

        fileChannel.close();
        socketChannel.close();
    }
}
