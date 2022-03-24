package com.leetcode.medium;

public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0,sum = 0; i < m; i++) {
            dp[i][0] = sum + grid[i][0];
            sum += grid[i][0];
        }

        for (int j = 0,sum = 0; j < n; j++) {
            dp[0][j] = sum + grid[0][j];
            sum += grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m - 1][n - 1];
    }
}
