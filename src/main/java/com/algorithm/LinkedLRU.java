package com.algorithm;

import java.util.HashMap;

/**
 * 链表实现LRU缓存
 * 最近最少使用的节点放在链表尾
 * @param <E>
 */
public class LinkedLRU<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;
    private final int capacity;
    //基于散列表实现缓存元素O(1)复杂度查找
    private final HashMap<String, Node<E>> hashMap;
    private static final int DEFAULT_LIMIT = 10;

    public LinkedLRU() {
        this(DEFAULT_LIMIT);
    }

    public LinkedLRU(int capacity) {
        if (capacity < 5) capacity = DEFAULT_LIMIT;
        this.capacity = capacity;
        hashMap = new HashMap<>(capacity);
    }

    public synchronized E search(String id) {
        if(!hashMap.containsKey(id)) return null;

        Node<E> currentNode = hashMap.get(id);
        if (null == currentNode.pre) return currentNode.item;

        currentNode.pre.next = currentNode.next;
        //尾节点命中，重新更新尾节点
        if (null == currentNode.next)
            last = currentNode.pre;
        else
            currentNode.next.pre = currentNode.pre;

        currentNode.pre = null;
        currentNode.next = first;
        first.pre = currentNode;
        first = first.pre;
        return first.item;
    }

    public synchronized void add(String id, E item) {
        //数据是否已经在缓存中
        if (search(id) != null) return;

        if (0 == size) {
            first = new Node<>(item, null, null, id);
            hashMap.put(id, first);
            last = first;
            size++;
            return;
        }

        if (size >= capacity) {
            hashMap.remove(last.id);
            Node<E> delNode = last;
            last.pre.next = null;
            last = last.pre;
            delNode.pre = null;
            size--;
        }

        first.pre = new Node<>(item, null, first, id);
        hashMap.put(id, first.pre);
        first = first.pre;
        size++;
    }

    @Override
    public String toString() {
        Node<E> next = first;
        StringBuilder builder = new StringBuilder();
        while (next != null) {
            builder.append("id: ").append(next.id).append("--")
                    .append("value: ").append(next.item.toString()).append("\n");
            next = next.next;
        }
        return builder.toString();
    }

    private static class Node<E> {
        E item;
        Node<E> pre;
        Node<E> next;
        String id;

        Node(E item, Node<E> pre, Node<E> next, String id) {
            this.item = item;
            this.pre = pre;
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

        linkedLRU.add("10", "10");
        System.out.println(linkedLRU);

        linkedLRU.add("10", "10");
        System.out.println(linkedLRU);
    }
}
