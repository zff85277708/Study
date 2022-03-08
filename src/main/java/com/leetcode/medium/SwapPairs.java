package com.leetcode.medium;

import com.leetcode.etc.ListNode;

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (null == head || null == head.next)
            return head;

        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    public ListNode swapPairs1(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode tmp = pre;

        while (tmp.next != null && tmp.next.next != null) {
            ListNode start = tmp.next;
            ListNode end = tmp.next.next;
            tmp.next = end;
            start.next = end.next;
            end.next = start;
            tmp = start;
        }

        return pre.next;
    }
}
