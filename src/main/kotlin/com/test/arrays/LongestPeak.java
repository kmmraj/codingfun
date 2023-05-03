package com.test.arrays;

import java.util.ArrayList;
import java.util.List;

public class LongestPeak {
    public static int longestPeak(int[] array) {
        // Write your code here.

        int existingPeakCnt = 0, newPeakCnt = 0;
        boolean increasingTrend = false;
        boolean decreasingTrend = false;
        for (int idx = 1; idx < array.length; idx++) {
            int jdx = idx;
            newPeakCnt = 0;
            while (jdx > 0 && array[jdx - 1] < array[jdx]) {
                newPeakCnt++;
                increasingTrend = true;
                jdx--;
            }
            int kdx = idx;
            while (increasingTrend && kdx + 1 < array.length && array[kdx] > array[kdx + 1]) {
                newPeakCnt++;
                decreasingTrend = true;
                kdx++;
            }

            if (existingPeakCnt < newPeakCnt && increasingTrend & decreasingTrend) {
                existingPeakCnt = newPeakCnt;
            }
            increasingTrend=false;
            decreasingTrend=false;
        }
        return existingPeakCnt==0?existingPeakCnt:existingPeakCnt+1;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        int expected = 6;
        int actual = LongestPeak.longestPeak(input);
        System.out.println("Peak is " + actual);
    }
}
