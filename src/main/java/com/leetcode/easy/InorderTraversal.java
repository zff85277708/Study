package com.leetcode.easy;

import com.leetcode.etc.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        zxbl(root, result);
        return result;
    }

    private void zxbl(TreeNode node, List<Integer> result) {
        if (node == null) return;
        zxbl(node.left, result);
        result.add(node.val);
        zxbl(node.right, result);
    }
}
