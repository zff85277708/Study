package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    private String[] numsStr = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private List<String> list = new ArrayList<>();

    private List<String> letterCombinations(String digits) {
        if (null == digits || 0 == digits.length()) return list;
        iterStr(digits, "", 0);
        return list;
    }

    private void iterStr(String digits, String res, int index) {
        if (index == digits.length()) {
            list.add(res);
            return;
        }

        String mapString = numsStr[digits.charAt(index) - '0' - 2];

        for (int i = 0; i < mapString.length(); i++) {
            iterStr(digits, res + mapString.charAt(i), index + 1);
        }
    }

    public static void main(String[] args) {
        List<String> list  = new LetterCombinations().letterCombinations("23487");
        for (String string : list)
            System.out.println(string);
    }
}
