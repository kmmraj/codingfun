package com.test.recursion;

public class SumOfDigits {

    public static void main(String[] args) {
        int result = SumOfDigits.sumOfDigits(111);
        System.out.println(result);
        System.out.println(SumOfDigits.sumOfDigits(999));
        System.out.println(SumOfDigits.sumOfDigits(-999));
        System.out.println(SumOfDigits.sumOfDigits(12345));

    }

    private static int sumOfDigits(int number) {
        // Exceptions
        if (number < 0) {
            return 0;
        }

        // BC
        if (number < 10) {
            return number;
        }

        // Hypo
        return sumOfDigits(number / 10) + sumOfDigits(number % 10);
    }


    int solution(int n) {
        int counter = 0;
        // if(n<10){
        //     return 0;
        // }
        // if(n%10 ==0){
        //     return 1;
        // }
        //
        while( n >= 10){
            counter++;
            int sum = 0;
            while (n > 0){
                sum = sum + n % 10;
                n = n / 10;
            }
            n = sum;
            System.out.println("N value is "+ n +" and counter is " + counter);
        }
        return counter;
    }
}
