package com.leetcode.easy;

public class LuomaChangeInt {
    public int romanToInt(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            try {
                if (getValue(s.charAt(i)) >= getValue(s.charAt(i+1))) {
                    sum += getValue(s.charAt(i));
                } else {
                    sum -= getValue(s.charAt(i));
                }
            } catch (IndexOutOfBoundsException e) {
                sum += getValue(s.charAt(i));
            }
        }
        return sum;
    }

    private int getValue(char ch) {
        int result = 0;
        switch (ch) {
            case 'I' : result = 1;break;
            case 'V' : result = 5;break;
            case 'X' : result = 10;break;
            case 'L' : result = 50;break;
            case 'C' : result = 100;break;
            case 'D' : result = 500;break;
            case 'M' : result = 1000;break;
        }
        return result;
    }

    public static void main(String[] args) {
        LuomaChangeInt change = new LuomaChangeInt();
        System.out.println(change.romanToInt("LVIII"));
    }
}
