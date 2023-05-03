package com.test.stack;

import java.util.Deque;

public class StackUsingArray {

    int[] array;
    int topOfStack = -1;

    public StackUsingArray(int size) {
        array = new int[size];
        topOfStack = -1;
        System.out.println("The Stack is created with size of: " + size);
    }

    public boolean isEmpty(){
        return topOfStack == -1;
    }

    public boolean isFull(){
        return topOfStack == array.length -1;
    }

    public void push(int value) {
        if(isFull()){
            System.out.println("The Stack is full");
            return;
        }
        array[topOfStack+1] = value;
        topOfStack++;
        System.out.println("The Stack is pushed with "+ value);
    }

    public int pop() {
        if(isEmpty()){
            System.out.println("The Stack is empty");
            return Integer.MIN_VALUE;
        }
        int value = array[topOfStack];
        topOfStack--;
        System.out.println("The Stack is popped with "+ value);
        return value;
    }

    public int peek() {
        if(isEmpty()){
            System.out.println("The Stack is empty");
            return Integer.MIN_VALUE;
        }
        int value = array[topOfStack];
        System.out.println("The Stack is peeked with "+ value);
        return value;
    }


    public static void main(String[] args) {
        StackUsingArray stack = new StackUsingArray(6);
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.peek();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
    }


}
