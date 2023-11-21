package com.test.stack;

import java.util.Stack;

public class ReverseParanthesis {
    String solution(String inputString) {

        Stack<Character> tempStack = new Stack<>();
        String result = "";
        boolean inReverseNeed = false;
        for (int index = 0; index < inputString.length(); index++) {
            // inputString: "foo(bar(baz))blim"
            // Expected return value "foobazrabblim"
            // Actual foozabrabblim" -> "foobazblim"
            System.out.println("inputString.charAt("+ index + ") is " + inputString.charAt(index));
            if(inputString.charAt(index) == '(' || inputString.charAt(index) == ')'){
                inReverseNeed = true;
                // Skip the current '('
                index++;
                while(inputString.charAt(index) != ')' && inputString.charAt(index) != '(' ){
                    System.out.println("-+Stack-inputString.charAt("+ index + ") is " + inputString.charAt(index));
                    tempStack.add(inputString.charAt(index));
                    index++;
                }
                System.out.println("--inputString.charAt("+ index + ") is " + inputString.charAt(index));

                if(inputString.charAt(index) == ')'){
                    while(!tempStack.isEmpty()){
                        Character tempChar = tempStack.pop();
                        if(tempChar != '('){
                            result = result + tempChar;
                        }
                    }
                }
            }
            if(inputString.charAt(index) != '(' && inputString.charAt(index) != ')' ){
                result = result +inputString.charAt(index);
            }


        }
        return result;

    }

    public static void main(String[] args) {
        ReverseParanthesis reverseParanthesis = new ReverseParanthesis();
        System.out.println(reverseParanthesis.solution("foo(bar(baz))blim"));
    }
}
