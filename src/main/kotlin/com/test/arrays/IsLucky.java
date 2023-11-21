package com.test.arrays;
//Ticket numbers usually consist of an even number of digits.
// A ticket number is considered lucky if the sum of the first half of the digits is equal to the sum of the second half.
//
//Given a ticket number n, determine if it's lucky or not.
//
//Example
//
//For n = 1230, the output should be
//solution(n) = true;
//For n = 239017, the output should be
//solution(n) = false.
//Input/Output
//
//[execution time limit] 3 seconds (java)
//
//[memory limit] 1 GB
//
//[input] integer n
//
//A ticket number represented as a positive integer with an even number of digits.
//
//Guaranteed constraints:
//10 ≤ n < 106.
//
//[output] boolean
//
//true if n is a lucky ticket number, false otherwise.
public class IsLucky {

    boolean solution(int n) {
        int tempNumber = n;
        String numberInStr = Integer.toString(tempNumber);
        int left  = 0;
        int right = numberInStr.length()-1;
        int leftCount = 0;
        int rightCount = 0;
        while(left < right){
            leftCount = leftCount + numberInStr.charAt(left)+'0';
            rightCount = rightCount + numberInStr.charAt(right)+'0';
            left++;
            right--;
        }

        return leftCount == rightCount;

    }

    public static void main(String[] args) {
        IsLucky isLucky = new IsLucky();
        System.out.println(isLucky.solution(1230));
        System.out.println(isLucky.solution(239017));
    }
}
