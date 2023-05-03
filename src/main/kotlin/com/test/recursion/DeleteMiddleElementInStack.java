package com.test.recursion;

import java.util.Stack;

public class DeleteMiddleElementInStack {

    private void deleteMiddleElement(Stack<Integer> integerStack) {
        int middleIndex = (integerStack.size()/2) + 1;
        solve(integerStack,middleIndex);
    }

    private void solve(Stack<Integer> integerStack, int middleIndex) {
        // BC
        if(middleIndex  == 1){
            integerStack.pop();
            return;
        }

        // Hypothesis
        int remainingValue = integerStack.pop();
        solve(integerStack,middleIndex-1);

        // Induction
        integerStack.push(remainingValue);
    }

    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<Integer>();
        integerStack.add(5);
        integerStack.add(4);
        integerStack.add(3);
        integerStack.add(2);
        integerStack.add(1);
        DeleteMiddleElementInStack dmeins = new DeleteMiddleElementInStack();
        dmeins.deleteMiddleElement(integerStack);

        while (!integerStack.empty()){
            System.out.println(integerStack.pop());
        }
    }


}
