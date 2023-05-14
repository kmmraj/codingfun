package com.test.arrays;

public class FindUniqueElementsLength {

    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        for(int indx=1; indx<=nums.length-1; indx++) {
            if(nums[indx-1] == nums[indx]){
                length--;
            }
        }
        return length;
    }

    public int removeDuplicatesArray(int[] nums) {
        int length = 0;
        for(int indx=1; indx<=nums.length-1; indx++) {

            if(nums[length] != nums[indx]){
                length++;
                nums[length] = nums[indx];
            }

        }
        return length+1;
    }

    public static void main(String[] args) {
        int[] array = {1,1,2,3,4,5,5,7,8};
        FindUniqueElementsLength findUniqueElementsLength = new FindUniqueElementsLength();
//        int length = findUniqueElementsLength.removeDuplicates(array);
        int length = findUniqueElementsLength.removeDuplicatesArray(array);
        System.out.println(length);
    }
}
