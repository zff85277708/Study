package com.leetcode.medium;

import com.leetcode.etc.ListNode;

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (null == head) return head;
        ListNode start = head;
        ListNode next = head.next;
        while (next != null) {
            if (next.val == start.val) {
                start.next = next.next;
            } else {
                start = start.next;
            }
            next = next.next;
        }
        return head;
    }
}
