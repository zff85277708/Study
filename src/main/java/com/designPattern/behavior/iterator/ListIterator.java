package com.designPattern.behavior.iterator;

import java.util.List;
import java.util.NoSuchElementException;

public class ListIterator<E> implements Iterator<E>{
    private int cursor;
    private List<E> list;

    public ListIterator(List<E> list) {
        this.cursor = 0;
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return cursor != list.size();
    }

    @Override
    public E next() {
        if (cursor >= list.size())
            throw new NoSuchElementException();
        return list.get(cursor++);
    }
}
