package com.leetcode.easy;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int len1 = num1.length();
        int len2 = num2.length();
        int len = Math.max(len1, len2);
        boolean flag = false;
        for (int i = 0; i < len; i++) {
            int n1 = i < len1 ? num1.charAt(len1 - i -1) - '0' : 0;
            int n2 = i < len2 ? num2.charAt(len2 - i -1) - '0' : 0;
            int res = n1 + n2;
            res = flag ? res + 1 : res;
            flag = res > 9;
            res %= 10;
            builder.append(res);
        }
        if (flag) builder.append(1);
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new AddStrings().addStrings("98", "9"));
    }
}
