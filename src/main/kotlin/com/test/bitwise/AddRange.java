package com.test.bitwise;

public class AddRange {
    public int rangeBitwiseAnd(int left, int right) {
        // 5 - 1001
        // 6 - 1010
        // 7 - 1011

        while(right > left){
            right = right & (right-1);
        }
        return right;

    }

    public static void main(String[] args) {
        AddRange addRange = new AddRange();
        System.out.println("Range bitwise and of 5 and 7 should be 4 and result is " + addRange.rangeBitwiseAnd(5,7));
        System.out.println("Range bitwise and of 0 and 0 should be 0 and result is " + addRange.rangeBitwiseAnd(0,0));
        System.out.println("Range bitwise and of 1 and 2147483647 should be 0 and result is " + addRange.rangeBitwiseAnd(1,2147483647));
        System.out.println("Range bitwise and of 3 and 3 should be 3 and result is " + addRange.rangeBitwiseAnd(3,3));
        System.out.println("Range bitwise and of 3 and 4 should be 0 and result is " + addRange.rangeBitwiseAnd(3,4));
        System.out.println("Range bitwise and of 4 and 5 should be 4 and result is " + addRange.rangeBitwiseAnd(4,5));

    }
}
