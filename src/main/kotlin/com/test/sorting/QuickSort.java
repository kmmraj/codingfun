package com.test.sorting;

public class QuickSort {

    public static void main(String[] args) {
        int[] numArray = {7, 11, 8, 35, 5, 23,-7};
        QuickSort.sort(numArray);
        QuickSort.printAll(numArray);
    }


    private static void sort(int[] numArray) {
        sortIt(numArray, 0, numArray.length - 1);
    }

    private static void sortIt(int[] numArray, int leftIndex, int rightIndex) {
        // BC
        if (leftIndex < rightIndex) {
            int pivotIndex = partition(numArray, leftIndex, rightIndex);
            // H & I
            sortIt(numArray, leftIndex, pivotIndex - 1);
            sortIt(numArray, pivotIndex + 1, rightIndex);
//            sortIt(numArray, leftIndex, pivotIndex);
//            sortIt(numArray, pivotIndex, rightIndex);
        }
    }

    private static int partition(int[] numArray, int leftIndex, int rightIndex) {
        int pivot = rightIndex;
        int newPivotIndex = leftIndex - 1;
//        int newPivotIndex = leftIndex;
        for (int index = leftIndex; index <= rightIndex; index++) {
            if (numArray[index] <= numArray[pivot]) {
                newPivotIndex++;
                int temp = numArray[index];
                numArray[index] = numArray[newPivotIndex];
                numArray[newPivotIndex] = temp;
//                newPivotIndex++;
            }

        }
        return newPivotIndex;
    }

    private static void printAll(int[] nums) {
        System.out.println("\n-------------- Start --------------------");
        for (int indx = 0; indx < nums.length; indx++) {
            System.out.print(nums[indx] + " , ");
        }
        System.out.println("\n-------------- End   --------------------");
    }
}
