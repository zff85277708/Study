package com.algorithm;

/**
 * 基于数组的栈
 * @param <T>
 */
public class ArrayStack<T> {
    private Object[] items;
    private int count;
    private int n;

    public ArrayStack(int n) {
        if (n <= 0) throw new IllegalArgumentException("栈容量非法");
        this.items = new Object[n];
        this.n = n;
        this.count = 0;
    }

    public boolean push(T item) {
        if (count == n) {
            Object[] newItems = new Object[2 * n];
            System.arraycopy(items, 0, newItems, 0, n);
            items = newItems;
            n *= 2;
        }
        items[count++] = item;
        return true;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (count == 0) return null;
        return (T) items[--count];
    }

    public int getN() {
        return n;
    }
}
