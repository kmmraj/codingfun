package com.test.misc;

public class DeleteDigit {

    int solution(int n) {
        String number = String.valueOf(n);
        char[] numArray = number.toCharArray();
        int maxNum = Integer.MIN_VALUE;
        for (int idx = 0; idx < numArray.length; idx++) {
            String tempString = "";
            for (int jdx = 0; jdx < numArray.length; jdx++) {
                if(idx == jdx){
                    continue;
                }
                tempString = tempString + numArray[jdx];
            }
            maxNum = Math.max(maxNum,Integer.parseInt(tempString));
        }
        return maxNum;
    }


    public static void main(String[] args) {
        System.out.println("The value should be 52 and the actual value is: " + new DeleteDigit().solution(152));
        System.out.println("The value should be 101 and the actual value is: " + new DeleteDigit().solution(1001));
    }
}
