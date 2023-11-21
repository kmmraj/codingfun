//package com.test.divideandconquer;
//
//import org.graalvm.collections.Pair;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class NumberFactor {
//
//
//    public static void main(String[] args) {
//        System.out.println(NumberFactor.waysToGetNFactorDP(4));
//        System.out.println(NumberFactor.waysToGetNFactorPair(4, new ArrayList<>()));
//        System.out.println(NumberFactor.waysToGetNFactorTab(4));
//        System.out.println(NumberFactor.waysToGetNFactorTopDown(4));
//        System.out.println(NumberFactor.waysToGetNFactorTab(5));
//        System.out.println(NumberFactor.waysToGetNFactorTopDown(5));
//    }
//
//    private static int waysToGetNFactor(int maxNumber) {
//        // BC
//        if (maxNumber == 0 || maxNumber == 1 || maxNumber == 2) {
//            return 1;
//        }
//        if (maxNumber == 3) {
//            return 2;
//        }
//        // I
//        int subtract1 = waysToGetNFactor(maxNumber - 1);
//        int subtract3 = waysToGetNFactor(maxNumber - 3);
//        int subtract4 = waysToGetNFactor(maxNumber - 4);
//        return subtract1 + subtract3 + subtract4;
//    }
//
//    private static int waysToGetNFactorTopDown(int maxNumber) {
//        int[] memo = new int[maxNumber+1];
//        return waysToGetNFactorTopDown(maxNumber,memo);
//    }
//
//    private static int waysToGetNFactorTopDown(int maxNumber, int[] memo) {
//        // BC
//        if (maxNumber == 0 || maxNumber == 1 || maxNumber == 2) {
//            return 1;
//        }
//        if (maxNumber == 3) {
//            return 2;
//        }
//        // I
//        if (memo[maxNumber] == 0) {
//            int subtract1 = waysToGetNFactorTopDown(maxNumber - 1);
//            int subtract3 = waysToGetNFactorTopDown(maxNumber - 3);
//            int subtract4 = waysToGetNFactorTopDown(maxNumber - 4);
//            memo[maxNumber] = subtract1 + subtract3 + subtract4;
//        }
//
//        return memo[maxNumber];
//    }
//
//
//    private static int waysToGetNFactorTab(int maxNumber) {
//        Map<Integer, Integer> tabMemo = new HashMap<>();
//        tabMemo.put(0, 1);
//        tabMemo.put(1, 1);
//        tabMemo.put(2, 1);
//        tabMemo.put(3, 2);
//        for (int index = 4; index <= maxNumber; index++) {
//            int subtract1 = tabMemo.get(index - 1);
//            int subtract3 = tabMemo.get(index - 3);
//            int subtract4 = tabMemo.get(index - 4);
//            tabMemo.put(index, subtract1 + subtract3 + subtract4);
//        }
//        return tabMemo.get(maxNumber);
//    }
//
//
//    private static List<List<Integer>> waysToGetNFactorPair(int maxNumber, List<List<Integer>> resultList) {
//        // BC
//        if (maxNumber == 0 || maxNumber == 1) {
//            return resultList;
//        }
//        if (maxNumber == 2) {
//            List<Integer> list = new ArrayList<>();
//            list.add(1);
//            list.add(1);
//            resultList.add(list);
//            return resultList;
//        }
//        if (maxNumber == 3) {
//            List<Integer> list = new ArrayList<>();
//            list.add(1);
//            list.add(1);
//            list.add(1);
//            resultList.add(list);
//            return resultList;
//        }
//
//        // I
//        // 1,3,4
//        // TODO : create the induction step
////        List<Integer> list = new ArrayList<>();
////        if (maxNumber % 4 >= 0) {
////            maxNumber = maxNumber - 4;
////            list.add(4);
////        }
////        if (maxNumber % 3 >= 0) {
////            maxNumber = maxNumber - 3;
////            list.add(3);
////        }
////        if (maxNumber % 1 >= 0) {
////            maxNumber = maxNumber - 1;
////            list.add(1);
////        }
////        resultList.add(list);
//
//        // H
//
//        List<List<Integer>> subtract1 = waysToGetNFactorPair(maxNumber - 1, resultList);
//        List<List<Integer>> subtract3 = waysToGetNFactorPair(maxNumber - 3, resultList);
//        List<List<Integer>> subtract4 = waysToGetNFactorPair(maxNumber - 4, resultList);
//        subtract1.addAll(subtract3);
//        subtract1.addAll(subtract4);
//        return subtract1;
//    }
//
//    private static int[] waysToGetNFactorDP(int maxNumber) {
//        int[] dp = new int[maxNumber + 1];
//        dp[0] = dp[1] = dp[2] = 1;
//        dp[3] = 2;
//
//        for (int i = 4; i <= maxNumber; i++)
//            dp[i] = dp[i - 1] + dp[i - 3] + dp[i - 4];
//
//        return dp;
//    }
//}
