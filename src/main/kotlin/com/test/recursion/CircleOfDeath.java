package com.test.recursion;

import java.util.ArrayList;

public class CircleOfDeath {


    private int solve(int arraySize, int executionKey) {
        ArrayList <Integer> intArray = new ArrayList<Integer>();
        for (int indx = 1; indx <= arraySize; indx++) {
            intArray.add(indx);
        }
        return solveIt(intArray,executionKey,1);
    }

    private int solveIt(ArrayList<Integer> intArray, int executionKey, int nextIndex) {

        // BC
        if(intArray.size() == 1){
            return intArray.get(0);
        }

        // Hypo & Induction
        nextIndex = (nextIndex + executionKey - 1) % intArray.size();
        intArray.remove(nextIndex);
        return solveIt(intArray,executionKey,nextIndex);
    }

    public static void main(String[] args) {
        CircleOfDeath circleOfDeath = new CircleOfDeath();
        int escapeNumber = circleOfDeath.solve(50,10);
        System.out.println("Escape Number : "+ escapeNumber);
    }

}
