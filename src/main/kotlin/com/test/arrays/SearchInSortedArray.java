package com.test.arrays;

public class SearchInSortedArray {
    public int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length-1;
        int mid; // TODO: Fix here
        while (low<=high){
             mid = low+(high-low)/2; // TODO: Fix here (Binary search)
            if(target == nums[mid]){
                return mid;
            } else if(nums[mid] >= nums[low]){ // leftside
                if(target < nums[mid] && target > nums[low]){
                    high = mid-1;
                } else {
                    low = mid+1;
                }

            } else if(nums[mid] <= nums[high]){ // rightside

                if(target > nums[mid] && target < nums[high]){
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SearchInSortedArray inSortedArray = new SearchInSortedArray();
        int [] nums = {4,5,6,7,0,1,2};
        System.out.println(inSortedArray.search(nums,4));

    }
}
