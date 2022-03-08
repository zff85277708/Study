package com.leetcode.easy;

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        if (nums.length <= 0) return 0;

        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        if (target == nums[low])
            return low;
        else if (target > nums[low])
            return low + 1;
        else
            return low;
    }
}
