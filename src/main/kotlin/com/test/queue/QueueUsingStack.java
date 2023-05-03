package com.test.queue;

import java.util.Stack;

public class QueueUsingStack {


    Stack<Integer> popStack = new Stack();
    Stack<Integer> pushStack = new Stack();

    public void enQueue(Integer input){
        pushStack.push(input);

    }

    public Integer deQueue(){
        if(!popStack.isEmpty()){
            return popStack.pop();
        } else  {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
            return popStack.pop();
        }


    }


    public static void main(String[] args) {

        QueueUsingStack qus = new QueueUsingStack();
        qus.enQueue(1);
        qus.enQueue(2);
        qus.enQueue(3);
        Integer output;
        output = qus.deQueue();
        System.out.println(output);
        qus.enQueue(4);
        qus.enQueue(5);
        output = qus.deQueue();
        System.out.println(output);

        output = qus.deQueue();
        System.out.println(output);

        output = qus.deQueue();
        System.out.println(output);

        qus.enQueue(6);
        output = qus.deQueue();
        System.out.println(output);

        output = qus.deQueue();
        System.out.println(output);



    }
}
