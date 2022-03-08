package com.leetcode.easy;

public class IntReverse {
    public int reverse(int x) {
        long num1 = (long) x;
        boolean flag = num1 < 0 ? true : false;
        StringBuilder builder = new StringBuilder().append(num1);
        String s = builder.reverse().toString();
        s = flag ? "-" + s.substring(0,s.length() - 1) : s;
        long num2 = Long.parseLong(s);
        if (num2 < -2147483648 || num2 > 2147483647)
            return 0;
        else
            return (int) num2;
    }

    public int reverse1(int x) {
        int result = 0;

        while (x != 0) {
            int i = x % 10;
            if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && i > 7))
                return 0;
            if (result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE/10 && i < -8))
                return 0;
            result = result * 10 + i;
            x /= 10;
        }

        return result;
    }

    public static void main(String[] args) {
        IntReverse ir = new IntReverse();
        System.out.println(ir.reverse(4256));
        System.out.println(ir.reverse1(-84645));
    }
}
