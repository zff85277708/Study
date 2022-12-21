package com.leetcode.medium;

import com.algorithm.ArrayQueue;
import com.leetcode.etc.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> bfs = new ArrayDeque<>();

        if (root != null) bfs.add(root);

        while (!bfs.isEmpty()) {
            int n = bfs.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = bfs.poll();
                list.add(node.val);
                if (node.left != null) bfs.add(node.left);
                if (node.right != null) bfs.add(node.right);
            }
            res.add(list);
        }

        return res;
    }
}
