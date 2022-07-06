package com.algorithm;

/**
 * 基于数组的队列
 * @param <E>
 */
public class ArrayQueue<E> {
    private final Object[] items;
    private final int capacity;
    private int head;
    private int tail;
    private static final int DEFAULT_CAPACITY = 8;

    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayQueue(int capacity) {
        if (capacity < DEFAULT_CAPACITY)
            capacity = DEFAULT_CAPACITY;
        this.capacity = capacity;
        this.items = new Object[capacity];
        this.head = this.tail = 0;
    }

    public boolean enqueue(E item) {
        if (tail == capacity) {
            if (head == 0)
                return false;

            System.arraycopy(items, head, items, 0, tail - head);
            tail = tail - head;
            head = 0;
        }
        items[tail++] = item;
        return true;
    }

    @SuppressWarnings("unchecked")
    public E dequeue() {
        if (head == tail) return null;
        return (E) items[head++];
    }
}
