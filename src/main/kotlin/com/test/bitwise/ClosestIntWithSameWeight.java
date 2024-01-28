package com.test.bitwise;
//https://www.geeksforgeeks.org/find-closest-integer-with-the-same-weight/

//Given a positive integer x. The task is to find the closest number (positive) with the same weight.
// The weight of a positive integer is defined as the number of set bits in its binary representation.
// For instance, the weight of 10 is 2, and the weight of 15 is 4.
// If two numbers have the same weight, then the smaller one is considered as closest to the given number.
// For example, if x is 10, then the output should be 9. If x is 8, then the output should be 4.
// If x is 7, then the output should be 11.
// Examples:
// Input: x = 10
// Output: 9
// 10 has a weight of 2 (1010). The closest number to it with a weight of 2 is 9 (1001).
// Input: x = 8
// Output: 4
// 8 has a weight of 1 (1000). The closest number to it with a weight of 1 is 4 (100).
// Input: x = 7
// Output: 11
// 7 has a weight of 3 (111). The closest number to it with a weight of 3 is 11 (1011).
// Approach: The idea is to start from the least significant bit and traverse towards the most significant bit.
// If we find two consecutive bits as 01 or 10, then we swap those bits.
// For example, if the given number is 10 (1010), then we swap the consecutive bits from the right side.
// The number after swapping becomes 9 (1001), which has the same weight as 10.
public class ClosestIntWithSameWeight {
    public static long closestIntSameBitCount(long x) {
        final int NUM_UNSIGNED_BITS = 63;
        for (int index = 0; index + 1 < NUM_UNSIGNED_BITS; index++) {
            if (((x >>> index) & 1) != ((x >>> (index + 1)) & 1)) { // Swift right by  index and by '1' 
                int swapXOR = (1 << index) | (1 << (index + 1)); // Create a mask with 1 at index and index + 1
                return x ^ swapXOR; // XOR with mask - this will swap the bits
            }
        }
        return 0;
    }

    public static long closestIntSameBitCount2(long x) {
        if ((x & 1) ==1) {
            return ((x ^ (x+1))  >> 2) | (x+1);
        } else {
            return ~((x ^ (x-1)) >> 2) & (x-1);
        }
    }

    public static void main(String[] args) {

        System.out.println("Closest int with same weight of 1 should be 2 and answer is  " + closestIntSameBitCount2(1));
        System.out.println("Closest int with same weight of 2 should be 1 and answer is  " + closestIntSameBitCount2(2));

        System.out.println("Closest int with same weight of 3 should be 5 and answer is  " + closestIntSameBitCount2(3));
        System.out.println("Closest int with same weight of 5 should be 3 and answer is  " + closestIntSameBitCount2(5));

        System.out.println("Closest int with same weight of 4 should be 2 and answer is  " + closestIntSameBitCount(4));
        System.out.println("Closest int with same weight of 6 should be 5 and answer is  " + closestIntSameBitCount(6));

        System.out.println("Closest int with same weight of 7 should be 11 and answer is  " + closestIntSameBitCount(7));
        System.out.println("Closest int with same weight of 11 should be 7 and answer is  " + closestIntSameBitCount(11));

        System.out.println("Closest int with same weight of 8 should be 4 and answer is  " + closestIntSameBitCount(8));
        System.out.println("Closest int with same weight of 9 should be 10 and answer is  " + closestIntSameBitCount(9));
    }
}
