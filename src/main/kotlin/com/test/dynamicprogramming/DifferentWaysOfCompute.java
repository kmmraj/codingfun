package com.test.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysOfCompute {
    public List<Integer> diffWaysToCompute(String input) {


        //List<Integer> ansList  = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        List<Character> ops = new ArrayList<>();

//        for (int idx = 0; idx < input.length(); idx++) {
//            if(idx%2 ==0)
//                nums.add(Integer.valueOf(input.charAt(idx)+""));
//            else
//                ops.add(input.charAt(idx));
//        }
        int start = 0;
        int end = nums.size()-1;
        int answer = 0;
        return solveIt(input);
    }

    private List<Integer> solveIt(String input) {

        List<Integer> ansList  = new ArrayList<>();
        // BC#1
        if(input.length() == 0)
            return ansList;

        for (int idx = 0; idx < input.length(); idx++) {
            if(input.charAt(idx) == '+'
            || input.charAt(idx) == '-'
            || input.charAt(idx) == '*') {

              String partOne = input.substring(0,idx);
              String partTwo = input.substring(idx+1);

              List<Integer> left = solveIt(partOne);
              List<Integer> right = solveIt(partTwo);

                for (int lItem:left) {
                    for (int rItem:right){
                        int sum;
                        sum = getValue(lItem,rItem,input.charAt(idx));
                        ansList.add(sum);
                    }
                }

            }
        }
        if(ansList.isEmpty()){
            ansList.add(Integer.valueOf(input));
        }


        return ansList;
    }

    private int getValue(int one, int two,Character ops) {

        switch (ops){
            case '+':
                return one + two;
            case '-':
                return one - two;
            case '*':
                return one * two;
        }
        return one;
    }

    public List<Integer> diffWaysToComputeDAndC(String input) {
        List<Integer> result=new ArrayList<>();
        if(input==null||input.length()==0)  return result;
        List<String> inputAsList = getInputAsList(input);
        result=compute(inputAsList, 0, inputAsList.size()-1);
        return result;
    }

    private List<String> getInputAsList(String input){
        List<String> ops = new ArrayList<>();

        for(int idx = 0; idx < input.length();idx++) {
            int digitSkipIdx = idx;
            while(digitSkipIdx< input.length() && Character.isDigit(input.charAt(digitSkipIdx)))
                digitSkipIdx++;
            ops.add(input.substring(idx,digitSkipIdx));
            idx = digitSkipIdx;

            if(idx < input.length() && !Character.isDigit(input.charAt(idx))){
                ops.add(String.valueOf(input.charAt(idx)));
            }
        }
        return ops;
    }

    private List<Integer> compute(List<String> ops, int lo, int hi){
        List<Integer> result=new ArrayList<>();
        // BC#1
        if(lo==hi){
            Integer num=Integer.valueOf(ops.get(lo));
            result.add(num);
            return result;
        }
        // D&C
        for(int i=lo+1; i<=hi-1; i=i+2){
            Character operator=ops.get(i).charAt(0);
            List<Integer> left=compute(ops,lo, i-1);
            List<Integer> right=compute(ops, i+1, hi);
            for(int leftNum:left)
                for(int rightNum: right){
                    result.add(getValue(leftNum,rightNum,operator));
                }
        }
        return result;
    }

    public static void main(String[] args) {
        DifferentWaysOfCompute ways = new DifferentWaysOfCompute();
        List<Integer> ansList = ways.diffWaysToCompute("2-10-1");
        for (int item: ansList) {
            System.out.printf("%2d ",item);
        }
        System.out.println();
        ansList = ways.diffWaysToComputeDAndC("2-10-1");
        for (int item: ansList) {
            System.out.printf("%2d ",item);
        }
//        ways.getInputAsList("2-10-1");
    }
}
