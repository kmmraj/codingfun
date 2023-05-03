package com.test.misc;

public class NthFibonacci {

    public static int getNthFib(int n) {
        if(n==2)
            return 1;
        if(n==1)
            return 0;
        return getNthFib(n-1)+getNthFib(n-2);
    }



    public static void main(String[] args) {
        System.out.println( NthFibonacci.getNthFib(6));
    }
}
