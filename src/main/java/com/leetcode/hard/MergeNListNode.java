package com.leetcode.hard;

import com.leetcode.etc.ListNode;

public class MergeNListNode {
    public ListNode mergeKLists(ListNode[] lists) {
        if (null == lists || lists.length <= 0) return null;

        int length = lists.length;
        int count = 0;
        int index = -1;
        for (int i = 0; i < length; i++) {
            if (null == lists[i]) {
                count++;
                continue;
            }
            index = -1 == index ? i :
                    lists[i].val < lists[index].val ? i : index;
        }
        if (length == count + 1) return lists[index];
        if (-1 == index) return null;

        ListNode temp = lists[index];
        lists[index] = lists[index].next;
        temp.next = mergeKLists(lists);

        return temp;
    }
}
