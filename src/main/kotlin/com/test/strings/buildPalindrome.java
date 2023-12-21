package com.test.strings;
//Given a string, find the shortest possible string which can be achieved by adding characters to the end of
// initial string to make it a palindrome.
//
//Example
//
//For st = "abcdc", the output should be
//solution(st) = "abcdcba".
//
//Input/Output
//
//[execution time limit] 3 seconds (java)
//
//[memory limit] 1 GB
//
//[input] string st
//
//A string consisting of lowercase English letters.
//
//Guaranteed constraints:
//3 ≤ st.length ≤ 10.
//
//[output] string
public class buildPalindrome {

    String solution(String st) {
        String reversedString = new StringBuilder(st).reverse().toString();
        if(reversedString.equals(st)) return st;
        for(int index = 0;index<st.length(); index++ ){
            String newString = st.substring(0,index)+reversedString;
           // System.out.println("New String: "+newString);
            if(newString.contentEquals(new StringBuilder(newString).reverse())){
                return newString;
            }

        }
        return "lol";
    }

    public static void main(String[] args) {
        buildPalindrome buildPalindrome = new buildPalindrome();
        System.out.println(buildPalindrome.solution("abcdc"));
        System.out.println(buildPalindrome.solution("abcdcba"));
        System.out.println(buildPalindrome.solution("abcd"));
        System.out.println(buildPalindrome.solution("abcde"));
        System.out.println(buildPalindrome.solution("abccba"));
    }
}
