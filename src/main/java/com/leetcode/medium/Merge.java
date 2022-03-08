package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length <= 1)
            return intervals;

        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (int[] o1,int[] o2) -> o1[0] - o2[0]);
        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0];
            int R = intervals[i][1];
            if (i == 0 || list.get(list.size() - 1)[1] < L)
                list.add(new int[]{L,R});
            else
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], R);
        }
        return list.toArray(new int[list.size()][]);
    }
}
