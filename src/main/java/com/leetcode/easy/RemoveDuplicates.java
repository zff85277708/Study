package com.leetcode.easy;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (null == nums || nums.length <= 0) return 0;

        int i = 0, j = 0;
        int len = nums.length;
        while (j < len) {
            if (nums[i] == nums[j]) j++;
            else {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int len = removeDuplicates.removeDuplicates(nums);
        for (int i : nums)
            System.out.print(i + " ");
        System.out.println("\n" + len);
    }
}
