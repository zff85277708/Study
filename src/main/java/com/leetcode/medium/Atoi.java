package com.leetcode.medium;

public class Atoi {
    public int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int flag = 1;
        boolean numFlag = false;
        int result = 0;

        for (int i = 0; i < chars.length; i++) {
            if (!numFlag && chars[i] != ' ' && chars[i] != '+'
                    && chars[i] != '-' && (chars[i] < '0' || chars[i] > '9'))
                return 0;
            if (numFlag && (chars[i] < '0' || chars[i] > '9'))
                return result;
            if (chars[i] != ' ') {
                numFlag = true;
                if ('-' == chars[i]) {
                    flag = -1;
                } else if (chars[i] != '+') {
                    int j = chars[i] - '0';
                    if (result < Integer.MIN_VALUE/10
                            || (result == Integer.MIN_VALUE/10 && j > 8))
                        return Integer.MIN_VALUE;
                    if (result > Integer.MAX_VALUE/10
                            || (result == Integer.MAX_VALUE/10 && j > 7))
                        return Integer.MAX_VALUE;
                    result = result * 10 + j * flag;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Atoi atoi = new Atoi();
        System.out.println(atoi.myAtoi("-21474836481"));
        System.out.println(Integer.MAX_VALUE + " " + Integer.MIN_VALUE);
    }
}
