package com.test.binarysearch;
//https://leetcode.com/problems/valid-perfect-square/

/**
 * 367. Valid Perfect Square
 * Easy
 * Given a positive integer num, return true if num is a perfect square or false otherwise.
 *
 * A perfect square is an integer that is the square of an integer.
 * In other words, it is the product of some integer with itself.
 *
 * You must not use any built-in library function, such as sqrt.
 *
 *
 *
 * Example 1:
 * Input: num = 16
 * Output: true
 * Explanation: We return true because 4 * 4 = 16 and 4 is an integer.
 *
 *
 * Example 2:
 * Input: num = 14
 * Output: false
 * Explanation: We return false because 3.742 * 3.742 = 14 and 3.742 is not an integer.
 *
 *
 * Constraints:
 *
 * 1 <= num <= 231 - 1
 */
public class IsPerfectSquare {
    public boolean isPerfectSquare(int num) {
        long left = 1, right = num;
        while (left <= right) {
            long mid = left + ((right - left) / 2);
            long squareVal = mid * mid;
            if (squareVal == num) {
                return true;
            } else if (squareVal < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IsPerfectSquare isPerfectSquare = new IsPerfectSquare();
        System.out.println("isPerfectSquare.isPerfectSquare(16) should be true and result is "
                + isPerfectSquare.isPerfectSquare(16));
        System.out.println("isPerfectSquare.isPerfectSquare(300) should be false and result is "
                + isPerfectSquare.isPerfectSquare(300));
        System.out.println("isPerfectSquare.isPerfectSquare(100) should be true and result is "
                + isPerfectSquare.isPerfectSquare(100));
        System.out.println("isPerfectSquare.isPerfectSquare(1000) should be false and result is "
                + isPerfectSquare.isPerfectSquare(1000));
        System.out.println("isPerfectSquare.isPerfectSquare(2147395599) should be false and result is "
                + isPerfectSquare.isPerfectSquare(2147395599));
    }
}
