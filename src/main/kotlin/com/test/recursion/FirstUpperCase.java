package com.test.recursion;

public class FirstUpperCase {

    static char first(String str) {
        //  BC
        if(str.length() ==0)
            return ' ';
        // H & I
        if(str.charAt(0) >= 65 && str.charAt(0) <=90){
            return str.charAt(0);
        }
        return first(str.substring(1));
    }

    public static void main(String[] args) {
        System.out.println(" First upper case in mohanRaj is " + first("mohanRaj"));
    }
}
