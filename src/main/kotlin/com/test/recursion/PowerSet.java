package com.test.recursion;

import java.util.ArrayList;

public class PowerSet {


    private ArrayList<String> solve(String ipString, String opString, int index, ArrayList<String> finalList) {
        //BC
        ArrayList<String>  testList = new ArrayList<String>();
        if(ipString.length() == index){
            System.out.println("O/P is: "+ opString);
            finalList.add(opString);
            testList.add(opString);
            return testList;
        }

        // Hypothesis
        testList.addAll(solve(ipString,opString, index+1, finalList));
        testList.addAll(solve(ipString,opString+ipString.charAt(index),index+1,finalList));

        return testList;
    }

    public static void main(String[] args) {
        String ipString = "abc";
        String opString="";
        PowerSet powerSet =  new PowerSet();
        int index =0;
        ArrayList<String> finalSet = new ArrayList<String>();
        ArrayList<String> answer = powerSet.solve(ipString,opString, index, finalSet);
        System.out.println(answer);
    }


}
