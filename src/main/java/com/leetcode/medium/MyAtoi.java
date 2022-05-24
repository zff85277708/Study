package com.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class MyAtoi {
    public int myAtoi(String s) {
        Automaton automaton = new Automaton();
        for (int i = 0; i < s.length(); i++) {
            automaton.get(s.charAt(i));
        }
        long res = automaton.getSign() * automaton.getAns();
        return (int) res;
    }

    public static class Automaton{
        private static final Map<String, String[]> table = new HashMap<>();
        private String state = "start";
        private long ans = 0;
        private int sign = 1;

        static {
            table.put("start", new String[]{"start", "signed", "in_number", "end"});
            table.put("signed", new String[]{"end", "end", "in_number", "end"});
            table.put("in_number", new String[]{"end", "end", "in_number", "end"});
            table.put("end", new String[]{"end", "end", "end", "end"});
        }

        public void get(char c) {
            state = table.get(state)[get_col(c)];
            if ("in_number".equals(state)) {
                ans = ans * 10 + c - '0';
                ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
            } else if ("signed".equals(state)) {
                sign = c == '+' ? 1 : -1;
            }
        }

        private int get_col(char c) {
            if (' ' == c) return 0;
            if ('+' == c || '-' == c) return 1;
            if (Character.isDigit(c)) return 2;
            else return 3;
        }

        public long getAns() {
            return ans;
        }

        public int getSign() {
            return sign;
        }
    }

    public static void main(String[] args) {
        MyAtoi atoi = new MyAtoi();
        System.out.println(atoi.myAtoi(" -42"));
    }
}
