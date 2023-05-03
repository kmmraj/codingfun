package com.test.recursion;

import com.test.strings.PalindromeCheck;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome("abcdcba"));
        System.out.println(Palindrome.isPalindrome("abcddcba"));
    }

    private static boolean isPalindrome(String input) {
       return isPalindromeCheck(input,0,input.length()-1);
    }

    private static boolean isPalindromeCheck(String input, int start, int end){
        // BC
        if (start > (input.length()/2) || end < (input.length()/2))
            return true;


        // H & I
        if(input.charAt(start) !=(input.charAt(end))){
            return false;
        }
        start++;
        end--;
        return isPalindromeCheck(input,start,end);
    }
}
