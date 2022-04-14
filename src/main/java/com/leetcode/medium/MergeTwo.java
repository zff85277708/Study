package com.leetcode.medium;

public class MergeTwo {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                nums[k++] = nums1[i++];
            } else {
                nums[k++] = nums2[j++];
            }
        }

        while (i < m) nums[k++] = nums1[i++];
        while (j < n) nums[k++] = nums2[j++];

        for (int z = 0; z < nums.length; z++)
            nums1[z] = nums[z];

    }

    public static void main(String[] args) {
        System.out.println();
    }
}
