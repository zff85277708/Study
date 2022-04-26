package com.leetcode.medium;

import com.leetcode.etc.ListNode;

public class ReverseBetween1 {
    private ListNode successor = null;

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (1 == left)
            return reverseN(head, right);

        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    private ListNode reverseN(ListNode head, int n) {
        if (1 == n) {
            successor = head.next;
            return head;
        }

        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    public static void main(String[] args) {
        ReverseBetween1 reverseBetween = new ReverseBetween1();
        ListNode head = new ListNode(3, new ListNode(5));
        System.out.println(reverseBetween.reverseBetween(head, 1, 2));
    }
}
