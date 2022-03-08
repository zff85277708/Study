package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length <= 0) return new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        if (strs.length <= 0) return new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (char c : str.toCharArray())
                count[c - 'a']++;
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < 26; i++)
                builder.append(count[i]);
            String key = builder.toString();
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
