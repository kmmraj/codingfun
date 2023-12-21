package com.test.strings;

public class SumOfNumbersInSentence {
    //codeMaster has just returned from shopping. He scanned the check of the items he bought
    // and gave the resulting string to Ratiorg to figure out the total number of purchased items.
    // Since Ratiorg is a bot he is definitely going to automate it,
    // so he needs a program that sums up all the numbers which appear in the given input.
    //
    //Help Ratiorg by writing a function that returns the sum of numbers that appear in the given inputString.
    //
    //Example
    //
    //For inputString = "2 apples, 12 oranges", the output should be
    //solution(inputString) = 14.
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
    //0 ≤ inputString.length ≤ 105.
    //
    //[output] integer
    int solution(String inputString) {

        int sum =0;
        String numValueString ="";

        for (int index = 0; index < inputString.length(); index++) {
            int charValue = inputString.charAt(index);
            if(charValue >= 48 && charValue <=57){
                numValueString = numValueString+inputString.charAt(index);
            } else {
                if(numValueString.length()>0){
                    sum = sum + Integer.valueOf(numValueString);
                    numValueString = "";
                }
            }
        }
        if(numValueString.length()>0){
            sum = sum + Integer.valueOf(numValueString);
        }
        return sum;

    }

    public static void main(String[] args) {
        System.out.println("The value should be 14 and the actual value is: " + new SumOfNumbersInSentence().solution("2 apples, 12 oranges"));
        System.out.println("The value should be 123 and the actual value is: " + new SumOfNumbersInSentence().solution("123450"));
        System.out.println("The value should be 0 and the actual value is: " + new SumOfNumbersInSentence().solution("Your payment method is invalid"));
    }
}
