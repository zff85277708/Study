package com.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class IsValidSudoku {
    private Set<Character> set = new HashSet<>();

    public boolean isValidSudoku(char[][] board) {
        if (!isRepeat(0, 9, 0, 9,
                board, true, true))
            return false;
        if (!isRepeat(0, 9, 0, 9,
                board, false, true))
            return false;
        for (int line = 0; line < 9; line += 3) {
            for (int row = 0; row < 9; row += 3) {
                if (!isRepeat(line, 3, row, 3,
                        board, true, false))
                    return false;
            }
        }

        return true;
    }

    private boolean isRepeat(int line, int lineLen, int row, int rowLen,
                             char[][] board, boolean flag, boolean flag1) {
        int i,j;
        for (i = line; i < line + lineLen; i++) {
            for (j = row; j < row + rowLen; j++) {
                char c = flag ? board[i][j] : board[j][i];
                if (c != '.') {
                    if (set.contains(c)) return false;
                    else set.add(c);
                }
            }
            if (flag1)
                set.clear();
        }
        if (!flag1)
            set.clear();
        return true;
    }
}
