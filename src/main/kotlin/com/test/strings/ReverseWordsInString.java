package com.test.strings;
// https://leetcode.com/problems/reverse-words-in-a-string/description/

/**
 * 151. Reverse Words in a String
 * Given an input string s, reverse the order of the words.
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 * Return a string of the words in reverse order concatenated by a single space.
 *
 * Note that s may contain leading or trailing spaces or multiple spaces between two words.
 * The returned string should only have a single space separating the words. Do not include any extra spaces.
 *
 *
 *
 * Example 1:
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 *
 * Example 2:
 * Input: s = "  hello world  "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 *
 * Example 3:
 * Input: s = "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s contains English letters (upper-case and lower-case), digits, and spaces ' '.
 * There is at least one word in s.
 */
public class ReverseWordsInString {

    public String reverseWords(String s) {
        String withOutLeadingAndTrailing = "^\\s+|\\s+$";
        String trimmedString = s.replaceAll(withOutLeadingAndTrailing,"");
        // System.out.println(trimmedString);
        trimmedString = trimmedString.replaceAll("\\s{2,}"," ");

        String reversedStr = reverse(trimmedString,0,trimmedString.length()-1);
        int start = 0, end = reversedStr.length()-1;
        int wordEndIdx =0;
        while((wordEndIdx = find(reversedStr,start))!=-1){
            //int wordEndIdx = find(reversedStr,start);
            //    System.out.println("wordEndIdx is "+ wordEndIdx);
            reversedStr = reverse(reversedStr,start,wordEndIdx-1);
            start = wordEndIdx+1;
        }
        reversedStr = reverse(reversedStr,start,reversedStr.length()-1);
        return reversedStr;
    }

    private int find(String str, int start){
        return str.indexOf(" ",start);
    }

    private String reverse(String str,int start,int end){
        char[] charArray = str.toCharArray();
        while(start<end){
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {

    }
}
