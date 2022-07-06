package com.algorithm;

/**
 * 基于数组的循环队列
 * @param <E>
 */
public class CircularQueue<E> {
    private final Object[] items;
    private final int capacity;
    private int head;
    private int tail;
    private static final int DEFAULT_CAPACITY = 8;

    public CircularQueue() {
        this(DEFAULT_CAPACITY);
    }

    public CircularQueue(int capacity) {
        if (capacity < DEFAULT_CAPACITY)
            capacity = DEFAULT_CAPACITY;
        this.capacity = capacity;
        this.items = new Object[capacity];
        this.head = this.tail = 0;
    }

    public boolean enqueue(E item) {
        if ((tail + 1) % capacity == head)
            return false;

        items[tail] = item;
        tail = (tail + 1) % capacity;
        return true;
    }

    @SuppressWarnings("unchecked")
    public E dequeue() {
        if (head == tail) return null;
        E item = (E) items[head];
        head = (head + 1) % capacity;
        return item;
    }
}
