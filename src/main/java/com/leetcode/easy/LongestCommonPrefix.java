package com.leetcode.easy;

import java.util.HashMap;

public class LongestCommonPrefix {
    //纵向扫描
    public String longestCommonPrefix(String[] strs) {
        if (null == strs || 0 == strs.length)
            return "";

        String str = strs[0];
        for (int i = 0; i < str.length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() -1 < i || str.charAt(i) != strs[j].charAt(i) )
                    return str.substring(0, i);
            }
        }
        return str;
    }

    //分治
    public String longestCommonPrefix1(String[] strs) {
        if (null == strs || 0 == strs.length)
            return "";
        else
            return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int start, int end) {
        if (start == end) {
            return strs[start];
        } else {
            int mid = (end - start) / 2 + start;
            String lcpLeft = longestCommonPrefix(strs, start, mid);
            String lcpRight = longestCommonPrefix(strs, mid + 1, end);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    private String commonPrefix(String lcpLeft, String lcpRight) {
        int length = Math.min(lcpLeft.length(), lcpRight.length());
        for (int i = 0; i < length; i++) {
            if (lcpLeft.charAt(i) != lcpRight.charAt(i))
                return lcpLeft.substring(0, i);
        }
        return lcpLeft.substring(0,length);
    }

    public static void main(String[] args) {
        System.out.println("".substring(0,0));
    }
}
