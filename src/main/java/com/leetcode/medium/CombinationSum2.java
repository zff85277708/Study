package com.leetcode.medium;

import java.util.*;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> listList = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, candidates.length, target,
                new ArrayDeque<>(), 0, listList);
        return listList;
    }

    private void dfs(int[] candidates, int len, int target,
                     Deque<Integer> deque, int begin, List<List<Integer>> listList) {
        if (target == 0) {
            listList.add(new ArrayList<>(deque));
            return;
        }

        for (int i = begin; i < len; i++) {
            if (candidates[i] > target) break;
            if (i != begin && candidates[i] == candidates[i - 1]) continue;
            deque.addLast(candidates[i]);
            dfs(candidates, len, target - candidates[i],
                    deque, i + 1, listList);
            deque.removeLast();
        }
    }
}
