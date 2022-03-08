package com.leetcode.easy;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) sum += num;
            else sum = num;
            ans = Math.max(sum, ans);
        }
        return ans;
    }
}
