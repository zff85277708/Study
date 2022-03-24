package com.leetcode.easy;

public class ClimbStairs {
    public int climbStairs(int n) {
        if (1 == n) return 1;
        if (2 == n) return 2;
        if (3 == n) return 3;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int climbStairs1(int n) {
        if (1 == n) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new ClimbStairs().climbStairs1(45));
    }
}
