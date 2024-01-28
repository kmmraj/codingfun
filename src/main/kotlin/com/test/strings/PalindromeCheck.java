package com.test.strings;
// https://leetcode.com/problems/valid-palindrome/description/

/**
 * 125. Valid Palindrome
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
 * and removing all non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * Example 2:
 *
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * Example 3:
 *
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 2 * 105
 * s consists only of printable ASCII characters.
 */
public class PalindromeCheck {

    public static boolean isPalindrome(String str) {
        int start=0,end = str.length()-1;
        while (start<end){
            if(str.charAt(start) != str.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    public static boolean isPalindrome2(String s) {

        // int start = 0, end = s.length()-1;
        // s = s.replaceAll("[^A-Za-z0-9]","");
        // System.out.println(s);
        int start=0,end=s.length()-1;

        while(start<end){
            while(!Character.isLetterOrDigit(s.charAt(start)) && start<end ){
                start++;
            }
            while(!Character.isLetterOrDigit(s.charAt(end)) && start<end ){
                end--;
            }
            if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))){
                return false;
            }
            start++;
            end--;
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println("PalindromeCheck.isPalindrome(\"abcdcba\") should be true and result is "
                + PalindromeCheck.isPalindrome("abcdcba"));
        System.out.println("PalindromeCheck.isPalindrome2(\"abcdcba\") should be true and result is"
                +PalindromeCheck.isPalindrome2("abcdcba"));
        System.out.println("PalindromeCheck.isPalindrome(\"A man, a plan, a canal: Panama\") should be true "
                + "and result is "
                + PalindromeCheck.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println("PalindromeCheck.isPalindrome2(\"A man, a plan, a canal: Panama\") should be true "
                + "and result is "
                + PalindromeCheck.isPalindrome2("A man, a plan, a canal: Panama"));

    }
}
