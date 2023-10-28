package com.test.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FibonanciSeriesMemo {

    private static int getFiboMemoNumber(int num) {

        Map<Integer, Integer> memo = new HashMap<>();
        return FibonanciSeriesMemo.getFiboMemoNumber(num, memo);
    }

    private static int getFiboMemoNumber(int num, Map<Integer, Integer> memo) {
        // BC
        if (num == 1) {
            return 0;
        }

        if (num == 2) {
            return 1;
        }
        if (!memo.containsKey(num)) {
            memo.put(num, getFiboMemoNumber(num - 1, memo) + getFiboMemoNumber(num - 2, memo));
        }
//        memo.computeIfAbsent(num, integer -> getFiboNumber(integer - 1, memo) + getFiboNumber(integer - 2, memo));
        return memo.get(num);
    }

    private static int getFiboTabNumber(int num) {
        List<Integer> numberList = new ArrayList<>();
        numberList.add(0);
        numberList.add(1);
        for (int index = 2; index <= num-1; index++) {
            int cal1 = numberList.get(index-1) + numberList.get(index-2);
            numberList.add(cal1);
        }
        return numberList.get(num-1);
    }

    public static void main(String[] args) {
        System.out.println("Fibonanci 5th number is " + FibonanciSeriesMemo.getFiboMemoNumber(5));
        System.out.println("Fibonanci 6th number is " + FibonanciSeriesMemo.getFiboMemoNumber(6));
        System.out.println("Fibonanci 7th number is " + FibonanciSeriesMemo.getFiboMemoNumber(7));
        System.out.println("Fibonanci 8th number is " + FibonanciSeriesMemo.getFiboMemoNumber(8));
        System.out.println("Fibonanci 8th number is " + FibonanciSeriesMemo.getFiboMemoNumber(8));
        System.out.println("Fibonanci 8th number is " + FibonanciSeriesMemo.getFiboTabNumber(8));
        System.out.println("Fibonanci 9th number is " + FibonanciSeriesMemo.getFiboTabNumber(9));
    }




}
