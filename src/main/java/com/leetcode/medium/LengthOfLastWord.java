package com.leetcode.medium;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0)
            return 0;

        char[] arrs = s.toCharArray();
        int index1 = -1, index2 = -1;

        for (int i = arrs.length -1; i >= 0; i--) {
            if (arrs[i] != ' ' && index1 == -1)
                index1 = i;

            if (index1 != -1 && arrs[i] == ' ') {
                index2 = i;
                break;
            }
        }

        if (index1 == -1) return 0;
        else return index2 == -1 ? index1 + 1 : index1 - index2;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLastWord().lengthOfLastWord(" d"));
    }
}
