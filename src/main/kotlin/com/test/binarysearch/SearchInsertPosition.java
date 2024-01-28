package com.test.binarysearch;
// https://leetcode.com/problems/search-insert-position
//Given a sorted array of distinct integers and a target value, return the index if the target is found.
// If not, return the index where it would be if it were inserted in order.
//
//You must write an algorithm with O(log n) runtime complexity.
//
//
//
//Example 1:
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
//
//
//Constraints:
//
//1 <= nums.length <= 104
//-104 <= nums[i] <= 104
//nums contains distinct values sorted in ascending order.
//-104 <= target <= 104
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        // int middle = (end - start)/2;
        //  System.out.println("Array is "+ Arrays.toString(nums) + " target is " + target);
        while (start <= end){
            int middle = (end + start)/2;
            //  System.out.println("Start start is " + start + " end is "+ end + " middle is "+middle);
            if(nums[middle] < target) {
                start = middle+1;
            } else {
                end = middle-1;
            }

            if(nums[middle] == target){
                return middle;
            }
            //    System.out.println("End start is " + start + " end is "+ end + " middle is "+middle);
        }
        return start;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        System.out.println(searchInsertPosition.searchInsert(nums, 5));

    }
}
