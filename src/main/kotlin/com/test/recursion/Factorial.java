package com.test.recursion;

public class Factorial {

    public static int factorial(int num) {
       // Exp
        if(num < 0){
            return -1;
        }

        // BC
        if(num == 0){
            return 1;
        }

        // Hypo
        return num * factorial(num-1);
    }

    public static void main(String[] args) {
       System.out.println("Factorial of 4 is " +Factorial.factorial(4));
    }
}
