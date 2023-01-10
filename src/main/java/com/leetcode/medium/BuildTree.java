package com.leetcode.medium;

import com.leetcode.etc.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {
    private final Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) return null;

        TreeNode root = new TreeNode(preorder[preLeft]);
        int rootIndex = map.get(preorder[preLeft]);
        int size = rootIndex - inLeft;
        root.left = buildTree(preorder, inorder, preLeft + 1, preLeft + size,
                inLeft, rootIndex - 1);
        root.right = buildTree(preorder, inorder, preLeft + size + 1, preRight,
                rootIndex + 1, inRight);
        return root;
    }
}
