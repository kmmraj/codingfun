package com.test.arrays;

public class BinarySearch {
    public static int binarySearch(int[] array, int target) {
        // Write your code here.
        int start=0,end=array.length-1;
        int index = solveIt(array,target,start,end);
        return index>=0?index:-1;
    }

    private static int solveIt(int[] array, int target, int start, int end) {
        //BC
        if(start>end)
            return -1;

        //Hypo & Choices
        int mid = end+start/2;
        if (array[mid] == target) {
            return mid;
        } else if(array[mid] > target){
            end = mid-1;
        } else if(array[mid] < target) {
            start = mid+1;
        }
        return solveIt(array,target,start,end);
    }

    public static void main(String[] args) {
//        System.out.println(binarySearch(new int[] {0, 1, 21, 33, 45, 45, 61, 71, 72, 73}, 33));
        System.out.println(binarySearch(new int[] {1, 5, 23, 111}, 35));
    }
}
