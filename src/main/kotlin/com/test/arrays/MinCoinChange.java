package com.test.arrays;

import java.util.Arrays;

public class MinCoinChange {
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        //BC
//        Arrays.sort(denoms);
//        MinCoinChangeValue value = new MinCoinChangeValue();
//
//        value.noOfCoinChangeCount = solveItRecursively(n, denoms, denoms.length - 1, value);
//        return value.noOfCoinChangeCount;
        return solveItDPX(n, denoms);
    }

    public static int solveItDP(int neededAmt, int[] denoms) {
        int[] nums = new int[neededAmt + 1];
        //BC
        Arrays.fill(nums, Integer.MAX_VALUE);
        nums[0] = 0;
        int toCompare = 0;
        for (int idx = 0; idx < denoms.length; idx++) {
            for (int jdx = 0; jdx < nums.length; jdx++) {
                if (denoms[idx] <= jdx) {
                    if (nums[jdx - idx] == Integer.MAX_VALUE) {
                        toCompare = nums[jdx - idx];
                    } else {
                        toCompare = 1 + nums[jdx - idx];
                    }
                    nums[jdx] = Math.min(nums[jdx], toCompare);
                }
            }
        }
        return nums[neededAmt] == Integer.MAX_VALUE ? -1 : nums[neededAmt];
    }

    public static int solveItDPX(int neededAmt, int[] denoms) {
        Arrays.sort(denoms);
        int[][] dpT = new int[denoms.length + 1][neededAmt + 1];
        Arrays.fill(dpT[0], Integer.MAX_VALUE - 1);
        for (int idx = 1; idx < denoms.length + 1; idx++) {
            dpT[idx][0] = 0;
        }
        printMatrix(dpT);

        for (int idx = 1; idx < neededAmt + 1; idx++) {
            if (idx % denoms[0] == 0) {
                dpT[1][idx] = idx / denoms[0];
            } else {
                dpT[1][idx] = Integer.MAX_VALUE - 1;
            }
        }
        printMatrix(dpT);

        for (int idx = 2; idx < denoms.length + 1; idx++) {
            for (int jdx = 1; jdx < neededAmt + 1; jdx++) {
                if (denoms[idx - 1] <= jdx) {
                    dpT[idx][jdx] = Math.min(1 + dpT[idx][jdx - denoms[idx - 1]],
                            dpT[idx - 1][jdx]);
                } else {
                    dpT[idx][jdx] = dpT[idx - 1][jdx];
                }
            }
        }
        printMatrix(dpT);

        return dpT[denoms.length][neededAmt] == Integer.MAX_VALUE - 1 ? Integer.MAX_VALUE - 1 :dpT[denoms.length][neededAmt];
    }

    private static void printMatrix(int[][] dpT) {
        System.out.println("-------x---------x----------------x---------x----------------x---------x---------");
        for (int idx = 0; idx < dpT.length; idx++) {
            for (int jdx = 0; jdx < dpT[0].length; jdx++) {
                System.out.printf("%12d ", dpT[idx][jdx]);
            }
            System.out.println();
        }
        System.out.println("-------x---------x----------------x---------x----------------x---------x---------");
    }

    public static class MinCoinChangeValue {
        public int noOfCoinChangeCount = 0;
        public int include = Integer.MAX_VALUE;
        public int exclude = Integer.MAX_VALUE;
    }

    private static int solveItRecursively(int neededAmt, int[] denoms, int index, MinCoinChangeValue mccv) {
        // BC
        if (neededAmt < 0)
            return Integer.MAX_VALUE;

        if (neededAmt == 0)
            return mccv.noOfCoinChangeCount;

        if (index < 0)
            return Integer.MAX_VALUE;

        mccv.noOfCoinChangeCount = mccv.noOfCoinChangeCount + 1;
        System.out.println("count = " + mccv.noOfCoinChangeCount);
        mccv.include = Math.min(mccv.include,
                solveItRecursively(neededAmt - denoms[index], denoms, index, mccv));
        System.out.println("inc = " + mccv.include);
        mccv.exclude = Math.min(mccv.exclude, solveItRecursively(neededAmt, denoms, index - 1, mccv));
        System.out.println("exc = " + mccv.exclude);

        mccv.noOfCoinChangeCount = Math.min(mccv.include, mccv.exclude);
        return mccv.noOfCoinChangeCount;
    }


    public static void main(String[] args) {
        TestCase1();
    }

    public static void TestCase1() {
//        int[] input = {1, 5, 10};
        int[] input = {2, 1};
//        System.out.println(MinCoinChange.minNumberOfCoinsForChange(7, input) == 3);
        System.out.println(MinCoinChange.minNumberOfCoinsForChange(3, input));
    }
}
