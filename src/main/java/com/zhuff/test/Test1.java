package com.zhuff.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        for (int i = 9; i > 0; i--) {
            list.add(String.valueOf(i));
        }

        list.add("7");
        list.remove(2);

        for (String s: list) {
            System.out.println(s);
        }

        System.out.println(list.get(3));
        Collections.sort(list);
        System.out.println(list);
    }
}
