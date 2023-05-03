package com.test.arrays;

public class SumOfDiagonalElements {

    public static int sumDiagonalElements(int[][] array) {

        // myArray2D= {
        //  {1,2,3},
        //  {4,5,6},
        //  {7,8,9}};

        int sum = 0;
        for (int row=0;row <= array.length-1; row++ ) {
            for(int col=0; col <= array[row].length-1; col++) {
                if(row == col){
                    sum = sum + array[row][col];
                }
            }
        }

        return sum;
    }

    public static int sumDiagonalElementsImproved(int[][] array) {

        // myArray2D= {
        //  {1,2,3},
        //  {4,5,6},
        //  {7,8,9}};

        int sum = Integer.MIN_VALUE;
        for (int row=0;row <= array.length-1; row++ ) {
//            for(int col=0; col <= array[row].length-1; col++) {
//                if(row == col){
                    sum = sum + array[row][row];
//                }
            }
//        }

        return sum;
    }

    public static void main(String[] args) {
        int[][] array = {{1,2,3},{4,5,6},{7,8,9}};
//        int sum = sumDiagonalElements(array);
        int sum = sumDiagonalElementsImproved(array);
        System.out.println(sum);
    }
}
