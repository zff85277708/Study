package com.leetcode.easy;

public class MySqrt {
    public int mySqrt(int x) {
        if (0 == x) return 0;
        if (1 == x) return 1;

        int left = 0;
        int right = x;
        while (left != right) {
            int mid = left + (right - left) / 2;
            if (mid == left) return mid;
            if ((long)mid * mid > x) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        MySqrt mySqrt = new MySqrt();
        System.out.println(mySqrt.mySqrt(2147395599));
        System.out.println(Integer.MAX_VALUE);
    }
}
