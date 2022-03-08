package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourNumSum {
    private List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> listList = new ArrayList<>();
        if (null == nums || nums.length < 4) return listList;
        int len = nums.length;
        Arrays.sort(nums);

        for (int first = 0; first < len; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) continue;
            for (int second = first + 1; second < len; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1])
                    continue;
                int third = second + 1;
                int fourth = len - 1;
                while (third < fourth) {
                    if (third > second + 1 && nums[third] == nums[third - 1]) {
                        third++;
                        continue;
                    }
                    if (fourth < len - 1 && nums[fourth] == nums[fourth + 1]) {
                        fourth--;
                        continue;
                    }
                    int sum = nums[first] + nums[second] + nums[third] + nums[fourth];
                    if (sum == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[first]);
                        list.add(nums[second]);
                        list.add(nums[third]);
                        list.add(nums[fourth]);
                        listList.add(list);
                        third++;
                        fourth--;
                    } else if (sum < target){
                        third++;
                    } else {
                        fourth--;
                    }
                }
            }
        }
        return listList;
    }

    public static void main(String[] args) {
        List<List<Integer>> listList = new FourNumSum().fourSum(
                new int[] {1, 0, -1, 0, -2, 2},
                0
        );
        for (List<Integer> list : listList) {
            System.out.println(list);
        }
    }
}
