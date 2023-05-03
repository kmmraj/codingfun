package com.test.stack;

import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class SortUsingStack {
    public static void main(String[] args) {
        Stack<Integer> input = new Stack<>();
        input.add(34);
        input.add(3);
        input.add(31);
        input.add(98);
        input.add(92);
        input.add(23);

        Stack<Integer> sortedNumbers = sortIt(input);
        List<Integer> integerList = sortedNumbers.subList(0,sortedNumbers.size());
        for (int item: integerList) {
            System.out.print(item+", ");
        }
    }

    private static Stack<Integer> sortIt(Stack<Integer> input) {
        Stack<Integer> temp = new Stack<>();


        // 34 -> 3 -> 31 -> 98 -> 92 -> 23
        while(!input.isEmpty()) {
            Integer key = input.pop();
            while (!temp.isEmpty()  &&  key < temp.peek()){
                input.push(temp.pop());
            }
            temp.push(key);
        }
        return temp;
    }
}
