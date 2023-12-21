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

    public int reverseUsingString(int x) {
        StringBuilder stringBuilder = new StringBuilder();
        if(x<0){
            x = Math.abs(x);
            stringBuilder.append(x);
            return Integer.parseInt("-"+stringBuilder.reverse().toString());
        } else {
            stringBuilder.append(x);
            return Integer.parseInt(stringBuilder.reverse().toString());
        }
    }

    public static void main(String[] args) {
        ReverseInteger integer = new ReverseInteger();
        System.out.println(integer.reverse(1534236469));
        System.out.println(integer.reverseUsingString(1534236469));
        System.out.println(integer.reverse(1539));
        System.out.println(integer.reverseUsingString(1539));
    }
}
