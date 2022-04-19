package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();
    private boolean[] flags;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (0 == nums.length) return result;

        Arrays.sort(nums);
        flags = new boolean[nums.length];
        dfs(nums, 0);
        return result;
    }

    private void dfs(int[] nums, int start) {
        result.add(new ArrayList<>(list));

        if(start >= nums.length) return;

        for (int i = start; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !flags[i - 1])
                continue;

            list.add(nums[i]);
            flags[i] = true;
            dfs(nums, i + 1);
            list.remove(list.size() -1);
            flags[i] = false;
        }
    }
}
