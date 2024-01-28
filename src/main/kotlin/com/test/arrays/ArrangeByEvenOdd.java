package com.test.arrays;

import java.util.Arrays;

public class ArrangeByEvenOdd {

    private static void arrangeByEvenOdd(int[] arr) {
        int even = 0, odd = arr.length-1;
        while (even < odd){
            if(arr[even] % 2 ==0){
                even++;
            } else {
                int temp = arr[odd];
                arr[odd] = arr[even];
                arr[even] = temp;
                odd--;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        arrangeByEvenOdd(arr);
        System.out.println(Arrays.toString(arr));
    }


}
