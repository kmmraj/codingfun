package com.test.strings;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 13. Roman to Integer
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two ones added together.
 * 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is written as IV.
 * Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX.
 * <p>
 * There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "III"
 * Output: 3
 * Explanation: III = 3.
 * Example 2:
 * <p>
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 3:
 * <p>
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 15
 * s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
 * It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 */
public class Roman2Integer {
    static Map<Character, Integer> cMap = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000);

    public int romanToInt(String s) {

        int result = cMap.get(s.charAt(s.length() - 1));

        for (int idx = s.length() - 2; idx >= 0; idx--) {
            if (cMap.get(s.charAt(idx)) < cMap.get(s.charAt(idx + 1))) {
                result = result - cMap.get(s.charAt(idx));
            } else {
                result = result + cMap.get(s.charAt(idx));
            }
        }
        return result;
    }

    public int romanToInt2(String s) {
        int ans = 0, num = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            num = switch (s.charAt(i)) {
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 50;
                case 'C' -> 100;
                case 'D' -> 500;
                case 'M' -> 1000;
                default -> num;
            };
            if (4 * num < ans) ans -= num;
            else ans += num;
        }
        return ans;
    }


    public static void main(String[] args) {

        System.out.println("Roman2Integer.romanToInt(\"III\") should be 3 and result is "
                + new Roman2Integer().romanToInt("III"));
        System.out.println("Roman2Integer.romanToInt2(\"III\") should be 3 and result is "
                + new Roman2Integer().romanToInt2("III"));
        System.out.println("Roman2Integer.romanToInt(\"IV\") should be 4 and result is "
                + new Roman2Integer().romanToInt("IV"));
        System.out.println("Roman2Integer.romanToInt2(\"IV\") should be 4 and result is "
                + new Roman2Integer().romanToInt2("IV"));
        System.out.println("Roman2Integer.romanToInt(\"IX\") should be 9 and result is "
                + new Roman2Integer().romanToInt("IX"));
        System.out.println("Roman2Integer.romanToInt2(\"IX\") should be 9 and result is "
                + new Roman2Integer().romanToInt2("IX"));
        System.out.println("Roman2Integer.romanToInt(\"LVIII\") should be 58 and result is "
                + new Roman2Integer().romanToInt("LVIII"));
        System.out.println("Roman2Integer.romanToInt2(\"LVIII\") should be 58 and result is "
                + new Roman2Integer().romanToInt2("LVIII"));

    }
}
