package com.test.binarysearch;

// https://leetcode.com/problems/sqrtx

/**
 * 69. Sqrt(x)
 * Easy
 *
 */
public class SquareRootInteger {

    public static int squareRoot(int k) {
        long left = 0, right = k;
        // Candidate interval [left, right] where everything before left has
        // square <= k, and everything after right has square > k.
        while (left <= right) {
            long mid = left + ((right - left) / 2);
            long midSquared = mid * mid;
            if (midSquared <= k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) left - 1;
    }

    public static void main(String[] args) {
        SquareRootInteger squareRootInteger = new SquareRootInteger();
        System.out.println("squareRootInteger.squareRoot(16) should be 4 and result is "
                + squareRootInteger.squareRoot(16));
        System.out.println("squareRootInteger.squareRoot(300) should be 17 and result is "
                + squareRootInteger.squareRoot(300));
        System.out.println("squareRootInteger.squareRoot(100) should be 10 and result is "
                + squareRootInteger.squareRoot(100));
        System.out.println("squareRootInteger.squareRoot(1000) should be 31 and result is "
                + squareRootInteger.squareRoot(1000));
        System.out.println("squareRootInteger.squareRoot(2147395599) should be 46339 and result is "
                + squareRootInteger.squareRoot(2147395599));
    }

}
