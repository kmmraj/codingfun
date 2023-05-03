package com.test.queue;

class MyCircularDeque {

    private int start = -1, end = -1, size;

    private Integer[] intArray;



    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        intArray = new Integer[k];
        this.size = intArray.length;
    }


    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        } else if(isEmpty()) {
            start = end  = 0;
            intArray[end] = value;
        } else {
            start = ((start - 1)  % size);
            if(start == -1) {
                start = size -1;
            }
            intArray[start] = value;
        }

        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        } else if(isEmpty()) {
            start = end  = 0;
            intArray[end] = value;
        } else {
            end = ((end + 1)  % size);
            intArray[end] = value;
        }
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        int value;
        if(isEmpty()){
            return false;
        } else if(start == end) {
            System.out.println("Start is equal to end");
            value =  intArray[start];
            System.out.println("DeleteFront Value  is " + value);
            start = end = -1;
        } else  {
            value =  intArray[start];
            System.out.println("DeleteFront Value  is " + value);
            start =  (start + 1) % size;
        }
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        int value;
        if(isEmpty()){
            return false;
        }else
            if(start == end) {
            System.out.println("Start is equal to end");
            value =  intArray[end];
            System.out.println("DeleteLast Value  is " + value);
            start = end = -1;
        } else  {
            value =  intArray[end];
            System.out.println("DeleteLast Value  is " + value);
            end =  (end - 1) % size;
            if (end == -1) {
                end  = size -1;
            }
        }
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(isEmpty())
            return -1;
        else
            return intArray[start];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(isEmpty())
            return -1;
        else
            return intArray[end];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        if(start == -1 && end == -1)
            return true;
        else
            return false;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        if(((end+1)%size) == start)
           return true;
        else
            return false;
    }

    void display(){
        System.out.println("Display");
        System.out.println("");
        if(!isEmpty()){
        int indx = start-1;
            do {
                indx = (indx+1) % size;
                System.out.println(intArray[indx]);
            } while(indx != end);
        }
    }

    public static void main(String[] args) {

        MyCircularDeque myd = new MyCircularDeque(5);
        myd.insertLast(1);
        myd.insertLast(2);
        myd.insertLast(3);
        myd.insertLast(4);
        myd.insertFront(5);
        myd.insertFront(6); // Full Condition
        System.out.println("Front Value is " +myd.getFront()); // Full Condition
        System.out.println("Last Value is " +myd.getRear()); // Full Condition
        myd.display();
        myd.deleteFront();
        myd.deleteFront();
        myd.deleteLast();
        myd.deleteLast();
        myd.deleteLast();
        myd.deleteLast();

    }
}
