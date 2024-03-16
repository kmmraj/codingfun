package com.test.binarysearch;

import java.util.List;

public class SearchEntryEqualToItsIndex {
    public static int searchEntryEqualToItsIndex(List<Integer> A) {

        int left = 0, right = A.size() - 1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            int difference = A.get(mid) - mid;
            //A.get(mid)==mid if and only if difference==0.
            if (difference == 0) {
                return mid;
            } else if (difference > 0) {
                right = mid - 1;
            } else { // difference < 0.
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchEntryEqualToItsIndex searchEntryEqualToItsIndex = new SearchEntryEqualToItsIndex();
        System.out.println("searchEntryEqualToItsIndex.searchEntryEqualToItsIndex(List.of(-2,0,2,3,6,7,9)) should be 3 and result is "
                + searchEntryEqualToItsIndex.searchEntryEqualToItsIndex(List.of(-2, 0, 2, 3, 6, 7, 9)));

        System.out.println("searchEntryEqualToItsIndex.searchEntryEqualToItsIndex(List.of(0,1,3,5,7,9,11,13)) should be 1 and result is "
                + searchEntryEqualToItsIndex.searchEntryEqualToItsIndex(List.of(0, 1, 3, 5, 7, 9, 11, 13)));

        System.out.println("searchEntryEqualToItsIndex.searchEntryEqualToItsIndex(List.of(0,2,3,5,7,9,11,13)) should be 0 and result is "
                + searchEntryEqualToItsIndex.searchEntryEqualToItsIndex(List.of(0,2,3,5,7,9,11,13)));

    }
}
