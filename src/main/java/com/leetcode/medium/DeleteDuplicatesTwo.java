package com.leetcode.medium;

import com.leetcode.etc.ListNode;

import java.util.HashMap;
import java.util.Map;

public class DeleteDuplicatesTwo {
    public ListNode deleteDuplicates(ListNode head) {
        if (null == head || null == head.next)
            return head;

        Map<Integer, Integer> map = new HashMap<>();
        ListNode next = head;
        while (next.next != null) {
            if (next.val == next.next.val)
                map.put(next.val, 0);
            next = next.next;
        }

        ListNode newHead = null;
        ListNode newNext = null;
        boolean flag = true;
        next = head;
        while (next != null) {
            if (!map.containsKey(next.val)) {
                if (flag) {
                    newHead = newNext = next;
                    flag = false;
                } else {
                    newNext.next = next;
                    newNext = newNext.next;
                }
            }
            next = next.next;
        }

        if (newNext != null)
            newNext.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        DeleteDuplicatesTwo deleteDuplicates = new DeleteDuplicatesTwo();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5, null)))))));
        System.out.println(head);
        deleteDuplicates.deleteDuplicates(head);
        System.out.println(head);
    }
}
