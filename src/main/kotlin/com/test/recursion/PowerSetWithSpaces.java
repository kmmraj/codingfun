package com.test.recursion;

import java.util.ArrayList;

public class PowerSetWithSpaces {


    private ArrayList<String> solve(String ipString) {
        ArrayList<String> result;
        int index =0;
        String opStringOne = String.valueOf(ipString.charAt(0));
        String opStringTwo = ipString.substring(1);
        result = solveIt(opStringOne, opStringTwo, index);
        return result;
    }

    private ArrayList<String> solveIt(String workingStr, String remainingString, int index) {
        // BC
        ArrayList<String> answer = new ArrayList<String>();
        if(remainingString.length() == index){
            answer.add(workingStr);
            return answer;
        }

        // Hypo and Induction
        // Fix remainingString
        answer.addAll(solveIt(workingStr +" " + remainingString.charAt(index), remainingString, index+1));
        answer.addAll(solveIt(workingStr + remainingString.charAt(index), remainingString, index+1));
        return answer;
    }

    public static void main(String[] args) {
        PowerSetWithSpaces withSpaces = new PowerSetWithSpaces();
        ArrayList<String> answer = withSpaces.solve("abc");
        for (String item:answer) {
            System.out.println(item);
        }
    }
}
