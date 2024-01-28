package com.test.bitwise;

public class MultiplyUsingBits {

    public static long multiply(long x, long y){
        long sum = 0;
        while (x!=0){
            if((x & 1) != 0){
                sum = add(sum, y);
            }
            System.out.println("x is " +x + " and Binary is " + Long.toBinaryString(x).replace(' ','0') +
                    " and y is " +y + " and Binary is " + Long.toBinaryString(y).replace(' ','0'));
            x >>>= 1;
            y <<= 1;
            System.out.println("After Shifting x is " +x + " and Binary is " + Long.toBinaryString(x).replace(' ','0') +
                    " and y is " +y + " and Binary is " + Long.toBinaryString(y).replace(' ','0'));
        }
        return sum;

    }

    private static long add(long x, long y) {

        while (y != 0){
            long carry = x & y;
            x = x ^ y;
            y = carry << 1;
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println("Multiply 2 and 3 should be 6 and result is " + multiply(2,3));
        System.out.println("Multiply 3 and 3 should be 9 and result is " + multiply(3,3));
    }
}
