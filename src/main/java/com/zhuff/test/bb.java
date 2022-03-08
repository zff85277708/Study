package com.zhuff.test;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;

public class bb extends aa {
    public static void main(String[] args) {
        bb b = new bb();
        b.s();
        String s1 = "asd";
        s1.toCharArray()[0] = 'a';
        System.out.println(s1);
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("dasfa");

        Thread thread = new Thread(){
            @Override
            public void run() {
                String s3 = threadLocal.get();
                System.out.println(s3);
                System.out.println(s1);
            }
        };
        thread.start();
        System.out.println(1<<30);
        System.out.println(Integer.MAX_VALUE);

        int a=10;
        if (a>2) System.out.println("a");
        else if (a>3) System.out.println("b");
        String ss = "abcdefg";
        System.out.println(ss.substring(1,5));
        System.out.println(Integer.MAX_VALUE/2 + "zff  " + (Integer.MAX_VALUE >> 1));
        Object[] objects = new Object[10];
        if (objects[1] == null) System.out.println("caonima");
        while (true)
            System.out.println(1);
    }
}
