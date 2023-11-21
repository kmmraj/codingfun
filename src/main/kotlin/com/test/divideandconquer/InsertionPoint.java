// https://leetcode.com/problems/search-insert-position/description/
package com.test.divideandconquer;

public class InsertionPoint {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (high + low) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (target >= nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;

    }

    public static void main(String[] args) {
        InsertionPoint insertionPoint = new InsertionPoint();
        // Example 1:
        //
        //Input: nums = [1,3,5,6], target = 5
        //Output: 2
        //Example 2:
        //
        //Input: nums = [1,3,5,6], target = 2
        //Output: 1
        //Example 3:
        //
        //Input: nums = [1,3,5,6], target = 7
        //Output: 4

        int[] nums = new int[]{1, 3, 5, 6};
        System.out.println("5 can be inserted at " + insertionPoint.searchInsert(nums, 5));

        nums = new int[]{1, 3, 5, 6};
        System.out.println("1 can be inserted at " + insertionPoint.searchInsert(nums, 1));

        System.out.println("7 can be inserted at " + insertionPoint.searchInsert(nums, 7));

    }
}
