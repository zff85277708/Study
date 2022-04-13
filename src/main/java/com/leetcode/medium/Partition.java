package com.leetcode.medium;

import com.leetcode.etc.ListNode;

public class Partition {
    public ListNode partition(ListNode head, int x) {
        if (null == head || null == head.next)
            return head;

        ListNode next = head;
        ListNode head1 = new ListNode(0);
        ListNode next1 = head1;
        ListNode head2 = new ListNode(0);
        ListNode next2 = head2;

        while (next != null) {
            if (next.val < x) {
                next1.next = next;
                next1 = next1.next;
            } else {
                next2.next = next;
                next2 = next2.next;
            }
            next = next.next;
        }
        next1.next = null;
        next2.next = null;

        if (head1.next == null)
            return head2.next;
        else
            next1.next = head2.next;

        return head1.next;
    }

    public static void main(String[] args) {
        Partition partition = new Partition();
        ListNode head = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2, null))))));
        System.out.println(head);
        partition.partition(head, 3);
        System.out.println(head);
    }
}
