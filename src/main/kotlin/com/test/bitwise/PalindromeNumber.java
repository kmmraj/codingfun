package com.test.bitwise;

public class PalindromeNumber {
    public static boolean isPalindromeNumber(int x) {
        // Option#1
//        if (x < 0) {
//            return false;
//        }
//        final int numDigits = (int) (Math.floor(Math.log10(x))) + 1; // Equivalent to log10(x) + 1
//        System.out.println("numDigits " + numDigits);
//        int msdMask = (int) Math.pow(10, numDigits - 1); // Equivalent to 10 ^ (numDigits - 1)
////        int msdMask = 10 << (numDigits - 1);
//        System.out.println("msdMask " + msdMask);
//        int start = 0, end = numDigits - 1;
//        while (start < end) {
//            if ((x / msdMask) != (x % 10)) {
//                return false;
//            }
//            x = x % msdMask; // Remove the most significant digit of x
//            x = x / 10; // Remove the least significant digit of x
//            msdMask = msdMask / 100; // Remove 2 zeros from msdMask
//            start++;
//            end--;
//        }
//        return true;

        // Option#2 - Reverse the number and compare with original
        if (x < 0) {
            return false;
        }
        int result = 0;
        int original = x;
        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        System.out.println("result " + result + " and original " + original);
        return result == original;
    }


    public static void main(String[] args) {
        System.out.println("Is 121 a palindrome number? " + isPalindromeNumber(121));
        System.out.println("Is -121 a palindrome number? " + isPalindromeNumber(-121));
        System.out.println("Is 10 a palindrome number? " + isPalindromeNumber(10));
        System.out.println("Is -101 a palindrome number? " + isPalindromeNumber(-101));
    }
}
