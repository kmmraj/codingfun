package com.test.recursion;

public class ProductOfArray {

    public static void main(String[] args) {
       System.out.println(" Product of array 1,2,3,4,5 is "+ ProductOfArray.productofArray(new int[]{1,2,3,4,5},4));
    }

    public static int productofArray(int A[], int N)
    {
        // BC
        if(N==0){
            return A[0];
        }

        // H & I
        return A[N] * productofArray(A, N-1);
    }
}
