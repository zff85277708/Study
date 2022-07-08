package com.leetcode.easy;

import com.leetcode.etc.ListNode;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode newHead = new ListNode(0);
        ListNode next = head;
        while (next != null) {
            ListNode tmp = next.next;
            next.next = newHead.next;
            newHead.next = next;
            next = tmp;
        }

        return newHead.next;
    }
}
