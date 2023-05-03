package com.test.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class SubsetSumTry01 {
    boolean[][] dp;
    List<Integer> [][] dpM;


    public boolean combinationSum2(int[] candidates, int target, int size) {

        this.dp = new boolean[size+1][target+1];

        // BC
        for (int indexJ = 0; indexJ < target+1; indexJ++) {
            dp[0][indexJ]=false;
        }
        for (int indexI = 0; indexI < candidates.length+1; indexI++) {
            dp[indexI][0]=true;
        }
        printMatrix(candidates,target);

        for (int indexI = 1; indexI < candidates.length+1; indexI++) {
            for (int indexJ = 1; indexJ < target+1; indexJ++) {
               if(candidates[indexI-1] <= indexJ){
                   dp[indexI][indexJ] =  dp[indexI-1][indexJ - candidates[indexI-1]] || dp[indexI-1][indexJ];
               } else {
                   dp[indexI][indexJ] = dp[indexI-1][indexJ];
               }
            }
        }

        printMatrix(candidates,target);
        return  dp[size][target];
    }

    public List<List<Integer>> combinationSumList2(int[] candidates, int target, int size) {

        this.dpM = new ArrayList[size+1][target+1];

        // BC
        for (int indexJ = 0; indexJ < target+1; indexJ++) {
            dpM[0][indexJ]=null;
        }
        for (int indexI = 0; indexI < candidates.length+1; indexI++) {
            dpM[indexI][0]=new ArrayList<Integer>();
        }
        printDPMatrix(candidates,target);


        for (int indexI = 1; indexI < candidates.length+1; indexI++) {
            for (int indexJ = 1; indexJ < target+1; indexJ++) {
                if(candidates[indexI-1] <= indexJ){
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(candidates[size-1]);
                    ArrayList<Integer> existingList = (ArrayList<Integer>) dpM[indexI-1][indexJ - candidates[indexI-1]];
                    if(existingList !=null){
                     //   temp.addAll(existingList.toArray());
                    }
                    dpM[indexI][indexJ] =  new ArrayList<Integer>(temp); //|| dpM[indexI-1][indexJ];
                } else {
                    dpM[indexI][indexJ] = dpM[indexI-1][indexJ];
                }
            }
        }

        System.out.println("---------");
        printDPMatrix(candidates,target);

       // return  dpM[size][target];
        return null;
    }

    private void printMatrix(int[] candidates, int target){
        for (int indexI = 0; indexI < candidates.length+1; indexI++) {
            for (int indexJ = 0; indexJ < target+1; indexJ++) {
                System.out.printf("%s, ",dp[indexI][indexJ]?"T":"F");
            }
            System.out.println();
        }
    }

    private void printDPMatrix(int[] candidates, int target){
        for (int indexI = 0; indexI < candidates.length+1; indexI++) {
            for (int indexJ = 0; indexJ < target+1; indexJ++) {
                System.out.printf("%s, ",dpM[indexI][indexJ]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SubsetSumTry01 try01 = new SubsetSumTry01();
        int[] nums = {2,3,7,8,10};
       // System.out.println(try01.combinationSum2(nums,26,5));
        System.out.println(try01.combinationSumList2(nums,5,5));
    }
}
