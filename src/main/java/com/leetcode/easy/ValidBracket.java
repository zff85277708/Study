package com.leetcode.easy;

import java.util.Stack;

public class ValidBracket {
    public boolean isValid(String s) {
        if (0 == s.length()) return true;
        Stack<Character> stack = new Stack<>();
        stack.add(' ');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('(' == c || '{' == c || '[' == c) {
                stack.add(c);
            } else if (')' == c) {
                if ('(' != stack.pop())
                    return false;
            } else if ('}' == c) {
                if ('{' != stack.pop())
                    return false;
            } else if (']' == c) {
                if ('[' != stack.pop())
                    return false;
            }
        }
        stack.pop();
        return stack.isEmpty();
    }
}
