package com.leetcode.medium;

public class LargestHuiwenSubString {
    /**
     * 暴力法
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int subLen = 1;
        int index = 0;
        int n = s.length();

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (subLen < j - i + 1 && isHuiwen(s.toCharArray(), i, j)) {
                    index = i;
                    subLen = j - i + 1;
                }
            }
        }

        return s.substring(index, index + subLen);
    }

    private boolean isHuiwen(char[] chars, int left, int right) {
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 动态规划
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        int subLen = 1;
        int index = 0;
        int sLen = s.length();

        if (sLen < 2) return s;

        boolean[][] map = new boolean[sLen][sLen];
        char[] chars = s.toCharArray();

        for (int j = 1; j < sLen; j++) {
            for (int i = 0; i < j; i++) {
                map[i][j] = chars[i] == chars[j] && (j - i < 3 || map[i+1][j-1]);
                if (map[i][j] && subLen < j - i + 1) {
                    index = i;
                    subLen = j - i + 1;
                }
            }
        }

        return s.substring(index, index + subLen);
    }

    /**
     * 中心扩散
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        int index = 0;
        int subLen = 0;

        if (s.length() < 2) {
            return s;
        }

        char[] chars = s.toCharArray();

        for (int i = 0; i < s.length() - 1; i++) {
            int len1 = centerSpread(chars, i, i);
            int len2 = centerSpread(chars, i, i + 1);
            if (len1 > len2 && subLen < 2 * len1 - 1) {
                index = i - len1 + 1;
                subLen = 2 * len1 - 1;
            } else if (subLen < 2 * len2) {
                index = i - len2 + 1;
                subLen = 2 * len2;
            }
        }

        return s.substring(index, index + subLen);
    }

    private int centerSpread(char[] chars, int left, int right) {
        int len = 0;

        while (left >= 0 && right < chars.length) {
            if (chars[left] == chars[right]) {
                len++;
                left--;
                right++;
            } else {
                break;
            }
        }

        return len;
    }


    public static void main(String[] args) {
        LargestHuiwenSubString subString = new LargestHuiwenSubString();
        System.out.println(subString.longestPalindrome("aaadsafaasdsssssssssdsada"));
        System.out.println(subString.longestPalindrome1(""));
        System.out.println(subString.longestPalindrome2("aaaaa"));
    }
}
