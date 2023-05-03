package com.test.dynamicprogramming.mcm;

import java.util.Arrays;

public class MatrixChainMultiplication1 {

    int [][] dpT = new int[1001][1001];

    public MatrixChainMultiplication1() {
        for (int idx = 0; idx < 1000; idx++) {
            Arrays.fill(dpT[idx],-1);
        }
    }

    // 1. Identify i and j
    // 2. Base condition
    // 3. Move k from i to j
    // 4. Derive Answer
    public int MatrixChainOrder(int p[], int i, int j) {

        //#2 BC
        if (i >= j)
            return 0;

        // Hypo & Choice Diagram
        int min = Integer.MAX_VALUE;

        // Scheme #A
//        for (int k = i; k <= j-1; k++) {
//            int temp = MatrixChainOrder(p, i, k)
//                    + MatrixChainOrder(p, k + 1, j)
//                    + p[i-1] * p[k] * p[j];

        // Scheme #B
        for (int k = i+1; k <= j; k++) {
            int temp = MatrixChainOrder(p,i,k-1)
                    + MatrixChainOrder(p,k,j)
                    + p[i-1] * p[k-1] * p[j];
            min = Math.min(min, temp);
        }
            return min;
    }


    public int MatrixChainOrderMemoized(int p[], int i, int j) {

        //#2 BC
        if (i >= j)
            return 0;

        if(dpT[i][j] != -1) {
            System.out.println("skipped for i: "+i+" & j: "+j);
            return dpT[i][j];
        }


        // Hypo & Choice Diagram
        int min = Integer.MAX_VALUE;

        // Scheme #A
        for (int k = i; k <= j-1; k++) {
            int temp;

            temp  = MatrixChainOrderMemoized(p, i, k)
                        + MatrixChainOrderMemoized(p, k + 1, j)
                        + p[i - 1] * p[k] * p[j];


            min = dpT[i][j] = Math.min(min, temp);
        }
        return min;
    }
    public static void main(String args[]) {
        int arr[] = new int[] { 1, 2, 3, 4, 3 };

        MatrixChainMultiplication1 chainMultiplication1 = new MatrixChainMultiplication1();

        // #1. Identify i and k
        System.out.println(
                "Minimum number of multiplications is "
                        + chainMultiplication1.MatrixChainOrder(arr, 1, arr.length-1 ));
        int arr1[] = {1,2,3,4};

        System.out.println(
                "Minimum number of multiplications is "
                        + chainMultiplication1.MatrixChainOrder(arr1, 1, arr1.length-1 ));

        System.out.println(
                "Minimum number of multiplications with Memoized is "
                        + chainMultiplication1.MatrixChainOrderMemoized(arr, 1, arr.length-1 ));
    }
}
