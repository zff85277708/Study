package com.leetcode.medium;

import com.leetcode.etc.ListNode;

public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode next = head;
        int len = 1;
        while (next.next != null) {
            next = next.next;
            len++;
        }

        for (int i = 0; i < k % len; i++) {
            next = head;
            ListNode buttom = head;
            while (next.next != null) {
                next = next.next;
                if (next.next != null) buttom = next;
            }
            buttom.next = null;
            next.next = head;
            head = next;
        }
        return head;
    }
}
