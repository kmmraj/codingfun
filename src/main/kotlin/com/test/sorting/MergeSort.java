package com.test.sorting;

public class MergeSort {

    private static int[] sort(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        sortIt(nums, left, right);
//        sort(nums,0,nums.length-1);
        return nums;
    }

    private static void sortIt(int[] nums, int left, int right) {

        // BC
        if(right <= left){
            return;
        }

        // Hypothesis

            // int m = l + (r - l) / 2;
            int middle = left + (right-left)  / 2;
            sortIt(nums, left, middle);
            sortIt(nums, middle + 1, right);
            mergeArray(nums, left, middle, right);
    }

    private static void mergeArray(int[] array, int left, int middle, int right) {

        int array1Size = middle - left + 1;
        int array2Size = right - middle;

        int[] leftArray = new int[array1Size];
        int[] rightArray = new int[array2Size];

//        for (int indx = 0; indx < array1Size; indx++) {
//            leftArray[indx] = array[indx + left];
//        }

        System.arraycopy(array, left, leftArray, 0, array1Size);

//        for (int jindx = 0; jindx < array2Size; jindx++) {
//            rightArray[jindx] = array[jindx + middle + 1];
//        }
        System.arraycopy(array, middle + 1, rightArray,0,array2Size);

        int leftIdx = 0;
        int rightIdx = 0;
        int mergeIdx = left;

        while (leftIdx < array1Size && rightIdx < array2Size) {
            if (leftArray[leftIdx] <= rightArray[rightIdx]) {
                array[mergeIdx] = leftArray[leftIdx];
                leftIdx++;
            } else {
                array[mergeIdx] = rightArray[rightIdx];
                rightIdx++;
            }
            mergeIdx++;
        }

        // Copy remaining elements from leftIdx to array
        while (leftIdx < array1Size) {
            array[mergeIdx] = leftArray[leftIdx];
            mergeIdx++;
            leftIdx++;
        }

        while (rightIdx < array2Size) {
            array[mergeIdx] = rightArray[rightIdx];
            mergeIdx++;
            rightIdx++;
        }

    }

    private static void swap(int[] nums, int outerIndex, int min, int minIndex) {
        int tmp = nums[outerIndex];
        nums[outerIndex] = min;
        nums[minIndex] = tmp;
    }

    private static void printAll(int[] nums) {
        System.out.println("\n-------------- Start --------------------");
        for (int indx = 0; indx < nums.length; indx++) {
            System.out.print(nums[indx] + " , ");
        }
        System.out.println("\n-------------- End   --------------------");
    }

    static void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    static void sort(int arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    public static void main(String[] args) {
//        int[] nums = {7, 9, 11, 1, 5, 12, 10, 3, 2, -15, 75};
        int[] nums = {7, 9, 11, 1};
        int[] sortedNums = MergeSort.sort(nums);
        MergeSort.printAll(sortedNums);
    }


}
