package com.test.stack;

import java.util.HashMap;
import java.util.Map;

public class ThreeInOneStack {
    int[] array;
    int capacity;

    int noOfStacks = 3;

    Map<Integer, Integer[]> sizeMap; // stackNumber -> {startIndex,EndIndex}
    Map<Integer, Integer[]> coordinatesMap; // stackNumber -> {first,last}

    public ThreeInOneStack(int capacity) {
        this.capacity = capacity;
        array = new int[capacity];
        sizeMap = new HashMap<>();
        coordinatesMap = new HashMap<>();
        int stackSize = capacity / 3;
        for (int indx = 0; indx < stackSize; indx++) {
            // 9/3
            int startIndex = indx * stackSize;
            int endIndex = startIndex + stackSize - 1;
            sizeMap.put(indx, new Integer[]{startIndex, endIndex});
            coordinatesMap.put(indx, new Integer[]{startIndex, startIndex}); // stackNumber -> {last,last}
        }
    }

    // isFull
    public boolean isFull(int stackNum) {
        Integer[] sizesArray = sizeMap.get(stackNum);
        Integer[] coordinatesArray = coordinatesMap.get(stackNum);

        int lastIndex = coordinatesArray[1]; // top
        // top == endArrayIndex
        if (lastIndex-1 == sizesArray[1]) {
            System.out.println("Stack is full for the stackNum: " + stackNum );
            return true;
        }
        return false;
    }
//
//    // isEmpty
    public boolean isEmpty(int stackNum) {
        Integer[] sizesArray = sizeMap.get(stackNum);
        Integer[] coordinatesArray = coordinatesMap.get(stackNum);

        int lastIndex = coordinatesArray[1];
        if (lastIndex == sizesArray[0]) {
            System.out.println("Stack is empty for the stackNum: " + stackNum );
            return true;
        }
        return false;
    }
//
//    // indexOfTop - this is helper method for push, pop and peek methods
//
//    private int indexOfTop(int stackNum) {
//        // TODO
//    }

    // push
    public void push(int stackNum, int value) {
        // TODO
        Integer[] sizesArray = sizeMap.get(stackNum);
        Integer[] coordinatesArray = coordinatesMap.get(stackNum);

        int lastIndex = coordinatesArray[1];
        if (lastIndex <= sizesArray[1]) {
            array[lastIndex] = value;
            lastIndex++;
            coordinatesArray[1] = lastIndex;
            coordinatesMap.put(stackNum,coordinatesArray);
        } else {
            System.out.println("Stack is full for the stackNum: " + stackNum + " with value to push "+value);
        }

    }

    // pop
    public int pop(int stackNum) {
        // TODO
        Integer[] sizesArray = sizeMap.get(stackNum);
        Integer[] coordinatesArray = coordinatesMap.get(stackNum);

        int lastIndex = coordinatesArray[1];
        if (lastIndex == sizesArray[0]) {
            System.out.println("Stack is empty for the stackNum: " + stackNum );
            return Integer.MIN_VALUE;
        }
        int value = array[lastIndex-1];
        lastIndex--;
        coordinatesArray[1] = lastIndex;
        coordinatesMap.put(stackNum,coordinatesArray);
        return value;
    }
//
//    // peek
//
    public int peek(int stackNum) {
        Integer[] sizesArray = sizeMap.get(stackNum);
        Integer[] coordinatesArray = coordinatesMap.get(stackNum);

        int lastIndex = coordinatesArray[1];
        if (lastIndex == sizesArray[0]) {
            System.out.println("Stack is empty for the stackNum: " + stackNum );
            return Integer.MIN_VALUE;
        }
        return array[lastIndex-1];
    }


    public static void main(String[] args) {
        ThreeInOneStack stack = new ThreeInOneStack(9);
        System.out.println("Is stack empty for 0 ? "+stack.isEmpty(0));
        stack.push(0, 1);
        System.out.println("Is stack empty for 0 ? "+stack.isEmpty(0));
        stack.push(0, 2);
        System.out.println("Is stack full for 0 ? "+stack.isFull(0));
        stack.push(0, 3);
        stack.push(0, 4);
        System.out.println("Is stack full for 0 ? "+stack.isFull(0));
        stack.push(1, 4);
        stack.push(1, 5);
        stack.push(1, 6);
        stack.push(1, 7);
        stack.push(2, 7);
        stack.push(2, 8);
        stack.push(2, 9);
        stack.push(2, 9);
        System.out.println("Popped stack 2 is "+stack.pop(2));
        System.out.println("Popped stack 1 is "+stack.pop(1));
        System.out.println("Popped stack 0 is "+stack.pop(0));
        System.out.println("Popped stack 0 is "+stack.pop(0));
        System.out.println("Popped stack 0 is "+stack.pop(0));
        System.out.println("Popped stack 0 is "+stack.pop(0));
    }
}
