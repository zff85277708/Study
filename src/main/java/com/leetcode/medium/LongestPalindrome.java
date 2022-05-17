package com.leetcode.medium;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;

        int maxLen = 1;
        int begin = 0;
        int sLen = s.length();
        boolean[][] dp = new boolean[sLen][sLen];

        for (int i = 0; i < sLen; i++) {
            dp[i][i] = true;
        }

        for (int j = 1; j < sLen; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && maxLen < j - i + 1) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }
}
