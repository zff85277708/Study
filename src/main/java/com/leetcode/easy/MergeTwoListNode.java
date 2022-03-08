package com.leetcode.easy;

import com.leetcode.etc.ListNode;

public class MergeTwoListNode {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) return l2;
        if (null == l2) return l1;

        ListNode head,l3;
        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        l3 = head;

        while (l1 != null || l2 != null) {
            if (null == l1) {
                l3.next = l2;
                l2 = l2.next;
            } else if (null == l2) {
                l3.next = l1;
                l1 = l1.next;
            } else {
                if (l1.val < l2.val) {
                    l3.next = l1;
                    l1 = l1.next;
                } else {
                    l3.next = l2;
                    l2 = l2.next;
                }
            }
            l3 = l3.next;
        }
        return head;
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (null == l1) return l2;
        if (null == l2) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }
    }
}
