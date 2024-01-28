package com.test.strings;

public class ReverseInteger {
    public int reverse(int x) {

        int xVal = Math.abs(x);
        long result=0;
        while(xVal!=0){
            result = xVal%10+result*10;
            if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
                return 0;
            }
            xVal= xVal/10;
        }
        return (int) (x > 0 ? result : -result);
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
        System.out.println(integer.reverse(34236469));
        System.out.println(integer.reverseUsingString(34236469));
        System.out.println(integer.reverse(1539));
        System.out.println(integer.reverseUsingString(1539));
    }
}
