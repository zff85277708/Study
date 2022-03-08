package com.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;

public class NoBlockServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel server = ServerSocketChannel.open();
        server.configureBlocking(false);
        server.bind(new InetSocketAddress(6666));
        Selector selector = Selector.open();
        server.register(selector, SelectionKey.OP_ACCEPT);

        while (selector.select() > 0) {
            System.out.println("selector.select");
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                System.out.println("iterator.hasNext");
                SelectionKey selectionKey = iterator.next();
                if (selectionKey.isAcceptable()) {
                    System.out.println("selectionKey.isAcceptable");
                    SocketChannel client = server.accept();
                    client.configureBlocking(false);
                    client.register(selector, SelectionKey.OP_READ);
                } else if (selectionKey.isReadable()) {
                    System.out.println("selectionKey.isReadable");
                    SocketChannel client = (SocketChannel) selectionKey.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    FileChannel outChannel = FileChannel.open(
                            Paths.get("2.JPG"),
                            StandardOpenOption.WRITE,
                            StandardOpenOption.CREATE);
                    while (client.read(buffer) > 0) {
                        System.out.println("client.read");
                        buffer.flip();
                        outChannel.position(outChannel.size());
                        outChannel.write(buffer);
                        buffer.clear();
                    }

                    ByteBuffer buffer1 = ByteBuffer.allocate(1024);
                    buffer1.put("img success\n".getBytes());
                    buffer1.flip();
                    client.write(buffer1);
                    buffer1.clear();
                }
                iterator.remove();
            }
        }
    }
}
