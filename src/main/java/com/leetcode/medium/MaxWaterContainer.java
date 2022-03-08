package com.leetcode.medium;

public class MaxWaterContainer {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        while (i != j) {
            int z = Math.min(height[i], height[j]);
            int area = z * (j - i);
            max = max > area ? max : area;
            if (z == height[i]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {0,1,2};
        System.out.println(a[0]);
        change(a);
        System.out.println(a[0]);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hh");
    }

    public static void change(int[] a ){
        int[] b = {3,4,5};
        a = b;
        a[0] = 10;
    }
}
