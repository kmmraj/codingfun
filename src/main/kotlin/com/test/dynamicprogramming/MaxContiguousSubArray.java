package com.test.dynamicprogramming;

public class MaxContiguousSubArray {

    int maxSubarraySum(int arr[], int n){


//      return solveItRecursively(arr,0,Integer.MIN_VALUE);

      if(arr.length>0)
          return solveItRecursivelyWithKenedeAlgo(arr,0,Integer.MIN_VALUE,0);
      else
          return 0;
    }

    int solveItRecursively(int[] nums, int index, int maxSum){
        // BC
        if(index == nums.length)
            return 0;

        // CD and Hypothesis
        maxSum = Math.max(nums[index],nums[index] + solveItRecursively(nums,index+1,maxSum));


        // Induction
        return maxSum;
    }

    int solveItRecursivelyWithKenedeAlgo(int[] nums, int index, int maxSoFar, int maxEndingHere){
        // BC
        if(index == nums.length)
            return maxSoFar;

       // Did the current number is greater than sum until here
        maxEndingHere = Math.max(nums[index],maxEndingHere + nums[index]);
        // Did we beat the 'maxSoFar' with the 'maxEndingHere'?
        maxSoFar = Math.max(maxSoFar, maxEndingHere);
        return solveItRecursivelyWithKenedeAlgo(nums,index+1,maxSoFar,maxEndingHere);
    }

    public static void main(String[] args) {
        MaxContiguousSubArray subArray = new MaxContiguousSubArray();
        int[] nums1 = {1,2,3,-2,5};

        System.out.println(subArray.maxSubarraySum(nums1,nums1.length));

       // int[] nums2 = {-1,-2,-3,-4,5,1,-9,1,2,3,-7};
        int[] nums2 = {1,2,3,-9,5,6,7};
        System.out.println(subArray.maxSubarraySum(nums2,nums2.length));
    }
}
