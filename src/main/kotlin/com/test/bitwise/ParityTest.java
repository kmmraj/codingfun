package com.test.bitwise;

public class ParityTest {
    public static short parity(long x) {
        // Option #1
//        short result = 0; // Example 3 - 11
//        while (x != 0) {  // 11 != 0 , 1 != 0
//            result ^= (x & 1); // 11 & 1 = 1 => 0 ^ 1 = 1 , 1 & 1 = 1 => 1 ^ 1 = 0
//            x >>>= 1; // 11 >>> 1 = 1, 1 >>> 1 = 0
//        }
//        return result; // 0

        // Option #2
//        short result = 0; // Example 3 - 11
//        while (x != 0) { // 11 != 0 , 1 != 0
//            result ^= 1; // 0 ^ 1 = 1 , 1 ^ 1 = 0
//            x &= (x - 1); // 11 & 10 = 10 , 1 & 0 = 0
//        }
//        return result; // 0

        // Option #3
        // uses the fact that XOR is associative and commutative
        // and that x ^ x = 0 for any x
        // Example 3 - 11 and 11 >>> 32 = 0 and 11 ^ 0 = 11
        // 11 ^ 11 >>> 16 = 11 ^ 0 = 11
        // 11 ^ 11 >>> 8 = 11 ^ 0 = 11
        // 11 ^ 11 >>> 4 = 11 ^ 0 = 11
        // 11 ^ 11 >>> 2 = 11 ^ 0 = 11
        // 11 ^ 11 >>> 1 = 11 ^ 1 = 10


        x ^= x >>> 32;
        x ^= x >>> 16;
        x ^= x >>> 8;
        x ^= x >>> 4;
        x ^= x >>> 2;
        x ^= x >>> 1;

        return (short) (x & 1);


    }

    public static void main(String[] args) {
        System.out.println("Parity of 0 is " + parity(0));
        System.out.println("Parity of 1 is " + parity(1));
        System.out.println("Parity of 2 is " + parity(2));
        System.out.println("Parity of 3 is " + parity(3));
        System.out.println("Parity of 4 is " + parity(4));
        System.out.println("Parity of 5 is " + parity(5));
        System.out.println("Parity of 6 is " + parity(6));
        System.out.println("Parity of 7 is " + parity(7));
        System.out.println("Parity of 8 is " + parity(8));
        System.out.println("Parity of 9 is " + parity(9));

    }
}
