package com.test.strings;
// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 * Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent. Return the answer in any order.
 * <p>
 * A mapping of digits to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 * <p>
 * Example 1:
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * <p>
 * Example 2:
 * Input: digits = ""
 * Output: []
 * <p>
 * Example 3:
 * Input: digits = "2"
 * Output: ["a","b","c"]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 */
public class LetterCombinationsOfPhoneNumber {
    static final String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        char[] letterArray = new char[digits.length()];
        return combine(digits, result, 0, letterArray);
    }


    public List<String> combine(String digits, List<String> result, int index, char[] letterArray) {
        // Take the example of 23, it corresponds to "abc" and "def"
        // BC
        if (index == digits.length()) {
            String temp = new String(letterArray);
            //Arrays.fill(letterArray, '\u0000'); // reset the letterArray with char '\u0000' which is null
            if (!temp.isEmpty()) {
                result.add(temp);
            }
        } else {
            //// index is 0, value is 2 -> "abc".length() -> 3 => index is 1, value is 3 -> "def".length() -> 3
            for (int idx = 0; idx < mapping[digits.charAt(index) - '0'].length(); idx++) {
                //index is 0, for idx = 0, letter = 'a' => index is 1, for idx = 0, letter = 'd'
                char letter = mapping[digits.charAt(index) - '0'].charAt(idx);
                // for idx = 0, letterArray[0] = 'a' => for idx = 0 => letterArray[1] = 'd'
                letterArray[index] = letter;
                // combine("23", result, 1, letterArray) is  letterArray[0] = 'a'
                // combine("23", result, 2, letterArray) => letterArray[1] = 'd
                combine(digits, result, index + 1, letterArray);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LetterCombinationsOfPhoneNumber letterCombinationsOfPhoneNumber = new LetterCombinationsOfPhoneNumber();
        System.out.println("expected is [ad, ae, af, bd, be, bf, cd, ce, cf], actual is "
                + letterCombinationsOfPhoneNumber.letterCombinations("23"));
        System.out.println("expected is [], actual is "
                + letterCombinationsOfPhoneNumber.letterCombinations(""));
        System.out.println("expected is [a, b, c], actual is "
                + letterCombinationsOfPhoneNumber.letterCombinations("2"));
    }
}
