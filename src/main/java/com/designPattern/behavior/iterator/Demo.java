package com.designPattern.behavior.iterator;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        ListIterator<String> iterator = new ListIterator<>(names);
        names.add("Tom");
        names.add("Jack");
        names.add("Bob");

        while (iterator.hasNext())
            System.out.println(iterator.next());
    }
}
