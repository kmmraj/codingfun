package com.test.stack;
// https://leetcode.com/problems/min-stack/
/**
 * 155. Min Stack
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Implement the MinStack class:
 *
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * You must implement a solution with O(1) time complexity for each function.
 *
 *
 *
 * Example 1:
 *
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * Output
 * [null,null,null,null,-3,null,0,-2]
 *
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 *
 *
 * Constraints:
 *
 * -231 <= val <= 231 - 1
 * Methods pop, top and getMin operations will always be called on non-empty stacks.
 * At most 3 * 104 calls will be made to push, pop, top, and getMin.
 */

import java.util.Deque;
import java.util.LinkedList;

class MinStack {

    class LastMinHolder {
        Integer val;
        Integer min;

        LastMinHolder(Integer val, Integer min) {
            this.val = val;
            this.min = min;
        }
    }

    private Deque<LastMinHolder> lastMinDeque;

    public MinStack() {
        lastMinDeque = new LinkedList<>();
    }

    public void push(int val) {
        lastMinDeque.addFirst(
                new LastMinHolder(val,
                        Integer.min(val, isEmpty() ? val : getMin())));

    }

    public void pop() {
        lastMinDeque.removeFirst();
    }

    public int top() {
        return lastMinDeque.peekFirst().val;
    }

    public int getMin() {
        return lastMinDeque.peekFirst().min;
    }

    private boolean isEmpty() {
        return lastMinDeque.size() == 0;
    }


    public static void main(String[] args) {
        // Test the methods
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);

        System.out.println("minStack.getMin() should be 0 and the result is " + minStack.getMin());
        minStack.pop();
        System.out.println("minStack.getMin() should be 0 and the result is " + minStack.getMin());
        minStack.pop();

        System.out.println("minStack.getMin() should be 0 and the result is " + minStack.getMin());
        minStack.pop();

        System.out.println("minStack.getMin() should be 2 and the result is " + minStack.getMin());

        // Add more values
        minStack.push(4);
        minStack.push(2);
        minStack.push(1);
        minStack.push(0);

        // Check min values
        System.out.println("minStack.getMin() should be 0 and the result is " + minStack.getMin());
        minStack.pop();
        System.out.println("minStack.getMin() should be 1 and the result is " + minStack.getMin());
    }
}
