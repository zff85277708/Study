package com.leetcode.medium;

import com.leetcode.etc.TreeNode;

import java.util.*;

public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        boolean left = true;

        if (root != null) queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                assert node != null;
                list.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            if (!left) {
                List<Integer> right = new ArrayList<>();
                for (int i = list.size() - 1; i >= 0; i--) {
                    right.add(list.get(i));
                }
                res.add(right);
            } else {
                res.add(list);
            }
            left = !left;
        }
        return res;
    }
}
