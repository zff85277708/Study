package com.leetcode.medium;

public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            if (1 == obstacleGrid[i][0]) {
                res[i][0] = 0;
                break;
            }
            else
                res[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            if (1 == obstacleGrid[0][j]) {
                res[0][j] = 0;
                break;
            }
            else
                res[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (1 == obstacleGrid[i][j])
                    res[i][j] = 0;
                else
                    res[i][j] = res[i - 1][j] + res[i][j - 1];
            }
        }
        return res[m -1][n -1];
    }
}
