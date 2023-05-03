package com.test.arrays;

import java.util.*;

public class IntersectionOf2Arrays {

    public int[] intersect(int[] nums1, int[] nums2) {

        List<Integer> resultList = new ArrayList<>();
        if(nums1.length ==0 || nums2.length ==0){
            int[] num0={};
            return num0;
        }


        Map<Integer,Integer> integerMap = new HashMap<>();

        for (int idx = 0; idx < nums1.length; idx++) {
            if(integerMap.containsKey(nums1[idx])){
                integerMap.put(nums1[idx], integerMap.get(nums1[idx])+1);
            } else {
                integerMap.put(nums1[idx],1);
            }
        }

        for (int idx2 = 0; idx2 < nums2.length; idx2++) {
            if(integerMap.containsKey(nums2[idx2]) && integerMap.get(nums2[idx2]) >0 ){
                integerMap.put(nums2[idx2], integerMap.get(nums2[idx2])-1);
                if(!resultList.contains(nums2[idx2]))
                resultList.add(nums2[idx2]);
            }
        }

        int[] result = new int[resultList.size()];

        for (int idx = 0; idx < resultList.size(); idx++) {
            result[idx] = resultList.get(idx);
        }
        return result;

    }

    public static void main(String[] args) {
        IntersectionOf2Arrays of2Arrays = new IntersectionOf2Arrays();
        int [] num1 = {1,2,2,1},num2= {2,2};
        int[] result = of2Arrays.intersect(num1,num2);
        for (int idx = 0; idx < result.length; idx++) {
            System.out.printf("%2d ",result[idx]);
        }
        System.out.println();
    }
}
