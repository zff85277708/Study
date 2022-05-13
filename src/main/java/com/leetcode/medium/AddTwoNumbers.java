package com.leetcode.medium;

import com.leetcode.etc.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        int flag = 0;
        ListNode l3 = head;

        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + flag;
            flag = sum / 10;
            l3.next = new ListNode(sum % 10);
            l3 = l3.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        if (1 == flag)
            l3.next = new ListNode(1);

        return head.next;
    }
}
