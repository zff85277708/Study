package com.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;

public class NoBlockClient {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open(
                new InetSocketAddress("localhost", 6666));
        socketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        socketChannel.register(selector, SelectionKey.OP_READ);
        FileChannel fileChannel = FileChannel.open(
                Paths.get("E:\\zhuff\\Photos\\IMG_4147.JPG"),
                StandardOpenOption.READ);
        ByteBuffer buffer = ByteBuffer.allocate(1022);

        while (fileChannel.read(buffer) != -1) {
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
        }

        while (selector.select() > 0) {
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                if (selectionKey.isReadable()) {
                    SocketChannel channel = (SocketChannel) selectionKey.channel();
                    ByteBuffer buffer1 = ByteBuffer.allocate(1024);
                    int readBytes = channel.read(buffer1);
                    if (readBytes > 0) {
                        buffer1.flip();
                        System.out.println(
                                new String(buffer1.array(), 0, readBytes));
                        buffer1.clear();
                    }
                }
                iterator.remove();
            }
        }
    }
}
