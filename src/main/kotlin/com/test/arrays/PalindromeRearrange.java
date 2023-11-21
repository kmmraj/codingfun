package com.test.arrays;

import java.util.HashMap;
import java.util.Map;

public class PalindromeRearrange {
    //Given a string, find out if its characters can be rearranged to form a palindrome.
    //
    //Example
    //
    //For inputString = "aabb", the output should be
    //solution(inputString) = true.
    //
    //We can rearrange "aabb" to make "abba", which is a palindrome.
    //
    //Input/Output
    //
    //[execution time limit] 3 seconds (java)
    //
    //[memory limit] 1 GB
    //
    //[input] string inputString
    //
    //A string consisting of lowercase English letters.
    //
    //Guaranteed constraints:
    //1 ≤ inputString.length ≤ 50.
    //
    //[output] boolean
    //
    //true if the characters of the inputString can be rearranged to form a palindrome, false otherwise.

    boolean solution(String inputString) {
// aabb -> abba (v)
// aaabbb -> abbba (x)
// aaaabbb -> aabbbaa (v)
// aaabbcc -> abcacba (v)
// All elements has to be even except only one that ***can** be odd
        System.out.println("inputString is "+inputString);
        Map<Character,Integer> charMap = new HashMap<>();
        for (int index = 0; index < inputString.length(); index++) {
            Character tempChar = inputString.charAt(index);
            if(charMap.containsKey(tempChar)){
                Integer count = charMap.get(tempChar);
                charMap.put(tempChar,Integer.valueOf(count+1));
            } else {
                charMap.put(tempChar,Integer.valueOf(1));
            }
        }

//        int oddCount = charMap.values().stream()
//                .filter(count -> count % 2 == 1)
//                .reduce(0,Integer::sum);
//
////System.out.println("oddCount is " + oddCount);
//
//        return  oddCount <= 1;
        long oddCount = charMap.entrySet().stream().filter(entry -> entry.getValue() % 2 == 1).count();
        return  oddCount <= 1;

    }

    public static void main(String[] args) {
        PalindromeRearrange palindromeRearrange = new PalindromeRearrange();
        System.out.println(palindromeRearrange.solution("aabb"));
        System.out.println(palindromeRearrange.solution("aaabbb"));
        System.out.println(palindromeRearrange.solution("aaaabbb"));//true => "aabbbaa"
        System.out.println(palindromeRearrange.solution("aaabbcc")); //true => "abcacba"
    }

}
