package com.test.bitwise;

// https://leetcode.com/problems/reverse-bits
public class ReverseBits {
    //Reverse bits of a given 32 bits unsigned integer.
//
//Note:
//
//Note that in some languages, such as Java, there is no unsigned integer type.
// In this case, both input and output will be given as a signed integer type.
// They should not affect your implementation, as the integer's internal binary representation
// is the same, whether it is signed or unsigned.
//In Java, the compiler represents the signed integers using 2's complement notation.
// Therefore, in Example 2 above, the input represents the signed integer -3
// and the output represents the signed integer -1073741825.
//
//
//Example 1:
//
//Input: n = 00000010100101000001111010011100
//Output:    964176192 (00111001011110000010100101000000)
//Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596,
// so return 964176192 which its binary representation is 00111001011110000010100101000000.
//Example 2:
//
//Input: n = 11111111111111111111111111111101
//Output:   3221225471 (10111111111111111111111111111111)
//Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293,
// so return 3221225471 which its binary representation is 10111111111111111111111111111111.
//
//
//Constraints:
//
//The input must be a binary string of length 32
    public int reverseBits(int num) {
        System.out.println("Num is " + String.format("%32s", Integer.toBinaryString(num)).replace(' ', '0'));
        num = (((num & 0xffff0000) >>> 16) | ((num & 0x0000ffff) << 16)); // 1111 = f
        System.out.println("Num after 16 bit swap is " + String.format("%32s", Integer.toBinaryString(num)).replace(' ', '0'));
        num = (((num & 0xff00ff00) >>> 8) | ((num & 0x00ff00ff) << 8));
        System.out.println("Num after 8 bit swap is " + String.format("%32s", Integer.toBinaryString(num)).replace(' ', '0'));
        num = (((num & 0xf0f0f0f0) >>> 4) | ((num & 0x0f0f0f0f) << 4));
        System.out.println("Num after 4 bit swap is " + String.format("%32s", Integer.toBinaryString(num)).replace(' ', '0'));
        num = (((num & 0xcccccccc) >>> 2) | ((num & 0x33333333) << 2)); // 1100 == c , 0011 = 3
        System.out.println("Num after 2 bit swap is " + String.format("%32s", Integer.toBinaryString(num)).replace(' ', '0'));
        num = (((num & 0xaaaaaaaa) >>> 1) | ((num & 0x55555555) << 1)); // 1010 == a , 0101 = 5
        System.out.println("Num after 1 bit swap is " + String.format("%32s", Integer.toBinaryString(num)).replace(' ', '0'));
        return num;
    }

    public static void main(String[] args) {
        ReverseBits reverseNumber = new ReverseBits();
        System.out.println(reverseNumber.reverseBits(123));
        System.out.println(reverseNumber.reverseBits(-123));
        System.out.println(reverseNumber.reverseBits(120));
        System.out.println(reverseNumber.reverseBits(0));
    }
}
