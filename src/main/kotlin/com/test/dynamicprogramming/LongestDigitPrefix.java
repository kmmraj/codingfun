package com.test.dynamicprogramming;
//Given a string, output its longest prefix which contains only digits.
//
//Example
//
//For inputString = "123aa1", the output should be
//solution(inputString) = "123".
//
//Input/Output
//
//[execution time limit] 3 seconds (java)
//
//[memory limit] 1 GB
//
//[input] string inputString
//
//Guaranteed constraints:
//3 ≤ inputString.length ≤ 100.
//
//[output] string
public class LongestDigitPrefix {
    String solution(String inputString) {
//        int maxDigitLength = 0;
//        int currDigitLength = 0;
//        return solveItRec(inputString,0,"","",false);
        int index;
        for (index = 0; index < inputString.length(); index++) {
            if (!Character.isDigit(inputString.charAt(index)))
                break;
        }
        return inputString.substring(0, index);

    }
    String solveItRec(String inputString,int index,String maxDigit, String currDigit,boolean charStringStarted) {
        // BC
        System.out.println("index is  " + index);
        if(index == inputString.length()){
            System.out.println(" BC currDigit.length() " + currDigit.length() +" maxDigit.length() " + maxDigit.length());
            if(currDigit.length() > maxDigit.length() ){
                return currDigit;
            }
            return maxDigit;
        }

        // H & I
        int charValue = inputString.charAt(index);
        System.out.println("charValue is  " + charValue + " char is "+ inputString.charAt(index));
        int prevCharValue = 0;
        if(index-1 >=0){
            prevCharValue = inputString.charAt(index-1);
        }

        if(prevCharValue == 32 && !(charValue >= 48 && charValue <= 57)){
            // This means char arrived
            charStringStarted = true;
            if(currDigit.length() > maxDigit.length()){
                maxDigit = currDigit;
            }
            return solveItRec(inputString,index+1,maxDigit,"",charStringStarted);
        }
        if(charValue >= 48 && charValue <= 57 && prevCharValue !=32 && !charStringStarted){
            return solveItRec(inputString,index+1,maxDigit,currDigit+inputString.charAt(index),charStringStarted);
        } else {
            System.out.println("currDigit.length() " + currDigit.length() +" maxDigit.length() " + maxDigit.length());
            if(currDigit.length() > maxDigit.length()){
                maxDigit = currDigit;
            }
            return solveItRec(inputString,index+1,maxDigit,"",charStringStarted);
        }
    }

    //function longestDigitsPrefix(inputString) {
    //    for(var i = 0;  i < inputString.length; i++) {
    //        if(!/\d/.test(inputString[i]))
    //            break
    //    }
    //    return inputString.substring(0,i);
    //}
    String longestDigitsPrefix(String inputString) {
        int index;
        for(index = 0; index < inputString.length(); index++) {
            if(!Character.isDigit(inputString.charAt(index)))
                break;
        }
        return inputString.substring(0,index);
    }

    public static void main(String[] args) {
        LongestDigitPrefix longestDigitPrefix = new LongestDigitPrefix();
        String inputString = "123aa1";
        String maxDigit = longestDigitPrefix.solution(inputString);
        System.out.println("Expected value 123 and the actual is " +maxDigit);

        inputString = "0123456789";
        maxDigit = longestDigitPrefix.solution(inputString);
        System.out.println("Expected value 0123456789 and the actual is " +maxDigit);

        inputString = "  3) always check for whitespaces";
        maxDigit = longestDigitPrefix.solution(inputString);
        System.out.println("Expected value 3 and the actual is " +maxDigit);

        inputString = "12abc34";
        maxDigit = longestDigitPrefix.solution(inputString);
        System.out.println("Expected value 12 and the actual is " +maxDigit);

        inputString = "the output is 42";
        maxDigit = longestDigitPrefix.solution(inputString);
        System.out.println("Expected value 42 and the actual is " +maxDigit);

        inputString = "aaaaaaa";
        maxDigit = longestDigitPrefix.solution(inputString);
        System.out.println("Expected value  and the actual is " +maxDigit);

        inputString = "0123456789";
        maxDigit = longestDigitPrefix.solution(inputString);
        System.out.println("Expected value 0123456789 and the actual is " +maxDigit);

        inputString = "  3) always check for whitespaces";
        maxDigit = longestDigitPrefix.solution(inputString);
        System.out.println("Expected value 3 and the actual is " +maxDigit);

        inputString = "12abc34";
        maxDigit = longestDigitPrefix.solution(inputString);
        System.out.println("Expected value 12 and the actual is " +maxDigit);

        inputString = "the output is 42";
        maxDigit = longestDigitPrefix.solution(inputString);
        System.out.println("Expected value 42 and the actual is " +maxDigit);

        inputString = "aaaaaaa";
        maxDigit = longestDigitPrefix.solution(inputString);
        System.out.println("Expected value  and the actual is " +maxDigit);

        inputString = "0123456789";
        maxDigit = longestDigitPrefix.solution(inputString);
        System.out.println("Expected value 0123456789 and the actual is " +maxDigit);

    }


}
