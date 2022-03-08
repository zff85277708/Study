package com.leetcode.medium;

import java.util.Arrays;

public class NearThreeNumSum {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        int len = nums.length;

        for (int first = 0; first < len; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) continue;
            int second = first + 1;
            int thrid = len - 1;
            while (second < thrid) {
                int sum = nums[first] + nums[second] + nums[thrid];
                if (sum == target) return sum;
                res = Math.abs(sum - target) > Math.abs(res - target) ? res : sum;
                if (sum < target) second++;
                else thrid--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new NearThreeNumSum().threeSumClosest(
                new int[] {-1,2,1,-4}, 1
        ));
    }
}
