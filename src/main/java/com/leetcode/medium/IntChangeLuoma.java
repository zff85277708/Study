package com.leetcode.medium;

public class IntChangeLuoma {
    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC",
                "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (i < 13) {
            while (num >= nums[i]) {
                builder.append(romans[i]);
                num -= nums[i];
            }
            i++;
        }
        return builder.toString();
    }
}
