package com.test.arrays;

// https://leetcode.com/problems/product-of-array-except-self/
public class ArrayOfProducts {
    public int[] arrayOfProducts(int[] array) {
        // Write your code here.
        int[] returnArray = new int[array.length];
        int product=1;
        for (int idx = 0; idx < array.length; idx++) {

            int jdx=idx-1;
            while (jdx>=0){
                product = product*array[jdx];
                jdx--;
            }
            int kdx=idx+1;
            while (kdx<array.length){
                product = product*array[kdx];
                kdx++;
            }
            returnArray[idx]=product;
            product=1;
        }

        return returnArray;
    }


    public static int[] arrayOfProductsWLeftAndRightArray(int[] nums){

        int [] rightArray = new int[nums.length];
        int [] leftArray = new int[nums.length];
        leftArray[0] = 1;
        rightArray[nums.length-1] = 1;

        for(int idx=1; idx<nums.length; idx++){
            leftArray[idx] = leftArray[idx-1] * nums[idx-1];
        }

        for (int jdx=nums.length-2; jdx>=0; jdx--){
            rightArray[jdx] = rightArray[jdx+1] * nums[jdx+1];
        }

        int[] returnArray = new int[nums.length];
        //int product=1;

        for (int idx=0; idx<nums.length; idx++){
            returnArray[idx] = leftArray[idx] * rightArray[idx];
        }
        return returnArray;
    }

    public static void main(String[] args) {
        int[] input = new int[] {5, 1, 4, 2};
        int[] expected = new int[] {8, 40, 10, 20};
        int[] actual = new ArrayOfProducts().arrayOfProducts(input);

        for (int i = 0; i < actual.length; i++) {
            System.out.printf("%2d ",actual[i]);
        }

        int actual2[] = arrayOfProductsWLeftAndRightArray(input);
        for (int i = 0; i < actual2.length; i++) {
            System.out.printf("%2d ",actual2[i]);

        }
    }
}
