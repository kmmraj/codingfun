package com.test.sorting;

public class AnotherInsertionSort {

    private static int[] sort(int[] nums) {

        for (int indx = 1; indx < nums.length; indx++) {
            int innerIndex = indx;
            while (innerIndex > 0) {
                if (nums[innerIndex] < nums[innerIndex - 1]) {
                    int tmp = nums[innerIndex - 1];
                    nums[innerIndex - 1] = nums[innerIndex];
                    nums[innerIndex] = tmp;
                }
                innerIndex--;
            }
        }

        return nums;
    }

    private static void swap(int[] nums, int outerIndex, int min, int minIndex) {
        int tmp = nums[outerIndex];
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
        int[] nums = {7, 9, 11, 1, 5, 12, 10, 3, 2, -15, 75};
        int[] sortedNums = AnotherInsertionSort.sort(nums);
        AnotherInsertionSort.printAll(sortedNums);
    }


}
