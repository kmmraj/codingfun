package com.test.arrays;

public class ArrayOfProducts {
    public int[] arrayOfProducts(int[] array) {
        // Write your code here.
        int[] returnArray = new int[array.length];
        int product=1;
        for (int idx = 0; idx < array.length; idx++) {

            int jdx=idx-1;
            while (jdx>=0){
                product = product*array[jdx];
                jdx--;
            }
            int kdx=idx+1;
            while (kdx<array.length){
                product = product*array[kdx];
                kdx++;
            }
            returnArray[idx]=product;
            product=1;
        }

        return returnArray;
    }

    public static void main(String[] args) {
        int[] input = new int[] {5, 1, 4, 2};
        int[] expected = new int[] {8, 40, 10, 20};
        int[] actual = new ArrayOfProducts().arrayOfProducts(input);

        for (int i = 0; i < actual.length; i++) {
            System.out.printf("%2d ",actual[i]);
        }
    }
}
