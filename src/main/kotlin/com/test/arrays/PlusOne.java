package com.test.arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlusOne {
    public int[] plusOne(int[] digits) {


        int[] result = new int[digits.length];
        int remainder=1;
        int addSum;

        for (int idx = digits.length-1; idx >= 0; idx--) {

            addSum = digits[idx]+remainder;
            int temp = addSum%10;
            remainder = addSum/10;
            result[idx]=temp;
        }

       if(remainder>0){
           int[] newResult = new int[digits.length+1];
           for (int idy = digits.length-1; idy >0; idy--) {
               newResult[idy+1] = result[idy];
           }
           newResult[0]=remainder;
           return newResult;
       }

        return result;
    }

    public int[] plusOne2(int[] digits) {


        List<Integer> result = new ArrayList<>(digits.length+1);
        int remainder=1;
        int addSum;

        for (int idx = digits.length-1; idx >= 0; idx--) {

            addSum = digits[idx]+remainder;
            int temp = addSum%10;
            remainder = addSum/10;
            result.add(idx,temp);
        }

//        if(remainder>0){
//            int[] newresult = new int[digits.length+1];
//            newresult = result.clone();
//            newresult[0]=remainder;
//        }

        return null;
    }
    public static void main(String[] args) {
      PlusOne one = new PlusOne();
      int[] digits = {9,9};

      int[] result = one.plusOne(digits);
        for (int idz = 0; idz < result.length; idz++) {
            System.out.printf("%d ",result[idz]);
        }

    }
}
