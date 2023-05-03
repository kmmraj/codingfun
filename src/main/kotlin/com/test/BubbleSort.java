package com.test;

public class BubbleSort {
    public static void main(String[] args) {
        Integer[] intArrayOne = {7,2,21,0,-7};
        Integer[] intArrayTwo = bubbleSort(intArrayOne);
    }

    static Integer[] bubbleSort(Integer[] intArrayOne){
        int length = intArrayOne.length;
        for (int index = 0; index <length; index++) {
            for (int secIndex = 0; secIndex < length-index-1; secIndex++) {
                if(intArrayOne[secIndex] > intArrayOne[secIndex+1]) {
//                    int temp = intArrayOne[secIndex];
//                    intArrayOne[secIndex] = intArrayOne[secIndex+1];
//                    intArrayOne[secIndex+1] = temp;
                    swap(intArrayOne[secIndex], intArrayOne[secIndex+1]);
                }
            }

        }

        return intArrayOne;
    }

    static void swap(int one, int two){
        int temp = one;
        one = two;
        two = temp;
    }
}
