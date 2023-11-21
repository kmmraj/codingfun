package com.test.misc;
//Consider integer numbers from 0 to n - 1 written down along the circle in such a way that the distance between any two neighboring numbers is equal (note that 0 and n - 1 are neighboring, too).
//
//Given n and firstNumber, find the number which is written in the radially opposite position to firstNumber.
//
//Example
//
//For n = 10 and firstNumber = 2, the output should be
//solution(n, firstNumber) = 7.
//
//
//
//Input/Output
//
//[execution time limit] 3 seconds (java)
//
//[memory limit] 1 GB
//
//[input] integer n
//
//A positive even integer.
//
//Guaranteed constraints:
//4 ≤ n ≤ 20.
//
//[input] integer firstNumber
//
//Guaranteed constraints:
//0 ≤ firstNumber ≤ n - 1.
//
//[output] integer
public class CircleOfNumbers {
    int solution(int n, int firstNumber) {
        int halfDistance = n/2;
        //n: 10 firstNumber: 7 => 2
        //n: 10 firstNumber: 2 => 7
        return (firstNumber+halfDistance) % n;
    }

    public static void main(String[] args) {
        CircleOfNumbers circleOfNumbers = new CircleOfNumbers();
        System.out.println("Should be 7 and result is " + circleOfNumbers.solution(10, 2));
        System.out.println("Should be 2 and result is " +circleOfNumbers.solution(10, 7));
        System.out.println("Should be 3 and result is " +circleOfNumbers.solution(4, 1));
        System.out.println("Should be 0 and result is " +circleOfNumbers.solution(6, 3));
        System.out.println("Should be 15 and result is " +circleOfNumbers.solution(18, 6));
        System.out.println("Should be 4 and result is " +circleOfNumbers.solution(12, 10));
        System.out.println("Should be 14 and result is " +circleOfNumbers.solution(18, 5));
    }
}
