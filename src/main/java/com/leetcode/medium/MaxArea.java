package com.leetcode.medium;

public class MaxArea {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int area = Integer.MIN_VALUE;

        while (i < j) {
            int s = Math.min(height[i], height[j]) * (j - i);
            area = Math.max(area, s);
            if (height[i] < height[j])
                i++;
            else
                j--;
        }
        return area;
    }
}
