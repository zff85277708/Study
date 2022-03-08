package com.leetcode.medium;

import com.leetcode.etc.ListNode;

import java.util.HashMap;
import java.util.Map;

public class RemoveListNodeN {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (null == head) return null;
        int length = 0;
        Map<Integer, ListNode> map = new HashMap<>();
        while (head != null) {
            map.put(length, head);
            head = head.next;
            length++;
        }

        int index = length - n - 1;
        if (-1 == index) {
            return map.get(0).next;
        } else {
            map.get(index).next = map.get(index + 1).next;
            return map.get(0);
        }
    }
}
