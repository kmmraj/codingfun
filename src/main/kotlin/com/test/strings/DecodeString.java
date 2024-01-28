package com.test.strings;

import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {

        Stack<String> strStack = new Stack<>();
        int idx = s.length() - 1;

        //  Example strings => "3[a2[c]]",  "3[a]2[bc]",  "2[abc]3[cd]ef"

        while (idx >= 0) {
            // Push everything until you get a digit
            while (idx >= 0 && !Character.isDigit(s.charAt(idx))) {
                strStack.push(String.valueOf(s.charAt(idx)));
                idx--;
            }
            // Get the digit value -- // For example 212
            int digitVal = 0, mulIdx = 0;
            while (idx >= 0 && Character.isDigit(s.charAt(idx))) {
                digitVal = (((int) Math.pow(10, mulIdx++)) * (s.charAt(idx) - '0')) + digitVal;
                idx--;
            }
            // System.out.println("digitVal is " + digitVal + " strStack.peek() is " +
            // strStack.peek());

            // if first char after digit is '[', create the temp string until you encounter ']'
            if (digitVal > 0 && !strStack.isEmpty() && strStack.peek().charAt(0) == '[') {
                strStack.pop();
                StringBuilder subStr = new StringBuilder();
                while (!strStack.isEmpty() && strStack.peek().charAt(0) != ']') {
                    subStr.append(strStack.pop());
                }
                if (!strStack.isEmpty() && strStack.peek().charAt(0) == ']') {
                    strStack.pop();
                }
                // Push back the combined sub string to the stack of needed multiples
                while (digitVal > 0) {
                    strStack.push(subStr.toString());
                    digitVal--;
                }
            }

        }

        // Finally construct the result

        StringBuilder sb = new StringBuilder();
        while (!strStack.isEmpty()) {
            sb.append(strStack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
        System.out.println("expected is aaabcbc, actual is " + decodeString.decodeString("3[a]2[bc]"));
        System.out.println("expected is accaccacc, actual is " + decodeString.decodeString("3[a2[c]]"));
        System.out.println("expected is abcabccdcdcdef, actual is " + decodeString.decodeString("2[abc]3[cd]ef"));
        System.out.println("expected is abccdcdcdxyz, actual is " + decodeString.decodeString("abc3[cd]xyz"));

    }
}
