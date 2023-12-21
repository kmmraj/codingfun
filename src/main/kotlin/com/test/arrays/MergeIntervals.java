package com.test.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {


    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<int[]> ans = new ArrayList<>(); // Create a list to store the merged intervals.
        if (n == 0)
            return intervals; // If there are no intervals to merge, return an empty list.

        // Sort the intervals based on their start times.
        // if start is same it will sort according to end time for the same.
        java.util.Arrays.sort(intervals,
                java.util.Comparator.<int[]>comparingInt(a -> a[0]).thenComparingInt(a -> a[1]));

        ans.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            // Check if the current interval's start time is greater than the end time
            // of the last interval in the ans list. If so, it means there is no overlap,
            // and we can add this interval to the answer.
            if (intervals[i][0] > ans.getLast()[1]) {
                ans.add(intervals[i]);
            } else {
                // it there's an overlap between the last interval in the ans list
                //and the current interval, we update the end time of the last interval
                //in the ans list to cover the entire merged interval
                ans.getLast()[1] = Math.max(ans.getLast()[1], intervals[i][1]);
            }
        }
        return ans.toArray(new int[0][0]); //final answer
    }

    public int[][] mergeOverlappingIntervals(int[][] intervals) {
        // Write your code here.
        // 1. Sort
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] <= o2[1] ? -1 : 0;
            } else {
                return o1[0] < o2[0] ? -1 : 0;
            }
        });

        // 2. Merge if interval[idx-1][1] > interval[idx+1][0] and append to the reference of last merged item
        ArrayList<int[]> mergedIntervals = new ArrayList<>();
        int mergedIntervalRef = -1;
        boolean isMerged = false;
        for (int idx = 1; idx < intervals.length; idx++) {
            mergedIntervalRef = mergedIntervals.size() - 1;
            if (intervals[idx - 1][1] >= intervals[idx][0]) {
                if (mergedIntervalRef == -1) {
                    int[] mergedValue;
                    if (intervals[idx - 1][1] > intervals[idx][1]) {
                        mergedValue = new int[]{intervals[idx - 1][0], intervals[idx - 1][1]};
                    } else {
                        mergedValue = new int[]{intervals[idx - 1][0], intervals[idx][1]};
                    }

                    mergedIntervals.add(mergedValue);
                } else {
                    int[] prevMergedValue = mergedIntervals.get(mergedIntervalRef);
                    int[] mergedValue = new int[]{prevMergedValue[0], intervals[idx][1]};
                    mergedIntervals.remove(mergedIntervalRef);
                    mergedIntervals.add(mergedValue);
                }
                isMerged = true;
            } else {
                if (!isMerged) {
                    mergedIntervals.add(intervals[idx - 1]);
                    isMerged = true;
                }
                if(mergedIntervalRef!=-1){
                    int[] prevMergedValue = mergedIntervals.get(mergedIntervalRef);
                    if (prevMergedValue[1] < intervals[idx][1])
                        mergedIntervals.add(intervals[idx]);
                } else {
                    if (intervals[idx-1][1] < intervals[idx][1])
                        mergedIntervals.add(intervals[idx]);
                }

            }
        }
        // 3. if not append to the existing list
        int[][] mergedArray = new int[mergedIntervals.size()][1];
        return mergedIntervals.toArray(mergedArray);
    }

    public static void main(String[] args) {
        System.out.println("--TC1---");
        TestCase1();
        System.out.println("--TC2---");
        TestCase2();
        System.out.println("--TC3---");
        TestCase3();
        System.out.println("--TC4---");
        TestCase4();

        System.out.println("--TC6---");
        TestCase6();

        System.out.println("--TC11---");
        TestCase11();

        System.out.println("--TC13---");
        TestCase13();
    }

    public static void TestCase1() {
        int[][] intervals =
                new int[][]{
                        {1, 2},
                        {3, 5},
                        {4, 7},
                        {6, 8},
                        {9, 10}
                };
        int[][] expected =
                new int[][]{
                        {1, 2},
                        {3, 8},
                        {9, 10}
                };
        //int[][] actual = new MergeIntervals().mergeOverlappingIntervals(intervals);
        int[][] actual = new MergeIntervals().merge(intervals);
        for (int i = 0; i < actual.length; i++) {
            for (int j = 0; j < actual[i].length; j++) {
                System.out.println(expected[i][j] == actual[i][j]);
            }
        }
    }

    public static void TestCase2() {
        int[][] intervals =
                new int[][]{
                        {1, 3},
                        {2, 8},
                        {9, 10}
                };
        int[][] expected =
                new int[][]{
                        {1, 8},
                        {9, 10}
                };
        int[][] actual = new MergeIntervals().mergeOverlappingIntervals(intervals);
        for (int i = 0; i < actual.length; i++) {
            for (int j = 0; j < actual[i].length; j++) {
                System.out.println(expected[i][j] == actual[i][j]);
            }
        }
    }

    public static void TestCase3() {
        int[][] intervals =
                new int[][]{
                        {1, 10},
                        {10, 20},
                        {20, 30},
                        {30, 40},
                        {40, 50},
                        {50, 60},
                        {60, 70},
                        {70, 80},
                        {80, 90},
                        {90, 100}
                };
        int[][] expected =
                new int[][]{
                        {1, 100}
                };
        int[][] actual = new MergeIntervals().mergeOverlappingIntervals(intervals);
        for (int i = 0; i < actual.length; i++) {
            for (int j = 0; j < actual[i].length; j++) {
                System.out.println(expected[i][j] == actual[i][j]);
            }
        }
    }

    public static void TestCase4() {
        int[][] intervals =
                new int[][]{
                        {1, 10},
                        {11, 20},
                        {21, 30},
                        {31, 40},
                        {41, 50},
                        {51, 60},
                        {61, 70},
                        {71, 80},
                        {81, 90},
                        {91, 100}
                };
        int[][] expected =
                new int[][]{
                        {1, 10},
                        {11, 20},
                        {21, 30},
                        {31, 40},
                        {41, 50},
                        {51, 60},
                        {61, 70},
                        {71, 80},
                        {81, 90},
                        {91, 100}
                };
        int[][] actual = new MergeIntervals().mergeOverlappingIntervals(intervals);
        for (int i = 0; i < actual.length; i++) {
            for (int j = 0; j < actual[i].length; j++) {
                System.out.println(expected[i][j] == actual[i][j]);
            }
        }
    }


    public static void TestCase6() {
        int[][] intervals =
                new int[][]{
                        {89, 90},
                        {-10, 20},
                        {-50, 0},
                        {70, 90},
                        {90, 91},
                        {90, 95}
                };
        int[][] expected =
                new int[][]{
                        {-50, 20},
                        {70, 95}
                };
        int[][] actual = new MergeIntervals().mergeOverlappingIntervals(intervals);
        for (int i = 0; i < actual.length; i++) {
            for (int j = 0; j < actual[i].length; j++) {
                System.out.println(expected[i][j] == actual[i][j]);
            }
        }
    }

    public static void TestCase11() {
        int[][] intervals =
                new int[][]{
                        {1, 22},
                        {-20, 30}
                };
        int[][] expected =
                new int[][]{
                        {-20, 30}
                };
        int[][] actual = new MergeIntervals().mergeOverlappingIntervals(intervals);
        for (int i = 0; i < actual.length; i++) {
            for (int j = 0; j < actual[i].length; j++) {
                System.out.println(expected[i][j] == actual[i][j]);
            }
        }
    }

    public static void TestCase13() {
        int[][] intervals =
                new int[][]{
                        {2, 3},
                        {4, 5},
                        {6, 7},
                        {8, 9},
                        {1, 10}
                };
        int[][] expected =
                new int[][]{
                        {1, 10}
                };
        int[][] actual = new MergeIntervals().mergeOverlappingIntervals(intervals);
        for (int i = 0; i < actual.length; i++) {
            for (int j = 0; j < actual[i].length; j++) {
                System.out.println(expected[i][j] == actual[i][j]);
            }
        }
    }
}
