package com.leetcode.easy;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length <= 0) return 0;

        int i = 0, j = nums.length - 1;
        do {
          if (nums[j] == val) {
              j--;
              continue;
          }
          if (nums[i] != val) {
              i++;
              continue;
          }
          int t = nums[i];
          nums[i] = nums[j];
          nums[j] = t;
          j--;
          i++;
        } while (i <= j);

        return j + 1;
    }
}
