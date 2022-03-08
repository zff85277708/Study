package com.leetcode.medium;

public class CanJump {
    public boolean canJump(int[] nums) {
        int idx = 0;
        for (int i = 0; i< nums.length; i++) {
            if (idx < i) return false;
            idx = idx > i + nums[i] ? idx : i+nums[i];
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,6,1,4,6,5,8,0,77,1,9,6};
        System.out.println(new CanJump().canJump(nums));
    }
}
