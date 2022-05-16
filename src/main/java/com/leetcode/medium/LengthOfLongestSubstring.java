package com.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (null == s || 0 == s.length()) return 0;
        if (1 == s.length()) return 1;

        Set<Character> set = new HashSet<>();
        int len = s.length();
        int i = 0;
        int j = 0;
        int max = Integer.MIN_VALUE;

        while (j < len) {
            if (set.contains(s.charAt(j))) {
                max = Math.max(max, j - i);
                set.remove(s.charAt(i++));
            } else {
                set.add(s.charAt(j++));
            }
        }

        return  Math.max(max, j - i);
    }
}
