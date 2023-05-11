package com.test.sorting;

public class BubbleSort {

    private static int[] sort(int[] nums) {
        int outerIndex = 0;
        while (outerIndex < nums.length) {
            for (int indx = 1; indx + outerIndex < nums.length; indx++) {
                if (nums[indx] < nums[indx - 1]) {
                    int tmp = nums[indx];
                    nums[indx] = nums[indx - 1];
                    nums[indx - 1] = tmp;
                }
            }
            outerIndex++;
        }
        return nums;
    }

    private static int[] sortIt(int[] nums) {
        int outerIndex = 0;
        int bucket = (int) Math.sqrt(nums.length);
        while (outerIndex < nums.length) {
            int indx = 1;
            while ( indx + outerIndex < nums.length){
//            for (int indx = 1; indx + outerIndex < nums.length; indx++) {
                if (nums[indx] < nums[indx - 1]) {
                    int tmp = nums[indx];
                    nums[indx] = nums[indx - 1];
                    nums[indx - 1] = tmp;
                }
                indx++;
            }
            outerIndex++;
        }
        return nums;
    }

    private static void printAll(int[] nums) {
        System.out.println("\n-------------- Start --------------------");
        for (int indx = 0; indx < nums.length; indx++) {
            System.out.print(nums[indx] + " , ");
        }
        System.out.println("\n-------------- End   --------------------");
    }

    public static void main(String[] args) {
        int[] nums = {7, 9, 11, 1, 5, 12, 7, 3, 2};
        int[] sortedNums = BubbleSort.sort(nums);
        BubbleSort.printAll(sortedNums);
    }


}
