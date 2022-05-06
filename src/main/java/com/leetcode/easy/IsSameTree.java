package com.leetcode.easy;

import com.leetcode.etc.TreeNode;

public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean res = xxbl(p, q);
        if (!res) return false;
        return zxbl(p, q);
    }

    private boolean xxbl(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p != null && q == null) return false;
        if (p == null) return false;
        if (p.val != q.val) return false;
        boolean res = xxbl(p.left, q.left);
        if (!res) return false;
        return xxbl(p.right, q.right);
    }

    private boolean zxbl(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p != null && q == null) return false;
        if (p == null) return false;
        boolean res = xxbl(p.left, q.left);
        if (!res) return false;
        if (p.val != q.val) return false;
        return xxbl(p.right, q.right);
    }
}
