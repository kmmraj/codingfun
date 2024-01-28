package com.test.stack;
// https://leetcode.com/problems/valid-parenthesis-string/description/

/**
 * 678. Valid Parenthesis String
 * Given a string s containing only three types of characters: '(', ')' and '*',
 * return true if s is valid.
 * <p>
 * The following rules define a valid string:
 * <p>
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis
 * '(' or an empty string "".
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "()"
 * Output: true
 * <p>
 * Example 2:
 * Input: s = "(*)"
 * Output: true
 * <p>
 * Example 3:
 * Input: s = "(*))"
 * Output: true
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 100
 * s[i] is '(', ')' or '*'.
 */
public class ValidParenthesis2 {

    public boolean checkValidString(String s) {
        //System.out.println("Input is " + s);
        int low = 0, high = 0;
        for (int idx = 0; idx < s.length(); idx++) {
            char charVal = s.charAt(idx);
            if (charVal == '(') {
                low++;
                high++;
            } else if (charVal == ')') {
                low--;
                high--;
            } else {
                low--;
                high++;
            }

            low = Integer.max(0, low);

            if (high < 0) {
                return false;
            }
        }

        return low == 0;

    }

    public static void main(String[] args) {
        // Test the methods
        ValidParenthesis2 validParenthesis = new ValidParenthesis2();
        System.out.println("validParenthesis.checkValidString(\"()\") should be true and the result is "
                + validParenthesis.checkValidString("()"));
        System.out.println("validParenthesis.checkValidString(\"(*)\") should be true and the result is "
                + validParenthesis.checkValidString("(*)"));
        System.out.println("validParenthesis.checkValidString(\"(*))\") should be true and the result is "
                + validParenthesis.checkValidString("(*))"));
        System.out.println("validParenthesis.checkValidString(\"(*)))\") should be false and the result is "
                + validParenthesis.checkValidString("(*)))"));
        System.out.println("validParenthesis.checkValidString(\"((*)))\") should be true and the result is "
                + validParenthesis.checkValidString("((*)))"));
    }


}
