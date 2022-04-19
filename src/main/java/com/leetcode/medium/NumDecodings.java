package com.leetcode.medium;

public class NumDecodings {
    public int numDecodings(String s) {
        int n = s.length();
        int Ai_2 = 0;
        int Ai_1 = 1;
        int Ai = 0;

        for (int i = 0; i < n; i++) {
            Ai = 0;
            if (s.charAt(i) != '0')
                Ai = Ai_1;
            if (i > 0 && s.charAt(i - 1) != '0' && (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0') <= 26)
                Ai += Ai_2;
            Ai_2 = Ai_1;
            Ai_1 = Ai;
        }

        return Ai;
    }

    public static void main(String[] args) {
        String s = "12";
        System.out.println(new NumDecodings().numDecodings(s));
    }
}
