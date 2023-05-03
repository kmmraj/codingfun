package com.test.arrays;

public class Permuntations {

    public boolean permutation(int[] array1, int[] array2){
        // TODO
        if(array1.length != array2.length){
            return false;
        }

        int sumArray1 =0;
        int sumArray2 =0;
        int mulArray1 =1;
        int mulArray2 =1;

        for(int indx=0;indx <= array1.length-1; indx++){
            sumArray1 = sumArray1+ array1[indx];
            sumArray2 = sumArray2+ array2[indx];

            mulArray1 = mulArray1 * array1[indx];
            mulArray2 = mulArray2 * array2[indx];
        }

        if(sumArray1 != sumArray2 || mulArray1 != mulArray2) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] array1 = {1,2,3,4,5,7,8};
        int[] array2 = {1,2,4,3,5,7,8};
        Permuntations permuntations = new Permuntations();
        boolean isPermutation = permuntations.permutation(array1, array2);
        System.out.println(isPermutation);
    }
}
