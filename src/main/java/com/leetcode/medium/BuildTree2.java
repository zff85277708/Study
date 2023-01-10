package com.leetcode.medium;

import com.leetcode.etc.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BuildTree2 {
    private final Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++)
            map.put(inorder[i], i);

        return buildTree(inorder, postorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder,
                               int inLeft, int inRight, int postLeft, int postRight) {
        if (postLeft > postRight || inLeft > inRight) return null;

        TreeNode root = new TreeNode(postorder[postRight]);
        int rootIndex = map.get(postorder[postRight]);
        int size = rootIndex - inLeft;
        root.left = buildTree(inorder, postorder, inLeft,
                rootIndex - 1, postLeft, postLeft + size - 1);
        root.right = buildTree(inorder, postorder,
                rootIndex + 1, inRight, postLeft + size, postRight - 1);
        return root;
    }

    public static void main(String[] args) {
        BuildTree2 buildTree2 = new BuildTree2();
        buildTree2.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
    }
}
