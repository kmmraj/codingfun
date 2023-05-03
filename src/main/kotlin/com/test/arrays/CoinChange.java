package com.test.arrays;

public class CoinChange {

    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        // Write your code here.
        return solveItRecursively(n, denoms, 0);
    }

    public static int solveItRecursively(int neededAmt, int[] denoms, int index) {
        //BC
        if (neededAmt < 0) {
            return 0;
        }
        if (neededAmt == 0) {
            return 1;
        }

        if (index >= denoms.length) {
            return 0;
        }
//        int include;
//        int exclude;
//        for (int idx = 0; idx < index; idx++) {
//            include = solveItRecursively(neededAmt-denoms[idx], denoms, idx);
//            exclude = solveItRecursively(neededAmt, denoms, idx + 1);
//        }

        //return include+exclude;
        return 1;

    }

    public static class CoinChangeValue {
        public int tempNumberOfWays = 0;
        public int maxNumberOfWays = 0;
        public int tempSum;
    }

    public static void main(String[] args) {
        TestCase1();
        TestCase2();
    }

    public static void TestCase1() {
        int[] input = {1, 5};
        System.out.println(CoinChange.numberOfWaysToMakeChange(6, input) == 2);
    }

    public static void TestCase2() {
        int[] input = {2, 3, 4, 7};
        System.out.println(CoinChange.numberOfWaysToMakeChange(7, input) == 3);
    }
}
