package com.leetcode.medium;

import com.leetcode.etc.ListNode;

import java.util.Stack;

public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;

        ListNode newHead = new ListNode(0);
        ListNode newNext = newHead;
        int start = 1;
        while (start < left) {
            newNext.next = head;
            head = head.next;
            newNext = newNext.next;
            start++;
        }

        Stack<ListNode> stack = new Stack<>();
        while (start <= right) {
            stack.push(head);
            head = head.next;
            start++;
        }

        while (!stack.isEmpty()) {
            newNext.next = stack.pop();
            newNext = newNext.next;
        }

        while (head != null) {
            newNext.next = head;
            head = head.next;
            newNext = newNext.next;
        }

        return newHead.next;
    }

    public static void main(String[] args) {
        ReverseBetween reverseBetween = new ReverseBetween();
        ListNode head = new ListNode(3, new ListNode(5));
        System.out.println(reverseBetween.reverseBetween(head, 1, 2));
    }
}
