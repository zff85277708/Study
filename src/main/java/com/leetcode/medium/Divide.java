package com.leetcode.medium;

public class Divide {
    public int divide(int dividend, int divisor) {
        if (divisor == 1) return dividend;
        if (divisor == -1)
            return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;
        if (divisor == Integer.MIN_VALUE)
            return dividend == Integer.MIN_VALUE ? 1 : 0;

        boolean flag = true;
        boolean flag1 = false;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            flag = false;
        if (dividend == Integer.MIN_VALUE) {
            dividend = dividend + Math.abs(divisor);
            flag1 = true;
        }
        int result = div(Math.abs(dividend), Math.abs(divisor));
        result = flag1 ? result + 1 : result;

        return flag ? result : -result;
    }

    private int div(int a, int b) {
        if (a < b) return 0;

        int count = 1;
        int c = b;
        while (c <= a) {
            if (c > 1073741823) break;
            c = c + c;
            count = count + count;
        }
        count = count == 1 ? count : count >> 1;
        c = c == b ? c : c >> 1;
        return count + div(a - c, b);
    }

    public static void main(String[] args) {
        System.out.println(new Divide().divide(1981445587,
                1172010393));
    }
}
