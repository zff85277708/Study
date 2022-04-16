package com.leetcode.etc;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numFlowers(int[][] roads) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < roads.length; i++) {
            for (int j = 0; j < roads[0].length; j++) {
                if (map.containsKey(roads[i][j])) {
                    int val = map.get(roads[i][j]);
                    map.put(roads[i][j], ++val);
                } else {
                    map.put(roads[i][j], 1);
                }
            }
        }

        int max = -1;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            max = Integer.max(max, entry.getValue());
        }

        return ++max;
    }

    public static void main(String[] args) {

    }
}
