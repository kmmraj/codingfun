package com.test.stack;

import java.util.Deque;
import java.util.LinkedList;

public class StackUsingQueues {

    Deque<Integer> enq;
    Deque<Integer> deq;

    public StackUsingQueues() {
        enq = new LinkedList<>();
        deq = new LinkedList<>();
    }

    public void push(int item){
        enq.add(item);
    }

    public int pop() {
        return pop(false);
    }
    private int pop(Boolean isPeekMode) {
        Integer lastValue = null;
        while (!enq.isEmpty() && enq.size() > 1){
            deq.add(enq.remove());
        }
        if(enq.size() == 1){
            if(isPeekMode){
                lastValue = enq.peek();
            } else {
                lastValue = enq.remove();
            }
        }


        if(enq.isEmpty()){
            Deque<Integer> tempQueue = deq;
            deq = enq;
            enq = tempQueue;
        }
        return lastValue;
    }

    public int peek() {
        return pop(true);
    }

    public int size() {
        return enq.size() ;
    }

    public boolean empty() {
        return enq.isEmpty();
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
