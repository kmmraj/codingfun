package com.test.sorting;

public class InsertionSort {
    public static void main(String[] args) {
        Integer[] intArrayOne = {7, 2, 21, -8, 0, -7};
        Integer[] intArrayTwo = insertionSort(intArrayOne);
        for (int item : intArrayTwo) {
            System.out.print(item + ", ");

        }
    }

    static Integer[] insertionSort(Integer[] intArrayOne) {
        int length = intArrayOne.length;
        for (int index = 1; index < length; index++) {
            int secIndex = index - 1;
            while (secIndex >= 0 && intArrayOne[secIndex] > intArrayOne[index]) {
                intArrayOne[secIndex + 1] = intArrayOne[secIndex];
                secIndex--;
            }
            intArrayOne[secIndex + 1] = intArrayOne[index];
        }

        return intArrayOne;
    }
}
