package com.leetcode.medium;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        return process(nums, 2);
    }

    private int process(int[] nums, int k) {
        int u = 0;
        for (int num : nums) {
            if (u < k || nums[u - k] != num)
                nums[u++] = num;
        }
        return u;
    }
}
