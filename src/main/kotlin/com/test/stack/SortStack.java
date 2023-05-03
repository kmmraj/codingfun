package com.test.stack;

import java.util.Stack;

public class SortStack {



    private void sortTheStack(Stack<Integer> integerStack) {
        // BC
        if(integerStack.empty())
            return;

        // Hypothesis
        Integer lastValue = integerStack.pop();
        sortTheStack(integerStack);

        // Induction
        insert(integerStack,lastValue);
    }

    private void insert(Stack<Integer> integerStack, Integer lastValue) {
        // BC
        if(integerStack.empty() || integerStack.peek()  < lastValue) {
            integerStack.push(lastValue);
            return;
        }
        // Hypothesis
        Integer graterValue = integerStack.pop();
        insert(integerStack,lastValue);

        // Induction
        integerStack.push(graterValue);
    }

    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<Integer>();
        integerStack.add(5);
        integerStack.add(2);
        integerStack.add(1);
        integerStack.add(4);
        integerStack.add(3);
        SortStack sortStack = new SortStack();
        sortStack.sortTheStack(integerStack);
    }
}
