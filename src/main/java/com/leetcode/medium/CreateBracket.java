package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class CreateBracket {
    private List<String> list = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if (n <= 0) return list;

        create("", n, n);
        return list;
    }

    private void create(String res, int left, int right) {
        if (0 == left && 0 == right) {
            list.add(res);
            return;
        }

        if (left > right) return;
        if (left > 0) create(res + "(", left - 1, right);
        if (right > 0) create(res + ")", left, right - 1);
    }

    public List<String> generateParenthesis1(int n) {
        if (n <= 0) return new ArrayList<>();

        List<List<String>> listList = new ArrayList<>();
        List<String> list0 = new ArrayList<>();
        list0.add("");
        listList.add(list0);

        for (int i = 1; i <= n; i++) {
            List<String> listi = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> list1 = listList.get(j);
                List<String> list2 = listList.get(i - j -1);
                for (String str1 : list1) {
                    for (String str2 : list2) {
                        listi.add("(" + str1 + ")" + str2);
                    }
                }
            }
            listList.add(listi);
        }
        return listList.get(n);
    }
}
