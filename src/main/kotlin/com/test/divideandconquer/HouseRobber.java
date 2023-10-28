package com.test.divideandconquer;

public class HouseRobber {

    private static int rob(int[] houses, int amount, int index) {
        // BC
        if (index >= houses.length) {
            return amount;
        }

        // Hypo
        int robCurrent = houses[index] + rob(houses, amount, index + 2);
        int robSkipCurrent = rob(houses, amount, index + 1);

        // Induction
        amount = Integer.max(robCurrent, robSkipCurrent);
        return amount;
    }

    private static int robBottomUp(int[] houses) {
        int[] memo = new int[houses.length + 2];

        for (int index = 2; index < houses.length + 2; index++) {
            int robCurrent = houses[index - 2] + memo[index - 2];
            int robSkipCurrent = memo[index - 1];
            memo[index] = Integer.max(robCurrent, robSkipCurrent);
        }
        return memo[memo.length - 1];
    }


    public static int maxMoneyTopDown(int[] houseNetWorth) {
        int index = 0;
        int[] memo = new int[houseNetWorth.length + 2];
        maxMoneyTopDown(houseNetWorth, index, memo);
        return memo[0];
    }

    private static int maxMoneyTopDown(int[] houseNetWorth, int index, int[] memo) {
        // BC
        if (index >= houseNetWorth.length) {
            return 0;
        }
        if (memo[index] == 0) {
            int includeCurrentHome = houseNetWorth[index] + maxMoneyTopDown(houseNetWorth, index + 2, memo);
            int skipCurrentHome = maxMoneyTopDown(houseNetWorth, index+1, memo);
            memo[index] = Math.max(includeCurrentHome, skipCurrentHome);
        }

        return memo[index];
    }

//    private static int robBottomUp(int[] houses) {
//        int[] memo = new int[houses.length + 2];
//
//        for (int index = houses.length-1; index >= 0; index--) {
//            int robCurrent = houses[index] + memo[index+ 2];
//            int robSkipCurrent = memo[index +1];
//            memo[index] = Integer.max(robCurrent, robSkipCurrent);
//        }
//        return memo[0];
//    }

    public static void main(String[] args) {
        System.out.println(HouseRobber.rob(new int[]{1, 2, 3, 1, 5, 6, 7}, 0, 0));
        System.out.println(HouseRobber.robBottomUp(new int[]{1, 2, 3, 1, 5, 6, 7}));
        System.out.println(HouseRobber.maxMoneyTopDown(new int[]{1, 2, 3, 1, 5, 6, 7}));

        System.out.println(HouseRobber.rob(new int[]{1, 2, 3, 1, 5, 6, 7, 12}, 0, 0));
        System.out.println(HouseRobber.robBottomUp(new int[]{1, 2, 3, 1, 5, 6, 7, 12}));
        System.out.println(HouseRobber.maxMoneyTopDown(new int[]{1, 2, 3, 1, 5, 6, 7, 12}));


        System.out.println(HouseRobber.rob(new int[]{1, 2, 3, 1, 5, 6, 7, 12, 1, 17}, 0, 0));
        System.out.println(HouseRobber.robBottomUp(new int[]{1, 2, 3, 1, 5, 6, 7, 12, 1, 17}));
        System.out.println(HouseRobber.maxMoneyTopDown(new int[]{1, 2, 3, 1, 5, 6, 7, 12, 1, 17}));
    }


}
