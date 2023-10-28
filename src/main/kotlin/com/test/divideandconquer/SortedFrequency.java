package com.test.divideandconquer;


/**
 * Given a sorted array and a number, write a function called sortedFrequency that counts the occurrences of the number in the array.
 * <p>
 * sortedFrequency([1, 1, 2, 2, 2, 2, 3], 2) # 4
 * sortedFrequency([1, 1, 2, 2, 2, 2, 3], 3) # 1
 * sortedFrequency([1, 1, 2, 2, 2, 2, 3], 4) # -1
 * sortedFrequency([], 4) # -1
 * Time Complexity - O(log n)
 */
public class SortedFrequency {

    public static int sortedFrequency(int[] arr, int num) {
        int left = 0;
        int right = arr.length;
        int leftCount = 0;
        int rightCount = 0;
        while (left < right) {
            int middle = (left + right) / 2;
            if (arr[middle] < num) {
                left++;
            } else if (arr[middle] > num) {
                right--;
            } else if (arr[middle] == num) {
                leftCount = middle;
                rightCount = middle;
                while (leftCount >= 0 && arr[leftCount] == num) {
                    leftCount--;
                }
                while (rightCount < arr.length && arr[rightCount] == num) {
                    rightCount++;
                }
                return rightCount - leftCount -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(SortedFrequency.sortedFrequency(new int[]{1, 1, 2, 2, 2, 2, 3}, 2));
        System.out.println(SortedFrequency.sortedFrequency(new int[]{1, 1, 2, 2, 2, 2, 3}, 3));
        System.out.println(SortedFrequency.sortedFrequency(new int[]{1, 1, 2, 2, 2, 2, 3}, 4));
        System.out.println(SortedFrequency.sortedFrequency(new int[]{}, 4));
    }
}
