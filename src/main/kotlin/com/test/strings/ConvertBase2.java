package com.test.strings;
//https://leetcode.com/problems/convert-to-base-2

/**
 * 1017. Convert to Base -2
 * Medium
 * Given a number N, return a string consisting of "0"s and "1"s that represents its value in base -2 (negative two).
 * Given an integer n, return a binary string representing its representation in base -2.
 *
 * Note that the returned string should not have leading zeros unless the string is "0".
 *
 * Example 1:
 * Input: n = 2
 * Output: "110"
 * Explantion: (-2)2 + (-2)1 = 2
 *
 * Example 2:
 * Input: n = 3
 * Output: "111"
 * Explantion: (-2)2 + (-2)1 + (-2)0 = 3
 *
 *
 * Example 3:
 * Input: n = 4
 * Output: "100"
 * Explantion: (-2)2 = 4

 * Constraints:
 *
 * 0 <= n <= 109
 *
 */
public class ConvertBase2 {
    public String baseNeg2(int n) {
        if(n==0) return "0";
        StringBuilder sb = new StringBuilder();
        while(n!=0){
            // sb.append(n%2);
            // n = n/2;
            // System.out.println("Value of n & 1 is "+(n&1));
            if((n & 1) == 1){
                sb.append(1);
            } else {
                sb.append(0);
            }
            n = -(n>>1);
            //System.out.println("Value of n is "+n);
        }
        //sb.append(1);
        return sb.reverse().toString();

    }

    public static void main(String[] args) {
        ConvertBase2 convertBase2 = new ConvertBase2();
        System.out.println("convertBase2.baseNeg2(2)  expected is 110 and actual is = " + convertBase2.baseNeg2(2));
        System.out.println("convertBase2.baseNeg2(3)  expected is 111 and actual is = " + convertBase2.baseNeg2(3));
        System.out.println("convertBase2.baseNeg2(4)  expected is 100 and actual is = " + convertBase2.baseNeg2(4));
        System.out.println("convertBase2.baseNeg2(5)  expected is 101 and actual is = " + convertBase2.baseNeg2(5));
        System.out.println("convertBase2.baseNeg2(6)  expected is 110 and actual is = " + convertBase2.baseNeg2(6));
        System.out.println("convertBase2.baseNeg2(7)  expected is 111 and actual is = " + convertBase2.baseNeg2(7));


    }


}
