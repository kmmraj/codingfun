package com.test.bitwise;

public class BitWiseTest {
    public static void main(String[] args) {
        int x = -12; // Binary representation: 11111111111111111111111111111000
        System.out.println(" Binary representation of -12: " +
                String.format("%32s", Integer.toBinaryString(x)).replace(' ', '0'));
        int y = x >>> 2; // Shift x to the right by 2 bits
        System.out.println(" Binary representation of -12: " +
                String.format("%32s", Integer.toBinaryString(y)).replace(' ', '0'));
        System.out.println(y); // Output: 11111111111111111111111111111110 (-2)
        printNegativeBinary(64);

        //

        System.out.println("Bitwise 6&4 is " + (6 & 4));
        System.out.println("Bitwise 6|4 is " + (6 | 4));
        System.out.println("Bitwise 6^4 is " + (6 ^ 4));
        System.out.println("Bitwise 4^4 is " + (4 ^ 4));
        System.out.println("Bitwise 3^1 is " + (3 ^ 1));
        System.out.println("Bitwise 8>>1 is " + (8 >> 1));
        System.out.println("Bitwise 8<<1 is " + (8 << 1));
        System.out.println("Bitwise 3>>>2 is " + (3 >>> 2));
        System.out.println("Bitwise 3>>>1 is " + (3 >>> 1));

        System.out.println("Bitwise -16>>>2 is " + (-16 >>> 2));
        System.out.println("Bitwise 1<<10 is " + (1 << 10));
        System.out.println("Bitwise 1<<12 is " + (1 << 12));
        System.out.println("Bitwise ~0 is " + (~0));

        printLowestBit(44);

        System.out.println("Float MAX_VALUE is " + Float.MAX_VALUE);
        System.out.println("Double SiZE is " + Double.SIZE);
        System.out.println("Boolean TRUE is " + Boolean.TRUE);

        printSwap(7,5,2);

    }

        private static void printSwap(int num, int idx, int jdx) {

             int low = num >>> idx & 1; // Swift to the right by idx and mask with 1
             int high = num >>> jdx & 1; // Swift to the right by jdx and mask with 1
             int result = 0;
             if(low != high){ // if low and high are different then swap
                int mask = (int) ((1L << idx) | (1L << jdx)); // create a mask with 1 at idx and jdx
                 result ^= mask; // XOR with mask - this will swap the bits
             }

            System.out.println("________ Print Swap Start________");
            System.out.println("Binary representation of " + num + " is " +
                    String.format("%32s", Integer.toBinaryString(num)).replace(' ', '0')+ " idx " + idx + " jdx " + jdx);
            System.out.println("Binary representation of (num >> idx) = " + (num >> idx) + " is " +   // 7 >> 2 = 1
                    String.format("%32s", Integer.toBinaryString(num >> idx)).replace(' ', '0'));
            System.out.println("Binary representation of (num >> jdx) = " + (num >> jdx) + " is " +   // 7 >> 5 = 0
                    String.format("%32s", Integer.toBinaryString(num >> jdx)).replace(' ', '0'));
            System.out.println("Binary representation of (num >> idx) & 1 = " + ((num >> idx) & 1) + " is " +   // 1 & 1 = 1
                    String.format("%32s", Integer.toBinaryString((num >> idx) & 1)).replace(' ', '0'));
            System.out.println("Binary representation of (num >> jdx) & 1 = " + ((num >> jdx) & 1) + " is " +   // 0 & 1 = 0
                    String.format("%32s", Integer.toBinaryString((num >> jdx) & 1)).replace(' ', '0'));
            System.out.println("Binary representation of (num >> idx) & 1 ^ (num >> jdx) & 1 = " + (((num >> idx) & 1) ^ ((num >> jdx) & 1)) + " is " +   // 1 ^ 0 = 1
                    String.format("%32s", Integer.toBinaryString(((num >> idx) & 1) ^ ((num >> jdx) & 1))).replace(' ', '0'));

            System.out.println("Binary representation of (1L << idx)  = " + (1L << idx) + " is " +   // 1 << 2 = 4
                    String.format("%32s", Long.toBinaryString(1L << idx)).replace(' ', '0'));
            System.out.println("Binary representation of (1L << jdx)  = " + (1L << jdx) + " is " +   // 1 << 5 = 32
                    String.format("%32s", Long.toBinaryString(1L << jdx)).replace(' ', '0'));

            System.out.println("Binary representation of Mask is (1L << idx) | (1L << jdx)  = " + ((1L << idx) | (1L << jdx)) + " is " +   // 4 | 32 = 36
                    String.format("%32s", Long.toBinaryString((1L << idx) | (1L << jdx))).replace(' ', '0'));

            System.out.println("Binary representation of num ^ Mask is " + (num ^ ((1L << idx) | (1L << jdx))) + " is " +   // 7 ^ 36 = 39
                    String.format("%32s", Integer.toBinaryString((int) (num ^ ((1L << idx) | (1L << jdx))))).replace(' ', '0'));

            System.out.println("_________Print Swap End________");


        }

    private static void printLowestBit(int num) {
        System.out.println("Binary representation of " + num + " is " +
                String.format("%32s", Integer.toBinaryString(num)).replace(' ', '0'));
        System.out.println("Binary representation of (num-1) " + (num - 1) + " is " +
                String.format("%32s", Integer.toBinaryString(num - 1)).replace(' ', '0'));
        System.out.println("Binary representation of ~(num-1) " + (~(num - 1)) + " is " +
                String.format("%32s", Integer.toBinaryString((~(num - 1)))).replace(' ', '0'));

        System.out.println("*** Extract Right or Lowest Bit => Binary representation of (num & ~(num-1)) " + (num & ~(num - 1)) + " is " +
                String.format("%32s", Integer.toBinaryString(num & ~(num - 1))).replace(' ', '0'));

        System.out.println("*** Set Right or Lowest Bit to Zero => Binary representation of (num & (num-1)) " + (num & (num - 1)) + " is " +
                String.format("%32s", Integer.toBinaryString(num & (num - 1))).replace(' ', '0'));
        System.out.println("Binary representation of (num & -num) " + (num & -num) + " is " +
                String.format("%32s", Integer.toBinaryString(num & -num)).replace(' ', '0'));
    }

    static void printNegativeBinary(int num) {
        //In Java, negative numbers are typically represented using the Two's Complement notation.
        // The Two's Complement representation is a method for representing
        // both positive and negative integers in a binary system.
        //
        //Here's a brief explanation of how negative numbers are represented in binary using Two's Complement,
        // along with an example:
        //
        //Two's Complement Representation:
        //Positive Numbers:
        //
        //Positive integers are represented in a straightforward binary form.
        // The binary representation is the same as the positive integer's binary representation.
        //Negative Numbers:
        //
        //To represent negative numbers, Two's Complement is used.
        //To find the Two's Complement of a binary number:
        //Invert all the bits (change 0s to 1s and vice versa).
        //Add 1 to the result.
        for (int index = 0; index < num; index++) {
            int temp = index * -1;
            System.out.println(" Binary representation of : " + index + " is " +
                    String.format("%32s", Integer.toBinaryString(index)).replace(' ', '0'));
            System.out.println(" Binary representation of : " + temp + " is " +
                    String.format("%32s", Integer.toBinaryString(temp)).replace(' ', '0'));

        }

    }
}
