package com.algorithm;

import java.util.Date;
import java.util.LinkedList;
import java.util.UUID;

public class LinkedLRU<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;
    private final int limit;
    private static final int DEFAULT_LIMIT = 20;

    public LinkedLRU() {
        this(DEFAULT_LIMIT);
    }

    public LinkedLRU(int limit) {
        this.limit = limit;
    }

    public E search(String id) {
        Node<E> next = first;
        Node<E> pre = null;
        while (next != null) {
            if (id.equals(next.id)) {

                return next.item;
            }
        }
        return null;
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        long timestamp;
        String id;

        Node(E item, Node<E> next, long timestamp, String id) {
            this.item = item;
            this.next = next;
            this.timestamp = timestamp;
            this.id = id;
        }
    }
}
