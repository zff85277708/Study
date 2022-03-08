package com.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class NoRepeatSubString {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int index = 0;
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }

            while (index < s.length() && !set.contains(s.charAt(index))) {
                set.add(s.charAt(index));
                index++;
            }

            max = Math.max(max, index - i);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(
                new NoRepeatSubString().lengthOfLongestSubstring(""));
    }
}
