package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class ZCharacterChange {
    public static String convert(String s, int numRows) {
        if (numRows <= 1) return s;
        if (numRows >= s.length()) return s;

        boolean flag = false;
        int count = 0;
        List<StringBuilder> list = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }

        for (char c : s.toCharArray()) {
            list.get(count).append(c);
            if (0 == count || numRows - 1 == count) flag = !flag;
            count += flag ? 1 : -1;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (StringBuilder builder : list) {
            stringBuilder.append(builder);
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING", 3).
                equals("LCIRETOESIIGEDHN"));
        StringBuilder s = new StringBuilder();
        s.append(-123);
        System.out.println(s);
        s.reverse();
        System.out.println(s);
    }
}
