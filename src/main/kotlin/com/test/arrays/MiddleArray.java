package com.test.arrays;

public class MiddleArray {

        public static int[] middle(int[] array) {
            if(array.length <= 2){
                return new int[] {0};
            }
            int[] middleArray = new int[array.length-2];

            for(int indx=1; indx<=array.length-2;indx++) {
                middleArray[indx-1] = array[indx];
            }
            return middleArray;
        }


    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        int[] middleArray = middle(array);
        for(int indx=0; indx<middleArray.length;indx++) {
            System.out.println(middleArray[indx]);
        }
    }

}
