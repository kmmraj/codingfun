package com.test.binarysearch;
/**
 * 2.1 SEARCH A SORTED ARRAY FOR FIRST OCCURRENCE OF k
 * Binary search commonly asks for the index of any element of a sorted array that is
 * equal to a specified element. The following problem has a slight twist on this.
 *
 * -14    -10    2     108   108     243    285     285    285     401
 * A[0]   A[l]   A[2]  A[3]  A[4]   A[5]   A[6]    A[7]    A[8]   A[9]
 * Figure 12.1: A sorted array with repeated elements.
 * Write a method that takes a sorted array and a key and returns the index of the first occurrence
 * of that key in the array.
 * For example, when applied to the array in Figure 12.1 your algorithm should return 3
 * if the given key is 108; if it is 285, your algorithm should return 6.
 */

import java.util.List;

public class SearchFirstOfK {
    public static int searchFirstOfK(List<Integer> A, int k) {
        int left = 0, right = A.size() - 1, result = -1;
      // A.subList(left , right + 1) is the candidate set.
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (A.get(mid) > k) {
                right = mid - 1;
            } else if (A.get(mid) == k) {
                result = mid;
         // Nothing to the right of mid can be the first occurrence of k.
                right = mid - 1;
            } else { // A.get(mid) < k
                left = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SearchFirstOfK searchFirstOfK = new SearchFirstOfK();
        System.out.println("searchFirstOfK.searchFirstOfK(List.of(1,2,3,4,5,6,7,8,9,10), 5) should be 4 and result is "
                + searchFirstOfK.searchFirstOfK(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 5));

        // * -14    -10    2     108   108     243    285     285    285     401
        // * A[0]   A[l]   A[2]  A[3]  A[4]   A[5]   A[6]    A[7]    A[8]   A[9]

        System.out.println("searchFirstOfK.searchFirstOfK(List.of(-14, -10, 2, 108, 108, 243, 285, 285, 285, 401), 108) should be 3 and result is "
                + searchFirstOfK.searchFirstOfK(List.of(-14, -10, 2, 108, 108, 243, 285, 285, 285, 401), 108));
    }
}
