package com.leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len <= 0) return res;

        res.add(new ArrayList<>());
        for (int i = 1; i <= len; i++) {
            combine(nums, i, res);
        }

        return res;
    }

    private void combine(int[] nums, int k, List<List<Integer>> res) {
        if (k <= 0 || nums.length < k) return;

        Deque<Integer> deque = new ArrayDeque<>();
        dfs(nums, k, 0, deque, res);
    }

    private void dfs(int[] nums, int k, int begin, Deque<Integer> deque, List<List<Integer>> res) {
        if (k == deque.size()) {
            res.add(new ArrayList<>(deque));
            return;
        }

        for (int i = begin; i < nums.length - (k - deque.size()) + 1; i++) {
            deque.addLast(nums[i]);
            dfs(nums, k, i + 1, deque, res);
            deque.removeLast();
        }
    }

    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length <= 0) return res;

        Deque<Integer> deque = new ArrayDeque<>();
        dfs1(nums, 0, deque, res);
        return res;
    }

    private void dfs1(int[] nums, int begin, Deque<Integer> deque, List<List<Integer>> res) {
        res.add(new ArrayList<>(deque));

        for (int i = begin; i < nums.length; i++) {
            deque.addLast(nums[i]);
            dfs1(nums, i + 1, deque, res);
            deque.removeLast();
        }
    }
}
