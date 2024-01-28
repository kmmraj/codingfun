package com.test.strings;
// https://leetcode.com/problems/count-and-say/description/

/**
 * 38. Count and Say
 * To generate a member of the sequence from the previous member, read off the digits of the previous member,
 * counting the number of digits in groups of the same digit. For example:
 *
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, one 1" or 1211.
 * 1211 is read off as "one 1, one 2, two 1s" or 111221.
 * 111221 is read off as "three 1s, two 2s, one 1" or 312211.
 *
 * The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
 *
 * countAndSay(1) = "1"
 * countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1),
 * which is then converted into a different digit string.
 * To determine how you "say" a digit string,
 * split it into the minimal number of substrings such that each substring contains exactly one unique digit.
 * Then for each substring, say the number of digits, then say the digit. Finally, concatenate every said digit.
 *
 * For example, the saying and conversion for digit string "3322251":
 * Given a positive integer n, return the nth term of the count-and-say sequence.
 *
 * Example 1:
 * Input: n = 1
 * Output: "1"
 * Explanation: This is the base case.
 *
 * Example 2:
 * Input: n = 4
 * Output: "1211"
 * Explanation:
 * countAndSay(1) = "1"
 * countAndSay(2) = say "1" = one 1 = "11"
 * countAndSay(3) = say "11" = two 1's = "21"
 * countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
 */
public class CountAndSay {
    public String countAndSay(int n) {
        String result = "1";
        for (int idx = 1; idx < n; idx++) {
            result = computeNext(result);
            // System.out.println("idx is " + idx + " result is " + result);
        }
        return result;
    }

    private String computeNext(String text) {
        StringBuilder sb = new StringBuilder();
        for (int idx = 0; idx < text.length(); idx++) {
            int count = 1;
            while (idx+1 < text.length() && text.charAt(idx + 1) == text.charAt(idx)) {
                count++;
                idx++;
            }
            sb.append(count);
            sb.append(text.charAt(idx));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        System.out.println("countAndSay.countAndSay(1) should be 1 and result is "
                + countAndSay.countAndSay(1));
        System.out.println("countAndSay.countAndSay(2) should be 11 and result is "
                + countAndSay.countAndSay(2));
        System.out.println("countAndSay.countAndSay(3) should be 21 and result is "
                + countAndSay.countAndSay(3));
        System.out.println("countAndSay.countAndSay(4) should be 1211 and result is "
                + countAndSay.countAndSay(4));
        System.out.println("countAndSay.countAndSay(5) should be 111221 and result is "
                + countAndSay.countAndSay(5));
    }
}
