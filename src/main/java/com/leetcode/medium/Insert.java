package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Insert {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        List<int[]> list = new ArrayList<>();
        boolean flag = false;

        for (int[] interval : intervals) {
            if (interval[0] > right) {
                if (!flag)  {
                    list.add(new int[] {left,right});
                    flag = true;
                }
                list.add(interval);
            } else if (interval[1] < left) {
                list.add(interval);
            } else {
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }

        if (!flag)  {
            list.add(new int[] {left,right});
        }

        int[][] newIntervals = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++)
            newIntervals[i] = list.get(i);

        return newIntervals;
    }
}
