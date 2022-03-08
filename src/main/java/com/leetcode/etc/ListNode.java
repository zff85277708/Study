package com.leetcode.etc;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode (int val) {
        this.val = val;
    }

    public ListNode () {
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        ListNode ln = this;
        StringBuilder s = new StringBuilder();
        while (ln != null) {
            s.append(ln.val);
            ln = ln.next;
        }
        return s.reverse().toString();
    }
}
