package com.test.dynamicprogramming.mcm;

import java.util.Arrays;

public class PalindromePartition {

    int [][] dpT;

    public PalindromePartition() {
        this.dpT = new int[101][101];
        for (int idx = 0; idx < 101; idx++) {
            Arrays.fill(dpT[idx],-1);
        }
    }

    int getMinPartition(String s){

//       return solveItRecur(s,0,s.length()-1);
       int answer =  solveItRecurMemoizedAndOptimized(s,0,s.length()-1);
        printMatrix();
        return answer;
    }

    private int solveItRecur(String s, int i, int j) {
       //BC
        if(i >=j)
            return 0;
        if(isPalindrome(s,i,j))
            return 0;

        int minValue = Integer.MAX_VALUE;
        for (int k = i; k <= j-1; k++) {
            int temp = 1+ solveItRecur(s,i,k) + solveItRecur(s,k+1,j);
            minValue = Math.min(minValue,temp);
        }
        return minValue;
    }

    private int solveItRecurMemoized(String s, int i, int j) {
        //BC
        if(i >=j)
            return 0;
        if(dpT[i][j] != -1){
            System.out.println("Skipped for i: "+i+" & j:"+j);
            return dpT[i][j];
        }

        if(isPalindrome(s,i,j))
            return 0;

        int minValue = Integer.MAX_VALUE;
        for (int k = i; k <= j-1; k++) {
            int temp = 1+ solveItRecurMemoized(s,i,k) + solveItRecurMemoized(s,k+1,j);
            minValue = Math.min(minValue,temp);
        }

        for (int idx = 0; idx < 5; idx++) {
            for (int jdx = 0; jdx < 5; jdx++) {
                System.out.printf("%2d, ",dpT[idx][jdx]);
            }
            System.out.println();
        }
        return dpT[i][j] = minValue;
    }


    private int solveItRecurMemoizedAndOptimized(String s, int i, int j) {
        //BC
        if(i >=j)
            return 0;
//        if(dpT[i][j] != -1){
//            System.out.println("Skipped for i: "+i+" & j:"+j);
//            return dpT[i][j];
//        }

        if(isPalindrome(s,i,j))
            return 0;

        int minValue = Integer.MAX_VALUE;
        for (int k = i; k <= j-1; k++) {
            int right;
            int left;
            if(dpT[i][k] != -1){
                left = dpT[i][k];
            } else {
                left =  solveItRecurMemoizedAndOptimized(s,i,k);
                dpT[i][k] = left;
            }

            if(dpT[k+1][j] != -1){
                right = dpT[k+1][j];
            } else {
                right =solveItRecurMemoizedAndOptimized(s,k+1,j);
                dpT[k+1][j] = right;
            }

            int temp = 1+ left+ right;
            minValue = Math.min(minValue,temp);
            dpT[i][j] = minValue;
        }
       // dpT[i][j] = minValue;


        return dpT[i][j];
    }

    private void printMatrix() {
        System.out.println("--------xxxx----------");
        for (int idx = 0; idx < 6; idx++) {
            for (int jdx = 0; jdx < 6; jdx++) {
                System.out.printf("%2d, ",dpT[idx][jdx]);
            }
            System.out.println();
        }
        System.out.println("--------yyyy----------");
    }

    private boolean isValidPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();
        return isPalindrome(s,0,s.length()-1);
    }
    private boolean isPalindrome(String s, int i, int j) {



        boolean palindrome = false;
        while (i<=j){
            if(i==j) {
                palindrome = true;
                break;
            } else if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            } else {
                palindrome = false;
                break;
            }
        }
        return palindrome;
    }

    public static void main(String[] args) {
        PalindromePartition partition = new PalindromePartition();
        System.out.println(partition.isPalindrome("nitin",0,4));
        String str = "A man, a plan, a canal: Panama";
        System.out.println(partition.isValidPalindrome(str));
//        System.out.println(partition.getMinPartition("nitik"));
    }
}
