package com.test;

public class PrintRecursion {

    static void print(int size){
        // Base condition
        if(size ==1) {
            System.out.println(size);
            return;
        }

        // Hypothesis
        print(size-1);
        // Induction
        System.out.println(size);

    }

    public static void main(String[] args) {
        print(6);
    }
}
