package com.test.stack;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        Boolean isValid = isValidParenthesis("(]");
        System.out.println(isValid);
    }

    public static boolean isValidParenthesis(String str) {
        Stack<Character> charStack = new Stack<Character>();
        for(int index=0; index <str.length(); index++){
            if(str.charAt(index) == '[' ||
                    str.charAt(index) == '{' ||
                    str.charAt(index) == '(' ) {
                charStack.push(str.charAt(index));
            }  else if(!charStack.isEmpty() && ( (str.charAt(index) == ']' && charStack.peek() == '[') ||
                    (str.charAt(index) == '}' && charStack.peek() == '{') ||
                    (str.charAt(index) == ')' && charStack.peek() == '('))) {
                charStack.pop();
            } else {
                return false;
            }
        }
        return charStack.isEmpty();
    }
}
