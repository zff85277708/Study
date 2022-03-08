package com.zhuff.test;

public class StackOverflowErrorTest {
    public static void main(String[] args) {
        a();
    }

    public static String a() {
        return a();
    }
}
