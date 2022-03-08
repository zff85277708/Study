package com.leetcode.medium;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;

        int len = nums.length;
        int index = 0;
        for (int i = len - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                index = i;
                for (int j = len - 1; j >= i; j--) {
                    if (nums[i - 1] < nums[j]) {
                        int tmp = nums[i - 1];
                        nums[i - 1] = nums[j];
                        nums[j] = tmp;
                        break;
                    }
                }
                break;
            }
        }
        System.out.println(index);
        swap(index, len - 1, nums);
    }

    private void swap(int idx1, int idx2, int[] nums) {
        while (idx1 < idx2) {
            int tmp = nums[idx1];
            nums[idx1] = nums[idx2];
            nums[idx2] = tmp;
            idx1++;
            idx2--;
        }
    }

    public static void main(String[] args) {
        NextPermutation np = new NextPermutation();
        int[] nums = {1, 3, 2};
        np.nextPermutation(nums);
        for (int a : nums) {
            System.out.print(a + ",");
        }
        System.out.println();
    }
}
