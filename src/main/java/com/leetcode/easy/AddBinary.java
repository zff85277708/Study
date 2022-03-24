package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class AddBinary {
    public String addBinary(String a, String b) {
        char[] c1 = a.toCharArray();
        char[] c2 = b.toCharArray();
        List<Character> list = new ArrayList<>();
        int end1 = c1.length - 1;
        int end2 = c2.length - 1;
        boolean flag = false;

        while (end1 >= 0 && end2 >= 0) {
            if (flag) {
                switch (c1[end1] + c2[end2] + '1') {
                    case 147 :
                        flag = true;
                        list.add('1');
                        break;
                    case 146 :
                        flag = true;
                        list.add('0');
                        break;
                    case 145 :
                        flag = false;
                        list.add('1');
                        break;
                }
            } else {
                if (c1[end1] == '1' && c2[end2] == '1') {
                    list.add('0');
                    flag = true;
                } else {
                    char c = c1[end1] > c2[end2] ? c1[end1] : c2[end2];
                    list.add(c);
                    flag = false;
                }
            }
            end1--;
            end2--;
        }

        if (end2 < 0) {
            while (end1 >= 0) {
                if (flag) {
                    if (c1[end1] == '1') {
                        flag = true;
                        list.add('0');
                    } else {
                        flag = false;
                        list.add('1');
                    }
                } else {
                    list.add(c1[end1]);
                }
                end1--;
            }
        } else {
            while (end2 >= 0) {
                if (flag) {
                    if (c2[end2] == '1') {
                        flag = true;
                        list.add('0');
                    } else {
                        flag = false;
                        list.add('1');
                    }
                } else {
                    list.add(c2[end2]);
                }
                end2--;
            }
        }

        if (flag) list.add('1');
        StringBuilder builder = new StringBuilder();
        for (char c : list) {
            builder.append(c);
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        char c1 = '1';
        char c2 = '2';
        int a = c1;
        System.out.println(a);
    }
}
