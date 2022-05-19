package com.leetcode.medium;

public class Reverse {
    public int reverse(int x) {
        int res = 0;

        while (x != 0) {
            int tmp = x % 10;
            if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10)
                return 0;
            res = res * 10 + tmp;
            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
    }
}
