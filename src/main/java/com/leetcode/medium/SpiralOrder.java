package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row,col,top,bottom,left,right;
        List<Integer> list = new ArrayList<>();
        if (matrix == null || (row = matrix.length) == 0 || (col = matrix[0].length) == 0)
            return list;

        left = 0;
        right = col - 1;
        top = 0;
        bottom = row - 1;

        while (top <= bottom && left <= right) {
            for (col = left; col <= right; col++)
                list.add(matrix[top][col]);

            for (row = top + 1; row <= bottom; row++)
                list.add(matrix[row][right]);

            if (top < bottom && left < right) {
                for (col = right - 1; col > left; col--)
                    list.add(matrix[bottom][col]);

                for (row = bottom; row > top; row--)
                    list.add(matrix[row][left]);
            }

            top++;
            bottom--;
            left++;
            right--;
        }

        return list;
    }
}
