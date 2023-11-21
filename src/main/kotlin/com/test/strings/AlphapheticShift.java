package com.test.strings;
//Given a string, your task is to replace each of its characters by the next one in the English alphabet; i.e. replace a with b, replace b with c, etc (z would be replaced by a).
//
//Example
//
//For inputString = "crazy", the output should be solution(inputString) = "dsbaz".
//
//Input/Output
//
//[execution time limit] 3 seconds (java)
//
//[memory limit] 1 GB
//
//[input] string inputString
//
//A non-empty string consisting of lowercase English characters.
//
//Guaranteed constraints:
//1 ≤ inputString.length ≤ 1000.
//
//[output] string
//
//The resulting string after replacing each of its characters.
public class AlphapheticShift {
    String solution(String inputString) {
        // inputString.chars().map(ch -> ch+1).collect(arg0, arg1, arg2)
        Character[] charArray = new Character[inputString.length()];
        for (int index = 0; index < inputString.length(); index++) {
            int temp = (int) inputString.charAt(index);
            temp = temp + 1;
            // char tempChar = temp + '0';
            // inputString.charAt(index).
            // System.out.println("inputString.charAt(index) is " +
            // inputString.charAt(index) + " temp is "+ temp +" charValue is " +
            // (char)temp);
            if (temp > 122) {
                temp = temp - 26;
            }
            charArray[index] = (char) temp;
        }
        String result = "";
        for (int index = 0; index < charArray.length; index++) {
            result = result + charArray[index];
        }
        return result;

    }

    public static void main(String[] args) {
        AlphapheticShift alphapheticShift = new AlphapheticShift();
        System.out.println("crazy is "+alphapheticShift.solution("crazy") +" expected is dsbaz");
        System.out.println("z is "+alphapheticShift.solution("z") +" expected is a");
        System.out.println("aaaabbbccd is "+alphapheticShift.solution("aaaabbbccd") +" expected is bbbcccdde");
        System.out.println("fuzzy is "+alphapheticShift.solution("fuzzy") +" expected is gvaaz");
        System.out.println("codesignal is "+alphapheticShift.solution("codesignal") +" expected is dpeftjhobm");
        System.out.println("bvaasz is "+alphapheticShift.solution("bvaasz") +" expected is cwbbaa");


    }
}
