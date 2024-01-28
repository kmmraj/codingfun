package com.test.strings;

import java.util.ArrayList;
import java.util.List;

public class StringMultiply {

    public String multiply(String num1, String num2) {
        // int idx= num1.length()-1;
        // int jdx= num2.length()-1;
        // num1 = 123
        // num2 = 456
        // product = 56088
        // 3 * 456 * 1   =  1368
        // 2 * 456 * 10  =  9120
        // 1 * 456 * 100 = 45600

        // product =       56088


        int index=0;
        List<Double> tempSumList = new ArrayList<>();

        for(int idx= num1.length()-1; idx>=0; idx--) {
            StringBuilder tempSumSB= new StringBuilder();
            int carry=0;
            for(int jdx= num2.length()-1; jdx>=0; jdx--){
                int val1 = num1.charAt(idx) - '0';
                int val2 = num2.charAt(jdx) - '0';
                int prod = carry + (val1 * val2) ;
                carry = prod/10;
                int remain = prod%10;

                // System.out.println(" val1 is "+val1 + " val2 is "+val2 +" prod is " + prod + " carry is "+carry +
                // " remain is "+remain);
                tempSumSB.insert(0, remain);
            }
            if(carry>0){
                tempSumSB.insert(0, carry);
            }
            double multiFactor = Math.pow(10,index++);
            tempSumList.add(Double.parseDouble(tempSumSB.toString())*multiFactor);
        }
        Double total =  tempSumList.stream().reduce(0.0,Double::sum);

        return String.format("%.0f", total);

    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        String expected = "56088";
        String actual = new StringMultiply().multiply(num1, num2);
        System.out.println("Expected is " + expected + " and actual is " + actual);

        num1 = "28337377373737377337";
        num2 = "28337377373737377337";
        expected = "801007654894094094094019019019019019";
        actual = new StringMultiply().multiply(num1, num2);
        System.out.println("Expected is " + expected + " and actual is " + actual);


        num1 = "123456789";
        num2 = "987654321";
        expected = "121932631112635269";
        actual = new StringMultiply().multiply(num1, num2);
        System.out.println("Expected is " + expected + " and actual is " + actual);
    }
}
