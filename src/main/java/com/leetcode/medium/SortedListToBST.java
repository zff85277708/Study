package com.leetcode.medium;

import com.leetcode.etc.ListNode;
import com.leetcode.etc.TreeNode;

public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        return helper(head, null);
    }

    private TreeNode helper(ListNode left, ListNode right) {
        if (left == right) return null;

        ListNode mid = getMid(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = helper(left, mid);
        root.right = helper(mid.next, right);
        return root;
    }

    private ListNode getMid(ListNode left, ListNode right) {
        ListNode fast = left;
        ListNode slow = left;
        while (fast != right && fast.next != right) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
