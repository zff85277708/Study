package com.leetcode.medium;

import com.leetcode.etc.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class IsValidBST {
    private long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (null == root) return true;

        if (!isValidBST(root.left)) return false;
        if (root.val <= pre) return false;
        pre = root.val;
        return isValidBST(root.right);
    }
}
