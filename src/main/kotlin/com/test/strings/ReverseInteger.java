package com.test.strings;

public class ReverseInteger {
    public int reverse(int x) {

        long result=0;
        while(x!=0){
            result = x%10+result*10;
            if(result>Integer.MAX_VALUE)
                return 0;
            if(result < Integer.MIN_VALUE)
                return 0;
            x= x/10;
        }
        return (int)result;
    }

    public static void main(String[] args) {
        ReverseInteger integer = new ReverseInteger();
        System.out.println(integer.reverse(1534236469));
        System.out.println(integer.reverse(1539));
    }
}
