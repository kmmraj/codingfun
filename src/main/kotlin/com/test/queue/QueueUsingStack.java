package com.test.queue;
//https://leetcode.com/problems/implement-queue-using-stacks/description/
/**
 * 232. Implement Queue using Stacks
 * Easy
 * Implement a first in first out (FIFO) queue using only two stacks.
 * The implemented queue should support all the functions of a
 * normal queue (push, peek, pop, and empty).
 *
 * Implement the MyQueue class:
 *
 * void push(int x) Pushes element x to the back of the queue.
 * int pop() Removes the element from the front of the queue and returns it.
 * int peek() Returns the element at the front of the queue.
 * boolean empty() Returns true if the queue is empty, false otherwise.
 * Notes:
 *
 * You must use only standard operations of a stack, which means only push to top,
 * peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, the stack may not be supported natively.
 * You may simulate a stack using a list or deque (double-ended queue) as long
 * as you use only a stack's standard operations.
 *
 *
 * Example 1:
 *
 * Input
 * ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * Output
 * [null, null, null, 1, 1, false]
 *
 * Explanation
 * MyQueue myQueue = new MyQueue();
 * myQueue.push(1); // queue is: [1]
 * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 * myQueue.peek(); // return 1
 * myQueue.pop(); // return 1, queue is [2]
 * myQueue.empty(); // return false
 *
 *
 * Constraints:
 *
 * 1 <= x <= 9
 * At most 100 calls will be made to push, pop, peek, and empty.
 * All the calls to pop and peek are valid.
 *
 *
 * Follow-up: Can you implement the queue such that each operation is amortized O(1)
 * time complexity? In other words, performing n operations will take overall O(n) time
 * even if one of those operations may take longer.
 */

import java.util.Deque;
import java.util.LinkedList;

public class QueueUsingStack {



        Deque<Integer> enq;
        Deque<Integer> deq;

        public QueueUsingStack() {
            enq = new LinkedList<>();
            deq = new LinkedList<>();
        }

        public void push(int x) {
            enq.addFirst(x);
        }

        public int pop() {
            if(deq.isEmpty()){
                while(!enq.isEmpty()){
                    deq.addFirst(enq.removeFirst());
                }
            }
            if(!deq.isEmpty()){
                return deq.removeFirst();  // Only diff is removeFirst (#1)
            }
            return -1;
        }

        public int peek() {
            if(deq.isEmpty()){
                while(!enq.isEmpty()){
                    deq.addFirst(enq.removeFirst());
                }
            }
            if(!deq.isEmpty()){
                return deq.getFirst(); // Only diff is getFirst (#1)
            }
            return -1;
        }

        public boolean empty() {
            return deq.isEmpty() && enq.isEmpty();
        }


    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */


    public static void main(String[] args) {

        QueueUsingStack qus = new QueueUsingStack();
        qus.push(1);
        qus.push(2);
        qus.push(3);

        System.out.println("pop should be 1 and the result is "+qus.pop());
        qus.push(4);
        qus.push(5);
        System.out.println("pop should be 2 and the result is "+qus.pop());


        System.out.println("pop should be 3 and the result is "+qus.pop());

        System.out.println("pop should be 4 and the result is "+qus.pop());

        qus.push(6);

        System.out.println("pop should be 5 and the result is "+qus.pop());


        System.out.println("pop should be 6 and the result is "+qus.pop());



    }
}
