package com.leetcode.medium;

public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};

        int left = searchNode(nums, 0, nums.length, target, true);
        if (left == nums.length || nums[left] != target)
            return res;

        res[0] = left;
        res[1] = searchNode(nums, 0, nums.length, target, false) - 1;
        return res;
    }

    private int searchNode(int[] nums, int low, int high, int target, boolean flag) {
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target || (flag && nums[mid] == target))
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }
}
