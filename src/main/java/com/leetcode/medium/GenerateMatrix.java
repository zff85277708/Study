package com.leetcode.medium;

public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int l,r,t,b;
        int num = 1;
        int tar = n * n;
        int[][] mat = new int[n][n];

        l = t = 0;
        r = b = n -1;

        while (num <= tar) {
            for (int i = l; i <= r; i++) mat[t][i] = num++;
            t++;
            for (int i = t; i <= b; i++) mat[i][r] = num++;
            r--;
            for (int i = r; i >= l; i--) mat[b][i] = num++;
            b--;
            for (int i = b; i >= t; i--) mat[i][l] = num++;
            l++;
        }
        return mat;
    }

    public static void main(String[] args) {
        GenerateMatrix matrix = new GenerateMatrix();
        int[][] arrays = matrix.generateMatrix(5);
        for (int[] array: arrays) {
            for (int i : array)
                System.out.print(i + ",");
            System.out.println();
        }
    }
}
