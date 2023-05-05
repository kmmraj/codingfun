package com.test.arrays;

import java.util.Arrays;

public class FindLowestAndHighestNumbers {


    public static void main(String[] args) {
        int[] numArray = new int[]{7, 11, 22, 2, 6, 1, 3, 5, 23};
        System.out.println("The highest and lowest numbers in the array are " + Arrays.toString(findMinAndMax(numArray)));
        System.out.println("The highest and lowest numbers in the array are " + Arrays.toString(findMinAndMax(new int[]{1,-99,22,-100,300,5,200})));
    }

    private static int[] findMinAndMax(int[] numArray) {
        // 7, 11, 22, 2, 6, 1, 3, 5, 23
        int head =0;
        int tail = numArray.length-1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while (head<=tail){
            if(numArray[head] > numArray[tail]) {
                if(numArray[head] > max){
                    max =numArray[head];
                }
                if(numArray[tail] < min){
                    min = numArray[tail];
                }
            } else {
                if(numArray[tail] > max){
                    max = numArray[tail];
                }
                if(numArray[head] < min) {
                    min = numArray[head];
                }

            }

            head++;
            tail--;
        }
        return new int[]{min,max};
    }
}
