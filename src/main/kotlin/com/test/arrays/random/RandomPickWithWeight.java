package com.test.arrays.random;

import java.util.Arrays;
import java.util.Random;

//https://leetcode.com/problems/random-pick-with-weight/submissions/
public class RandomPickWithWeight {

    // List<Double> prefixSumOfPossiblites = new ArrayList<>();
    int [] values;
    Random rand = new Random();

    public RandomPickWithWeight(int[] w) {

        // System.out.println(" Input Array is "+Arrays.toString(w));

        for(int index=1; index< w.length;index++){
            w[index] = w[index-1]+ w[index];
        }
        values = w;
        //System.out.println(" Input Array is "+Arrays.toString(w));

    }

    public int pickIndex() {
        final int nextRand = rand.nextInt(values[values.length-1]) +1;
        // System.out.println("nextRand is "+nextRand);
        //    int left=0,right=values.length-1;
        //    while(left<right){
        //       int mid = (left + right)/2;
        //       if(values[mid] == nextRand){
        //           return mid;
        //       }

        //       if(values[mid] < nextRand){
        //           left = mid+1;
        //       } else {
        //           right = mid;
        //       }
        //    }
        //    return left;

        int idx = Arrays.binarySearch(values,nextRand);
        //System.out.println("nextRand is "+nextRand + " idx is "+idx);
        return idx >= 0 ? idx : -idx-1;

        //    final int match = Collections.binarySearch(prefixSumOfPossiblites,nextRand);
        //    System.out.println("nextRand is "+nextRand + " match is "+ match);
        //    if(match<0){
        //        final int intervalIdx = Math.abs(match) - 1;
        //        return values[intervalIdx];
        //    } else{
        //       return values[match];
        //    }
    }

    public static void main(String[] args) {
        RandomPickWithWeight randomPickWithWeight = new RandomPickWithWeight(new int[]{1, 3, 4, 5, 6, 7, 8, 9});
        System.out.println("randomPickWithWeight.pickIndex() = " + randomPickWithWeight.pickIndex());
        System.out.println("randomPickWithWeight.pickIndex() = " + randomPickWithWeight.pickIndex());
        System.out.println("randomPickWithWeight.pickIndex() = " + randomPickWithWeight.pickIndex());
        System.out.println("randomPickWithWeight.pickIndex() = " + randomPickWithWeight.pickIndex());
        System.out.println("randomPickWithWeight.pickIndex() = " + randomPickWithWeight.pickIndex());
        System.out.println("randomPickWithWeight.pickIndex() = " + randomPickWithWeight.pickIndex());
        System.out.println("randomPickWithWeight.pickIndex() = " + randomPickWithWeight.pickIndex());
        System.out.println("randomPickWithWeight.pickIndex() = " + randomPickWithWeight.pickIndex());
        System.out.println("randomPickWithWeight.pickIndex() = " + randomPickWithWeight.pickIndex());
    }
}
