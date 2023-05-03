package com.test;

import java.util.Stack;

public class EvaluatePostFixExp {
    public static void main(String[] args) {
        String expression = "2 3 1 * + 9 -";

        Stack<Character> expStack = new Stack();
        Integer finalResult = null;


        for (int index =0; index <  expression.length(); index++) {
            if(expression.charAt(index) != ' ' ) {

                if(Character.isDigit(expression.charAt(index))) {
                    expStack.push(expression.charAt(index));
                }

                if(!Character.isDigit(expression.charAt(index))) {
                    Character characterOne = expStack.pop();
                    Character characterTwo = expStack.pop();

                    int integerOne = Character.getNumericValue(characterOne);
                    int integerTwo = Character.getNumericValue(characterTwo);
                    finalResult = calculate(integerOne, integerTwo,expression.charAt(index));
                    char ch=(char)(finalResult+'0');
                    expStack.push(ch);
                }

            }
        }

        System.out.println("Final Result is: "+ finalResult);


    }

    private static int calculate(int integerOne, int integerTwo, char charAt) {
        switch (charAt){
            case '+':
                return integerOne + integerTwo;

            case '-':
                return integerOne - integerTwo;
            case '*':
                return integerOne * integerTwo;
            case '/':
                return integerOne / integerTwo;
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
    }


}
