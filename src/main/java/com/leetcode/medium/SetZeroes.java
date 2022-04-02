package com.leetcode.medium;

public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        boolean rowFlag = false;
        boolean colFlag = false;
        int row = matrix.length;
        int col = matrix[0].length;

        for (int j = 0; j < col; j++) {
            if (0 == matrix[0][j]) {
                rowFlag = true;
                break;
            }
        }

        for (int i = 0; i < row; i++) {
            if (0 == matrix[i][0]) {
                colFlag = true;
                break;
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (0 == matrix[i][j]) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (0 == matrix[i][0] || 0 == matrix[0][j])
                    matrix[i][j] = 0;
            }
        }

        if (rowFlag) {
            for (int j = 0; j < col; j++) {
                matrix[0][j] = 0;
            }
        }

        if (colFlag) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
