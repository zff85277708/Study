package com.leetcode.medium;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] strings = path.split("/");
        stack.push("/");
        for (String s : strings) {
            if ("".equals(s) || ".".equals(s)) continue;
            if ("..".equals(s)) {
                String tmp = stack.pop();
                if ("/".equals(tmp)) stack.push("/");
            } else {
                stack.push(s);
            }
        }

        StringBuilder builder = new StringBuilder();
        for (String s : stack) {
            if ("/".equals(s)) continue;
            builder.append("/");
            builder.append(s);
        }

        String ss = builder.toString();
        if ("".equals(ss)) ss = "/";
        return ss;
    }

    public static void main(String[] args) {
        System.out.println(new SimplifyPath().simplifyPath("/../"));
    }
}
