package com.leetcode.medium;

import com.leetcode.etc.ListNode;

public class LiangShuXiangJia {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3;
        ListNode head = new ListNode(0);
        l3 = head;
        int flag = 0;
        while (l1 != null || l2 != null) {
            l3.next = new ListNode(0);
            if (l1 != null && l2 != null) {
                if ((l1.val + l2.val + flag) >= 10) {
                    l3.next.val = (l1.val + l2.val + flag) % 10;
                    flag = 1;
                } else {
                    l3.next.val = l1.val + l2.val + flag;
                    flag = 0;
                }
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                if ((l1.val + flag) >= 10) {
                    l3.next.val = (l1.val + flag) % 10;
                    flag = 1;
                } else {
                    l3.next.val = l1.val + flag;
                    flag = 0;
                }
                l1 = l1.next;
            }else {
                if ((l2.val + flag) > 9) {
                    l3.next.val = (l2.val + flag) % 10;
                    flag = 1;
                } else {
                    l3.next.val = l2.val + flag;
                    flag = 0;
                }
                l2 = l2.next;
            }
            l3 = l3.next;
        }

        if (1 == flag) {
            l3.next = new ListNode(0);
            l3.next.val = flag;
        }
        return head.next;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode l3 = head;
        int flag = 0;
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + flag;
            flag = sum/10;
            l3.next = new ListNode(sum % 10);
            l3 = l3.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (1 == flag)
            l3.next = new ListNode(flag);
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(6);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new LiangShuXiangJia().addTwoNumbers1(l1, l2);

        System.out.println(l1 + " + " + l2 + " = " + l3);
    }
}
