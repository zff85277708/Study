package com.leetcode.medium;

import com.leetcode.etc.TreeNode;

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }
}
