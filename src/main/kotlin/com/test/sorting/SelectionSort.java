package com.test.sorting;

public class SelectionSort {

    private static int[] sort(int[] nums) {
        int outerIndex = 0;
        while (outerIndex < nums.length) {
            int min = Integer.MAX_VALUE;
            int minIndex= -1;
            for (int indx = outerIndex; indx < nums.length; indx++) {
                if (nums[indx] < min) {
                    min = nums[indx];
                    minIndex = indx;
                }
            }
            swap(nums, outerIndex, min, minIndex);
            outerIndex++;
        }
        return nums;
    }

    private static void swap(int[] nums, int outerIndex, int min, int minIndex) {
        int tmp =  nums[outerIndex];
        nums[outerIndex] = min;
        nums[minIndex] = tmp;
    }

    private static void printAll(int[] nums) {
        System.out.println("\n-------------- Start --------------------");
        for (int indx = 0; indx < nums.length; indx++) {
            System.out.print(nums[indx] + " , ");
        }
        System.out.println("\n-------------- End   --------------------");
    }

    public static void main(String[] args) {
        int[] nums = {7, 9, 11, 1, 5, 12, 10, 3, 2};
        int[] sortedNums = SelectionSort.sort(nums);
        SelectionSort.printAll(sortedNums);
    }


}
