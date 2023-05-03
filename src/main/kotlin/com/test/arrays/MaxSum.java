package com.test.arrays;

public class MaxSum {

    public String maxProduct(int[] intArray) {
        // TODO
        int maxNumber = intArray[0];
        int secondMaxNumber = intArray[0];

        for(int indx=1; indx <= intArray.length-1; indx++){
            if(intArray[indx] > maxNumber){
                secondMaxNumber = maxNumber;
                maxNumber = intArray[indx];
            }
            if(intArray[indx] > secondMaxNumber && intArray[indx] < maxNumber){
                secondMaxNumber = intArray[indx];
            }
        }
        return "("+maxNumber+","+secondMaxNumber+")";
    }

    public static void main(String[] args) {
//        int[] array = {1,1,2,3,4,5,5,7,8};
        int[] array = {10,20,30,40,50,45};
        MaxSum maxSum = new MaxSum();
        String maxProduct = maxSum.maxProduct(array);
        System.out.println(maxProduct);

    }
}
