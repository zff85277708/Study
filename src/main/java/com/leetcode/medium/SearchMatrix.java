package com.leetcode.medium;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length - 1;
        int mid = -1;

        while (top <= bottom) {
            mid = top + (bottom - top) / 2;
            if (target == matrix[mid][0]) return true;
            if (matrix[mid][0] > target)
                bottom = mid - 1;
            else
                top = mid + 1;
        }

        int row = top - 1;
        if (row < 0) return false;

        int left = 0;
        int right = matrix[0].length - 1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target == matrix[row][mid]) return true;
            if (matrix[row][mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return false;
    }
}
