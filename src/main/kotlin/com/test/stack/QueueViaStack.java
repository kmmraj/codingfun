package com.test.stack;

import java.util.Stack;

public class QueueViaStack {

    Stack<Integer> stackOne;
    Stack<Integer> stackTwo;

    public QueueViaStack() {
        stackOne = new Stack<>();
        stackTwo = new Stack<>();
    }


    public static void main(String[] args) {
        QueueViaStack queue = new QueueViaStack();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        //queue.printAll();
        System.out.println("Dequeued value is "+queue.deQueue());
        System.out.println("Dequeued value is "+queue.deQueue());
        System.out.println("Dequeued value is "+queue.deQueue());
        System.out.println("Dequeued value is "+queue.deQueue());
        System.out.println("Dequeued value is "+queue.deQueue());
    }

    private int deQueue() {
        if(stackOne.isEmpty()){
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        while (!stackOne.isEmpty() && stackOne.size() > 1){
            stackTwo.push(stackOne.pop());
        }
        int value = stackOne.pop();

        if(stackOne.isEmpty()){
           while (!stackTwo.isEmpty()){
               stackOne.push(stackTwo.pop());
           }
        }
        return value;
    }

    private void printAll() {
        System.out.println("---------------");
        while(!stackOne.isEmpty()){
            stackTwo.push(stackOne.pop());
        }
        while(!stackTwo.isEmpty()){
            System.out.print(stackTwo.peek()+" -> ");
            stackOne.push(stackTwo.pop());
        }
        System.out.println();
        System.out.println("---------------");
    }

    private void enQueue(int data) {
        stackOne.push(data);
    }

}
