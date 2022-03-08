package com.zhuff.test;

import java.io.UnsupportedEncodingException;

public class Test extends Thread{
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
        System.out.println(s1 == s2);
        System.out.println(s1 == s5);
        System.out.println(s1 == s6);
        System.out.println(s1 == s6.intern());
        System.out.println(s2 == s2.intern());

        System.out.println(reverse("abcdefg"));
        System.out.println("dasfa飞".length());

        String a1 = "你好";
        String a2 = new String(a1.getBytes("GB2312"), "ISO-8859-1");
        System.out.println(a2);
        System.out.println(a1);
        System.out.println(a1.length() + " " + a2.length());

        try {
            sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        super.run();
    }

    public static String reverse(String originStr) {
        if(originStr == null || originStr.length() <= 1)
            return originStr;
        return reverse(originStr.substring(1)) + originStr.charAt(0);
    }
}
