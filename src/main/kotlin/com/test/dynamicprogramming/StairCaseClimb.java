package com.test.dynamicprogramming;

import java.util.Arrays;

public class StairCaseClimb {

    int [] dpt;

    public int climbStairs(int n) {
       // BC
        if(n == 0)
            return 1;

        if(n == -1)
            return 0;

        // Hypothesis

       return climbStairs(n-2) + climbStairs(n-1);


       // Induction

    }

    public int climbStairsMemoized(int n) {

        this.dpt = new int[n+1];

        Arrays.fill(dpt, -1);

        return solveItMemoized(n);
    }

    private int solveItMemoized(int n){
        // BC
        if(n == 0)
            return 1;

        if(n == -1)
            return 0;

        // Hypothesis
       if(dpt[n] == -1){
           return dpt[n] = solveItMemoized(n-2) + solveItMemoized(n-1);
       } else
           return dpt[n];
    }

    public static void main(String[] args) {
        StairCaseClimb climb = new StairCaseClimb();
        System.out.println(climb.climbStairs(2));
        System.out.println(climb.climbStairs(6));
        System.out.println(climb.climbStairsMemoized(6));
    }
}
