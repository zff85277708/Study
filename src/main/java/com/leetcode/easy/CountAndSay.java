package com.leetcode.easy;

import java.util.HashMap;

public class CountAndSay {
    private HashMap<Character, Integer> map = new HashMap<>();

    public String countAndSay(int n) {
        if (n == 1) return "1";

        char[] chars = countAndSay(--n).toCharArray();
        StringBuilder builder = new StringBuilder();
        char key = chars[0];
        map.put(key, 0);
        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])) {
                builder.append(map.get(key)).append(key);
                map.clear();
                key = chars[i];
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }
        builder.append(map.get(key)).append(key);
        map.clear();
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(31));
    }
}
