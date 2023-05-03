package com.test;

public class InsertionSort {
    public static void main(String[] args) {
        Integer[] intArrayOne = {7,2,21,-8,0,-7};
        Integer[] intArrayTwo = insertionSort(intArrayOne);
        for (int item:intArrayTwo) {
            System.out.print(item+", ");

        }
    }

    static Integer[] insertionSort(Integer[] intArrayOne){
        int length = intArrayOne.length;
        for (int index = 1; index <length; index++) {
            int key = intArrayOne[index];
            int secIndex = index-1;
            while (secIndex >=0 && intArrayOne[secIndex] > key ) {
                intArrayOne[secIndex+1] = intArrayOne[secIndex];
                secIndex--;
            }
            intArrayOne[secIndex+1] = key;
            }

        return intArrayOne;
    }
}
