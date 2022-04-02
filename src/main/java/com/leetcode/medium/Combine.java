package com.leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) return res;

        Deque<Integer> deque = new ArrayDeque<>();
        dfs(n, k, 1, deque, res);
        return res;
    }

    private void dfs(int n, int k, int begin, Deque<Integer> deque, List<List<Integer>> res) {
        if (deque.size() == k) {
            res.add(new ArrayList<>(deque));
            return;
        }

        for (int i = begin; i <= n - (k - deque.size()) + 1; i++) {
            deque.addLast(i);
            dfs(n, k, i + 1, deque, res);
            deque.removeLast();
        }
    }
}
