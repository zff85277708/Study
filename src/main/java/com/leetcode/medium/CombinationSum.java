package com.leetcode.medium;

import java.util.*;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> listList = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, candidates.length, 0,
                new ArrayDeque<>(), target, listList);
        return listList;
    }

    private void dfs(int[] candidates, int len, int begin,
                     Deque<Integer> deque, int target, List<List<Integer>> listList) {
        if (target == 0) {
            listList.add(new ArrayList<>(deque));
            return;
        }

        for (int i = begin; i < len; i++) {
            if (candidates[i] > target) break;
            deque.addLast(candidates[i]);
            dfs(candidates, len, i,
                    deque, target - candidates[i], listList);
            deque.removeLast();
        }
    }
}
