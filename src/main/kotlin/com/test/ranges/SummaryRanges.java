package com.test.ranges;
// https://leetcode.com/problems/summary-ranges

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int index = 0;
        while (index < nums.length) {
            int prevMatch = nums[index];
            while ((index + 1 < nums.length) && (nums[(index)] + 1 == nums[index + 1])) {
                index++;
            }
            if (prevMatch != nums[index]) {
                result.add(prevMatch + "->" + nums[index]);
            } else {
                result.add("" + prevMatch);
            }
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        SummaryRanges summaryRanges = new SummaryRanges();
        int[] nums = new int[]{0, 1, 2, 4, 5, 7};
        List<String> result = summaryRanges.summaryRanges(nums);
        for (String string : result) {
            System.out.print(string + " ");
        }

        System.out.println();

        // 0-5, 7, 9-12, 15-18, 20
        nums = new int[]{0, 1, 2, 3, 4, 5, 7, 9, 10, 11, 12, 15, 16, 17, 18, 20};
        result = summaryRanges.summaryRanges(nums);
        for (String s : result) {
            System.out.print(s + " ");
        }
    }
}
