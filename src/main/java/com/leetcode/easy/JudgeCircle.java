package com.leetcode.easy;

public class JudgeCircle {
    public boolean judgeCircle(String moves) {
        int len;
        if ((len = moves.length()) <= 0 ) return true;

        int res = 0;
        for (int i = 0; i < len; i++) {
            int tmp;
            switch (moves.charAt(i)) {
                case 'R':
                    tmp = 1;break;
                case 'L':
                    tmp = -1;break;
                case 'U':
                    tmp = 2;break;
                case 'D':
                    tmp = -2;break;
                default:
                    tmp = 0;break;
            }
            res += tmp;
        }
        return res == 0;
    }
}
