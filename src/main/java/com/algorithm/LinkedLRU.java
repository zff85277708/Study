package com.algorithm;

/**
 * 链表实现LRU缓存
 * @param <E>
 */
public class LinkedLRU<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;
    private final int limit;
    private static final int DEFAULT_LIMIT = 5;

    public LinkedLRU() {
        this(DEFAULT_LIMIT);
    }

    public LinkedLRU(int limit) {
        if (limit < 5) limit = DEFAULT_LIMIT;
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
            size++;
        } else if (size >= limit) {
            Node<E> next = first;
            while (next.next != null) {
                if (last == next.next)
                    break;
                else
                    next = next.next;
            }
            next.next = new Node<>(item, null, id);
            last = next.next;
        } else {
            last.next = new Node<>(item, null, id);
            last = last.next;
            size++;
        }
    }

    @Override
    public String toString() {
        Node<E> next = first;
        StringBuilder builder = new StringBuilder();
        while (next != null) {
            builder.append(next.id).append(": ").append(next.item.toString()).append("\n");
            next = next.next;
        }
        return builder.toString();
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

    public static void main(String[] args) {
        LinkedLRU<String> linkedLRU = new LinkedLRU<>();
        for (int i = 0; i < 10; i++) {
            linkedLRU.add(String.valueOf(i), String.valueOf(i));
//            System.out.println(linkedLRU);
        }

        String res = linkedLRU.search("0");
        System.out.println(res);
        System.out.println(linkedLRU);

        res = linkedLRU.search("9");
        System.out.println(res);
        System.out.println(linkedLRU);

        res = linkedLRU.search("3");
        System.out.println(res);
        System.out.println(linkedLRU);

        res = linkedLRU.search("0");
        System.out.println(res);
        System.out.println(linkedLRU);

        res = linkedLRU.search("6");
        System.out.println(res);
        System.out.println(linkedLRU);
    }
}
