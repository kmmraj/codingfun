package com.test.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {

    Queue<Integer> queueOne;
    Queue<Integer> queueTwo;

    public StackUsingQueues() {
        queueOne = new LinkedList<Integer>();
        queueTwo = new LinkedList<Integer>();
    }




    public void push(int item){
        queueOne.add(item);
    }

    public int pop() {
        return pop(false);
    }
    private int pop(Boolean isPeekMode) {
        Integer lastValue = null;
        while (!queueOne.isEmpty() && queueOne.size() > 1){
            queueTwo.add(queueOne.remove());
        }
        if(queueOne.size() == 1){
            if(isPeekMode){
                lastValue = queueOne.peek();
            } else {
                lastValue = queueOne.remove();
            }
        }


        if(queueOne.isEmpty()){
            Queue<Integer> tempQueue = queueTwo;
            queueTwo = queueOne;
            queueOne = tempQueue;
        }
        return lastValue;
    }

    public int peek() {
        return pop(true);
    }

    public int size() {
        return queueOne.size() ;
    }

    public boolean empty() {
        return queueOne.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues suq = new StackUsingQueues();
        suq.push(1);
        suq.push(2);
        suq.push(3);
        System.out.println(suq.pop());
        System.out.println(suq.pop());
        System.out.println("size is " + suq.size());
        System.out.println(suq.pop());
        System.out.println("size is " + suq.size());
        suq.push(4);
        System.out.println("IsEmpty is " + suq.empty());
        suq.push(5);
        System.out.println("size is " + suq.size());
        System.out.println("Peek is " + suq.peek());
        System.out.println(suq.pop());
        System.out.println(suq.pop());
        System.out.println("IsEmpty is " + suq.empty());

    }
}
