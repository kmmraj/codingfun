package com.test.arrays;

import java.util.HashMap;
import java.util.Map;

public class FindSpecialInt {
    public int findSpecialInteger(int[] arr) {

        Map<Integer,Integer> map = new HashMap<>();
        for (int idx = 0; idx < arr.length; idx++) {
            int value = arr[idx];
            int count =0;
            if(map.containsKey(value)){
               count = map.get(value);
               count++;
               map.put(value,count);
            } else {
                count++;
                map.put(value,count);
            }
            if(count > (arr.length/4)){
                return value;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindSpecialInt specialInt = new FindSpecialInt();
//        int [] nums = {1,2,2,6,6,6,6,7,10};
        int [] nums = {1,2,3,3};
        System.out.println(specialInt.findSpecialInteger(nums));
    }
}
