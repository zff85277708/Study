package com.algorithm;

import java.util.Date;
import java.util.LinkedList;
import java.util.UUID;

/**
 * 链表实现LRU缓存
 * @param <E>
 */
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

    public synchronized E search(String id) {
        if (0 == size) return null;
        if(id.equals(first.id)) return first.item;

        Node<E> next = first;
        while (next.next != null) {
            if (id.equals(next.next.id)) {
                Node<E> tmp = next.next;
                next.next = next.next.next;
                //尾节点命中，重新更新尾节点
                if (next.next == null) last = next;
                tmp.next = first;
                first = tmp;
                return tmp.item;
            }
            next = next.next;
        }
        return null;
    }

    public synchronized void add(String id, E item) {
        if (0 == size) {
            first = new Node<>(item, null, id);
            last = first;
        } else if (size >= limit) {

        } else {
            last.next = new Node<>(item, null, id);
            last = last.next;
        }
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        String id;

        Node(E item, Node<E> next, String id) {
            this.item = item;
            this.next = next;
            this.id = id;
        }
    }
}
