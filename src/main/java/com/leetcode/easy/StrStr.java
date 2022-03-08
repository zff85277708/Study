package com.leetcode.easy;

import java.util.HashMap;

public class StrStr {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        int len_h,len_n;
        if ((len_n = needle.length()) == 0) return 0;
        if ((len_h = haystack.length()) == 0) return -1;
        if (len_h < len_n) return -1;

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len_n; i++) {
            map.put(needle.charAt(i), len_n - i);
        }

        for (int i = 0; i < len_h - len_n + 1;) {
            int index = i + len_n;
            if (haystack.substring(i, index).equals(needle))
                return i;
            if (i + len_n != len_h && map.containsKey(haystack.charAt(index))) {
                i = i + map.get(haystack.charAt(index));
            } else {
                i = i + len_n + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new StrStr().strStr("mississippi", "issi"));
    }
}
