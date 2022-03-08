package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        if (nums.length <= 0) return listList;

        int[] flags = new int[nums.length];
        def(listList, new ArrayList<>(), nums, flags);
        return listList;
    }

    private void def(List<List<Integer>> listList, List<Integer> list,
                     int[] nums, int[] flags) {
        if (list.size() == nums.length) {
            listList.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (flags[i] == 1) continue;
            flags[i] = 1;
            list.add(nums[i]);
            def(listList, list, nums, flags);
            list.remove(list.size() - 1);
            flags[i] = 0;
        }
    }

    public static void main(String[] args) {
        Permute permute = new Permute();
        List<List<Integer>> lists = permute.permute(new int[] {1,2,3});
        for (List<Integer> list : lists) {
            for (int i : list) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }
}
