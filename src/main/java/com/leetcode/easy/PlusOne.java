package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if (digits[len - 1] < 9) {
            digits[len - 1]++;
            return digits;
        }

        boolean flag = true;
        List<Integer> list = new ArrayList<>();
        for (int i = len - 1; i >= 0; i--) {
            if (flag) digits[i]++;
            if (digits[i] == 10) {
                list.add(0);
                flag = true;
            } else {
                flag = false;
                list.add(digits[i]);
            }
        }
        if (flag) list.add(1);

        int[] res = new int[list.size()];
        for (int i = list.size() - 1; i >= 0; i--) {
            res[list.size() - 1 - i] = list.get(i);
        }

        return res;
    }
}
