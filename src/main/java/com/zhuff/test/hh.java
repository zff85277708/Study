package com.zhuff.test;

public class hh implements abs{
    private static int age=0;

    public synchronized void add() {
        System.out.println("ss");
    }

    public static void main(String[] args) {
        new hh().add();
        new hh().new b().c();
    }

    class b{
        public void c() {
            age = age + 1;
            System.out.println(age);
        }
    }
}
