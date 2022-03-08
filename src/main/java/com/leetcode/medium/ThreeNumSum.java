package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeNumSum {
    private List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        if (null == nums || nums.length < 3) return listList;
        int len = nums.length;
        Arrays.sort(nums);
        for(int first = 0; first < len; first++) {
            if (nums[first] > 0) break;
            if (first > 0 && nums[first] == nums[first - 1]) continue;
            int thrid = len - 1;
            int second = first + 1;
            while (second < thrid) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    second++;
                    continue;
                }
                if (thrid < len - 1 && nums[thrid] == nums[thrid + 1]) {
                    thrid--;
                    continue;
                }
                int sum = nums[first] + nums[second] + nums[thrid];
                if (0 == sum) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[thrid]);
                    listList.add(list);
                    second++;
                    thrid--;
                } else if (sum > 0) {
                    thrid--;
                } else {
                    second++;
                }
            }
        }
        return listList;
    }

    public static void main(String[] args) {
        List<List<Integer>> listList =  new ThreeNumSum().threeSum(
                new int[] {-3,-2,-1,0,1,2,3});
        for (List<Integer> list: listList) {
            System.out.println(list);
        }
    }
}
