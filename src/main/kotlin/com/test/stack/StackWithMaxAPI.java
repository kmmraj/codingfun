package com.test.stack;

import java.util.Stack;

public class StackWithMaxAPI  {

    Stack <Integer> integerStack = new Stack<Integer>();
    Stack <CachePower> maxCacheStack = new Stack<CachePower>();

    public Integer pop(){
        CachePower cp = maxCacheStack.peek();
        if(cp.number == integerStack.peek()) {

            if(cp.power ==1){
                maxCacheStack.pop();
            }

            if(cp.power >1){
                CachePower cp1 = maxCacheStack.pop();
                cp1.power = cp1.power-1;
                maxCacheStack.push(cp1);
            }
        }
        return integerStack.pop();
    }

    public void push(Integer item){


        if(!maxCacheStack.isEmpty() && item == integerStack.peek()){
            CachePower cp = maxCacheStack.pop();
            cp.power = cp.power+1;
            maxCacheStack.push(cp);
        } else  if(integerStack.isEmpty() || ( !integerStack.isEmpty() && item > integerStack.peek())) {
            CachePower cp = new CachePower(item,1);
            maxCacheStack.push(cp);
        }
        integerStack.push(item);
    }

    public static void main(String[] args) {

        StackWithMaxAPI stackWithMaxAPI = new StackWithMaxAPI();
        stackWithMaxAPI.push(1);
        stackWithMaxAPI.push(2);
        stackWithMaxAPI.push(4);
        stackWithMaxAPI.push(4);
        stackWithMaxAPI.push(5);
        stackWithMaxAPI.push(5);
        stackWithMaxAPI.push(3);
        stackWithMaxAPI.pop();
        stackWithMaxAPI.pop();
        stackWithMaxAPI.pop();
        stackWithMaxAPI.pop();
        stackWithMaxAPI.pop();
        stackWithMaxAPI.pop();
        stackWithMaxAPI.pop();
    }
}


class CachePower {
    Integer number;
    Integer power;
    CachePower(Integer number, Integer power) {
        this.number = number;
        this.power = power;
    }
}
