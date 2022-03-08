package com.leetcode.medium;

public class Multiply {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";

        int len1 = num1.length();
        int len2 = num2.length();
        int[] res = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            int n = num1.charAt(i) - '0';
            for (int j = len2 - 1; j >= 0; j--) {
                int m = num2.charAt(j) - '0';
                int num = res[i + j + 1] + m * n;
                res[i + j + 1] = num % 10;
                res[i + j] += num/10;
            }
        }

        StringBuilder builder = new StringBuilder();
        if (res[0] != 0) builder.append(res[0]);
        for (int i = 1; i < res.length; i++)
            builder.append(res[i]);

        return builder.toString();
    }
}
