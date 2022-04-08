package com.leetcode.medium;

public class Search1 {
    public boolean search(int[] nums, int target) {
        if (null == nums || 0 == nums.length)
            return false;

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) return true;
            if (nums[mid] == nums[left]) {
                left++;
                continue;
            }
            if (nums[mid] > nums[left]) {
                if (target < nums[mid] && target >= nums[left])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else {
                if (target > nums[mid] && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return false;
    }
}
