package com.test.recursion;

public class Reverse {

    public static String reverse(String str)
    {
        // BC
        if(str.length() == 0){
            return "";
        }

        // H & I
        return str.substring(str.length()-1) + reverse(str.substring(0,str.length()-1));
    }

    public static void main(String[] args) {
        System.out.println(" Reverse of java is "+ Reverse.reverse("java"));
        System.out.println(" Reverse of mohanraj is "+ Reverse.reverse("mohanraj"));
        System.out.println(" Reverse of kanimoliy is "+ Reverse.reverse("kanimoliy"));
        System.out.println(" Reverse of kanmani is "+ Reverse.reverse("kanmani"));
        System.out.println(" Reverse of kavitha is "+ Reverse.reverse("kavitha"));
    }
}
