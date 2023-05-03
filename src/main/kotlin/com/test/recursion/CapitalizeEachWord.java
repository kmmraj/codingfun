package com.test.recursion;

public class CapitalizeEachWord {
    public static String capitalizeWord(String str) {
        //   BC

        if(str.length() == 1){
           str = str.replace(str.charAt(0), (char) (str.charAt(0)-32));
           return str;
        }

        // H & I
        if(str.charAt(str.length()-2) == ' '){
            str = str.replace(str.charAt(str.length()-1), (char) (str.charAt(str.length()-1)-32));
        }
        return capitalizeWord(str.substring(0,str.length()-1))+ str.substring(str.length()-1);

    }

    public static void main(String[] args) {
        System.out.println(" Capitalize word of \"i love kani\" is " + capitalizeWord("i love kani"));
        System.out.println(" Capitalize word of \"i love java\" is " + "\"" + capitalizeWord("i love java") +"\"");
        System.out.println(" Capitalize word of \"ilovekani\" is " + capitalizeWord("ilovekani"));
    }
}
