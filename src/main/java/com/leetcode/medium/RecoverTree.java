package com.leetcode.medium;

import com.leetcode.etc.TreeNode;

public class RecoverTree {
    private TreeNode pre = null;
    private TreeNode x = null;
    private TreeNode y = null;

    public void recoverTree(TreeNode root) {
        dfs(root);
        if (x != null && y != null) {
            int tmp = x.val;
            x.val = y.val;
            y.val = tmp;
        }
    }

    private void dfs(TreeNode node) {
        if (null == node) return;

        dfs(node.left);
        if (null == pre) {
            pre = node;
        } else {
            if (pre.val > node.val) {
                y = node;
                if (null == x) x = pre;
            }
            pre = node;
        }
        dfs(node.right);
    }
}
