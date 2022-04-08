package com.leetcode.medium;

public class Exist {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] stats = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boolean flag = dfs(i, j, board, stats, word, 0);
                if (flag) return true;
            }
        }

        return false;
    }

    private boolean dfs(int row, int col, char[][] board, boolean[][] stats, String word, int index) {
        if (board[row][col] != word.charAt(index))
            return false;

        if (word.length() -1 == index)
            return true;

        stats[row][col] = true;
        int[][] tmps = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] tmp : tmps) {
            int newRow = row + tmp[0];
            int newCol = col + tmp[1];
            if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length) {
                if (!stats[newRow][newCol]) {
                    boolean flag = dfs(newRow, newCol, board, stats, word, index + 1);
                    if (flag) return true;
                }
            }
        }
        stats[row][col] = false;
        return false;
    }
}
