package com.test.arrays;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

            int index1 = 0;
            int index2 = 0;
            while(index1 < nums1.length && index2 < nums2.length){
                if(nums1[index1] < nums2[index2]){
                    index1++;
                } else{
                    int index3 = m+n-1;
                    while(index1 < index3){
                        nums1[index3] = nums1[index3-1];
                        index3--;
                    }

                    nums1[index1] = nums2[index2];
                    index1++;
                    index2++;
                }
            }

            int index4 = m + index2;
            while (index2<nums2.length){
                nums1[index4] =nums2[index2];
                index2++;
                index4++;
            }
        }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        mergeSortedArray.merge(nums1,3,nums2,3);
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + " , ");
        }
        System.out.println();

        nums1 = new int[]{2,0};
        nums2 = new int[]{1};
        mergeSortedArray.merge(nums1,1,nums2,1);
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + " , ");
        }
        System.out.println();


        nums1 = new int[]{1,2,3,0,0,0};
        nums2 = new int[]{4,5,6};
        mergeSortedArray.merge(nums1,3,nums2,3);
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + " , ");
        }
    }
}
