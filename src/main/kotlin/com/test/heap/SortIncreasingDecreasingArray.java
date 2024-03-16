package com.test.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortIncreasingDecreasingArray {

    public static List<Integer> sortKIncreasingDecreasingArray(List<Integer> A) {
        // Decomposes A into a set of sorted arrays.
        List<List<Integer>> sortedSubarrays = new ArrayList<>();
        SubarrayType subarrayType = SubarrayType.INCREASING;
        int startldx = 0;
        for (int i = 1; i <= A.size(); ++i) {
            if (i == A.size() // A is ended. Adds the last subarray
                    || (A.get(i - 1) < A.get(i) && subarrayType == SubarrayType.DECREASING)
                    || (A.get(i - 1) >= A.get(i) && subarrayType == SubarrayType.INCREASING)
            ) {
                List<Integer> subList = A.subList(startldx, i);
                if (subarrayType == SubarrayType.DECREASING) {
                    Collections.reverse(subList);
                }
                sortedSubarrays.add(subList);
                startldx = i;
                subarrayType = (subarrayType == SubarrayType.INCREASING ? SubarrayType.DECREASING
                        : SubarrayType.INCREASING);
            }
        }
        return MergeSortedArrays.mergeSortedArrays(sortedSubarrays);
    }

    private static enum SubarrayType {INCREASING, DECREASING}


    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(List.of(57, 131, 493, 294, 221, 339, 418, 452, 442, 190));
        System.out.println("A = " + A);
        System.out.println("sortKIncreasingDecreasingArray(A) = " + sortKIncreasingDecreasingArray(A));
    }
}
