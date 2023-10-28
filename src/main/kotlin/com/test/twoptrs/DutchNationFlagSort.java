package com.test.twoptrs;

// https://leetcode.com/problems/sort-colors/description/
public class DutchNationFlagSort {
    public void sortColorsOLD(int[] nums) {

        // input = new int[]{2,0,1};
        int start = 0;
        int end = nums.length - 1;
        while (end > start) {
            if (nums[start] == 0) {
                start++;
                continue;
            }
            if (nums[end] == 2) {
                end--;
                continue;
            }
            if (nums[start] == 2 && nums[end] == 0) {
                swap(nums, start, end);
                start++;
                end--;
                continue;
            }
            if (nums[start] > nums[start + 1]) {
                swap(nums, start, start + 1);
                start++;
            }
            if (nums[start] == nums[end]) {
                start++;
                end--;
            }
        }

    }

    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (mid <= end) {
            switch (nums[mid]) {
                case 0:
                    swap(nums, start, mid);
                    start++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(nums, end, mid);
                    end--;
            }
        }
    }

    private static void swap(int[] nums, int end, int mid) {
        int temp = nums[end];
        nums[end] = nums[mid];
        nums[mid] = temp;
    }

    public static void main(String[] args) {
        int[] input = new int[]{2, 0, 2, 1, 1, 0};
        int[] expected = new int[]{0, 0, 1, 1, 2, 2};
//        new DutchNationFlagSort().sortColors(input);
//
//        for (int i = 0; i < input.length; i++) {
//            System.out.printf("%2d ",input[i]);
//        }
//
//        //Input: nums = [2,0,1]
//        //Output: [0,1,2]
//        input = new int[]{2,0,1};
//        expected = new int[]{0,1,2};
//        new DutchNationFlagSort().sortColors(input);
//        System.out.println();
//        for (int i = 0; i < input.length; i++) {
//            System.out.printf("%2d ",input[i]);
//        }
//
//        input = new int[]{1,1};
//        expected = new int[]{1,1};
//        new DutchNationFlagSort().sortColors(input);
//        System.out.println();
//        for (int i = 0; i < input.length; i++) {
//            System.out.printf("%2d ",input[i]);
//        }
//
//        // [1,2,0]
//        input = new int[]{1,2,0};
//        expected = new int[]{0,1,2};
//        new DutchNationFlagSort().sortColors(input);
//        System.out.println();
//        for (int i = 0; i < input.length; i++) {
//            System.out.printf("%2d ",input[i]);
//        }

        // [1,1,0,0,2,1]
        input = new int[]{0, 1, 1, 0, 0, 2, 1, 0};
        expected = new int[]{0, 0, 0, 0, 1, 1, 1, 2};
        new DutchNationFlagSort().sortColors(input);
        System.out.println();
        for (int i = 0; i < input.length; i++) {
            System.out.printf("%2d ", input[i]);
        }
    }
}
