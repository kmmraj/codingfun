package com.test.stack;

import java.util.Deque;
import java.util.LinkedList;

public class StackUsingQueue2 {


    Deque<Integer> enq;
    Deque<Integer> deq;

    public StackUsingQueue2() {
        enq = new LinkedList<>();
        deq = new LinkedList<>();
    }

    public void push(int x) {
        enq.addLast(x);
    }

    public int pop() {
        while (enq.size() > 1) {
            deq.addLast(enq.removeFirst());
        }
        int result = -1;
        if (enq.size() == 1) {
            result = enq.removeFirst();
        }
        // Copy back the deq and empty the deque
        enq = deq;
        deq = new LinkedList<>();
        return result;
    }

    public int top() {
        while (enq.size() > 1) {
            deq.addLast(enq.removeFirst());
        }
        int result = -1;
        if (enq.size() == 1) {
            result = enq.getFirst();
            deq.addLast(enq.removeFirst());
        }
        // Copy back the deq and empty the deque
        enq = deq;
        deq = new LinkedList<>();
        return result;

    }

    public boolean empty() {
        return enq.isEmpty();
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

public static void main(String[] args) {
    // Create the stack
    StackUsingQueue2 stack = new StackUsingQueue2();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    System.out.println("stack.pop() should be 3 and the result is " + stack.pop());
    stack.push(4);
    stack.push(5);
    System.out.println("stack.pop() should be 5 and the result is " + stack.pop());
    System.out.println("stack.pop() should be 4 and the result is " + stack.pop());
    System.out.println("stack.top() should be 2 and the result is " + stack.top());
    System.out.println("stack.pop() should be 2 and the result is " + stack.pop());
    System.out.println("stack.pop() should be 1 and the result is " + stack.pop());
    System.out.println("stack.empty() should be true and the result is " + stack.empty());
}
}
