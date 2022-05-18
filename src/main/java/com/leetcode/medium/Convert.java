package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Convert {
    public String convert(String s, int numRows) {
        if (numRows < 2) return s;

        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }

        int flag = -1;
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            list.get(idx).append(s.charAt(i));
            if (0 == idx || numRows - 1 == idx)
                flag = -flag;
            idx += flag;
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder builder : list) {
            res.append(builder);
        }

        return res.toString();
    }
}
