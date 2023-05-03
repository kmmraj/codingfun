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
}
