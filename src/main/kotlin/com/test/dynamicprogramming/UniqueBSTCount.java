package com.test.dynamicprogramming;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class UniqueBSTCount {
    int[] dpT;
    public int numTrees(int n) {

        return solveIt(n);
    }

    public int numTreesMemoized(int n) {
        this.dpT = new int[n+1];
        Arrays.fill(dpT,0);

        printArray(dpT);
        int ans= solveItMemoized(n);
        printArray(dpT);
        return ans;

    }

    private int solveIt(int n){
        // BC
        if(n == 1 || n == 0)
            return 1;

        // Choice & Hypothesis
        int count=0;
        for (int idx = 1; idx <= n ; idx++) {
            count = count + solveIt(idx-1) * solveIt(n-idx);
        }

        return count;
    }

    private int solveItMemoized(int n){
        // BC
        if(n == 1 || n == 0)
            return 1;

        // Choice & Hypothesis
        if(dpT[n] != 0)
            return dpT[n];
        int count=0;
        int left;
        int right;
        for (int idx = 1; idx <= n ; idx++) {

            if(dpT[idx-1] != 0){
               left =  dpT[idx-1];
            } else {
                left = solveItMemoized(idx-1);
                dpT[idx-1] = left;
            }

            if(dpT[n-idx] != 0){
                right = dpT[n-idx];
            } else {
                right = solveItMemoized(n-idx);
                dpT[n-idx] = right;
            }

            count = count + left * right;
        }

        return dpT[n] = count;
    }

    private void printArray(int [] arr) {
        System.out.println("-----------------------------");
        for (int idx = 0; idx < arr.length; idx++) {
            System.out.printf("%2d, ",arr[idx]);
        }
        System.out.println();
        System.out.println("-----------------------------");
    }

    public static void main(String[] args) {
        UniqueBSTCount bstCount = new UniqueBSTCount();
        Instant start = Instant.now();
        System.out.println(bstCount.numTrees(3));
        Instant end = Instant.now();
        Duration duration = Duration.between(start,end);
        System.out.println("Time taken : "+ duration.toMillis());

        start = Instant.now();
        System.out.println(bstCount.numTreesMemoized(3));
        end = Instant.now();
        duration = Duration.between(start,end);
        System.out.println("Time taken with memoized: "+ duration.toMillis());
    }
}
