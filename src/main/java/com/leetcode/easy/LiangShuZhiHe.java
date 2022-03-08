package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class LiangShuZhiHe {
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    return new int[] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] towSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
                return new int[] {i, map.get(target - nums[i])};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] towSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {2,2,3,4,5};
        int target = 5;
        LiangShuZhiHe lszh = new LiangShuZhiHe();

        int[] result = lszh.twoSum1(nums, target);
        for (int num : result) {
            System.out.println(num);
        }

        result = lszh.towSum2(nums, target);
        for (int num : result) {
            System.out.println(num);
        }

        result = lszh.towSum3(nums, target);
        for (int num : result) {
            System.out.println(num);
        }
    }
}
