package com.test;

public class FirstAndLastPosSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int[] result  = {-1,-1};

        if(nums.length ==0) return result;
        if(nums.length ==1) {
            // Fix here
            if(nums[left] == target ){
                result[0] = result[1] = left;
            }
            return result;
        }

        if(nums.length ==2) {
            // Fix here
            if(nums[left] == target && nums[right] == target ){
                result[0]  = result[1] = left;
            }
            if(nums[right] == target && nums[left] != target ){
                result[0]  = result[1] = right;
            } else
            if(nums[right] != target && nums[left] == target ){
                result[0]  = result[1] = left;
            }

            return result;
        }

        while (left < right){
            int mid = left + ((right - left) / 2);
            if(nums[mid] < target){
                left = mid+1;
            }
            else  {
                right = mid;
            }
        }

        result[0] = nums[left] == target ?left: -1;
        right = nums.length-1;
        while (left < right){
            int mid = left + ((right - left) / 2);

            if(nums[mid] < target || nums[mid] == target){
                left = mid+1;
            }
            else  {
                right = mid;
            }
        }

        result[1] = nums[left-1] == target ? left-1 : -1;
        if(nums[nums.length-1] == target)  result[1] = nums.length-1;
        return result;

    }

    public static void main(String[] args) {
        FirstAndLastPosSortedArray sortedArray = new FirstAndLastPosSortedArray();
        int[] nums = {5,7,7,8,8,8,8,8,10,11,13};
        int[] result = sortedArray.searchRange(nums,8);
        System.out.println(" Result is "+ result[0]+" : "+ result[1]);

        int[] nums2 = {5,7,7,8,8,10,11};
        int[] result2 = sortedArray.searchRange(nums2,8);
        System.out.println(" Result is "+ result2[0]+" : "+ result2[1]);

        int[] nums3 = {5,7,7,8,8,10,12};
        int[] result3 = sortedArray.searchRange(nums3,6);
        System.out.println(" Result is "+ result3[0]+" : "+ result3[1]);

        int[] nums4 = {1};
        int[] result4 = sortedArray.searchRange(nums4,1);
        System.out.println(" Result is "+ result4[0]+" : "+ result4[1]);

        int[] num5 = {2,2,2,2};
        int[] result5 = sortedArray.searchRange(num5,2);
        System.out.println(" Result is "+ result5[0]+" : "+ result5[1]);

        int[] num6 = {12};
        int[] result6 = sortedArray.searchRange(num6,12);
        System.out.println(" Result is "+ result6[0]+" : "+ result6[1]);


        int[] num7 = {2,2};
        int[] result7 = sortedArray.searchRange(num7,1);
        System.out.println(" Result is "+ result7[0]+" : "+ result7[1]);

        int[] num8 = {1,2};
        int[] result8 = sortedArray.searchRange(num8,1);
        System.out.println(" Result is "+ result8[0]+" : "+ result8[1]);

        int[] num9 = {1,2};
        int[] result9 = sortedArray.searchRange(num9,2);
        System.out.println(" Result is "+ result9[0]+" : "+ result9[1]);
    }
}
