package com.test.strings;
// https://leetcode.com/problems/base-7/submissions/

/**
 * 504. Base 7
 * Easy
 * Given an integer num, return a string of its base 7 representation.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 100
 * Output: "202"
 * Example 2:
 *
 * Input: num = -7
 * Output: "-10"
 *
 *
 * Constraints:
 *
 * -107 <= num <= 107
 */
public class ConvertBase {
    public String convertToBase7(int num) {
        if(num==0) return "0";
        boolean isNegative = num < 0;
        StringBuilder sb = new StringBuilder();
        //int index=0;
        num = Math.abs(num);
        while(num !=0){
            // int remainder = (num % 7);//+ (int)Math.pow(10,index++);
            // System.out.println("remainder is "+remainder);
            sb.append(num % 7);
            num = num/7;
        }
        if(isNegative){
            sb.append("-");
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        ConvertBase convertBase = new ConvertBase();
        System.out.println("convertBase.convertToBase7(100) = " + convertBase.convertToBase7(100));
        System.out.println("convertBase.convertToBase7(-7) = " + convertBase.convertToBase7(-7));
        System.out.println("convertBase.convertToBase7(0) = " + convertBase.convertToBase7(0));
        System.out.println("convertBase.convertToBase7(7) = " + convertBase.convertToBase7(7));
        System.out.println("convertBase.convertToBase7(-7) = " + convertBase.convertToBase7(-7));
        System.out.println("convertBase.convertToBase7(8) = " + convertBase.convertToBase7(8));
        System.out.println("convertBase.convertToBase7(-8) = " + convertBase.convertToBase7(-8));
        System.out.println("convertBase.convertToBase7(9) = " + convertBase.convertToBase7(9));
        System.out.println("convertBase.convertToBase7(-9) = " + convertBase.convertToBase7(-9));
        System.out.println("convertBase.convertToBase7(10) = " + convertBase.convertToBase7(10));
        System.out.println("convertBase.convertToBase7(-10) = " + convertBase.convertToBase7(-10));
        System.out.println("convertBase.convertToBase7(11) = " + convertBase.convertToBase7(11));
        System.out.println("convertBase.convertToBase7(-11) = " + convertBase.convertToBase7(-11));
        System.out.println("convertBase.convertToBase7(12) = " + convertBase.convertToBase7(12));
        System.out.println("convertBase.convertToBase7(-12) = " + convertBase.convertToBase7(-12));
        System.out.println("convertBase.convertToBase7(13) = " + convertBase.convertToBase7(13));
        System.out.println("convertBase.convertToBase7(-13) = " + convertBase.convertToBase7(-13));
        System.out.println("convertBase.convertToBase7(14) = " + convertBase.convertToBase7(14));

    }
}
