package com.test.arrays;

public class MoveZeros {

    public void moveZeroes(int[] nums) {

        for (int idx = 0; idx <= nums.length-1; idx++) {
            for (int idy =  idx; idy <= nums.length-1; idy++) {
                if(nums[idx] ==0 && nums[idy]!=0){
                    int temp =nums[idx];
                    nums[idx] = nums[idy];
                    nums[idy] = temp;
                }
            }
        }

    }

    private void swap(int one, int two) {
        int temp = one;
        one = two;
        two = temp;
    }

    public static void main(String[] args) {
        MoveZeros zeros = new MoveZeros();
        int[] nums = {0,1,0,3,12};
        zeros.moveZeroes(nums);

        //
        for (int idx = 0; idx < nums.length; idx++) {
            System.out.printf("%d ",nums[idx]);
        }
    }
}
