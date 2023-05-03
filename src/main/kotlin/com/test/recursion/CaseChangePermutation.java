package com.test.recursion;

import java.util.ArrayList;

public class CaseChangePermutation {

    private ArrayList<String> solve(String inputString) {
        return solveIt(inputString,"",0);
    }

    private ArrayList<String> solveIt(String firstIp, String workingStr, int index) {
        //BC
        ArrayList<String> result = new ArrayList<String>();
        if(firstIp.length() == index){
            result.add(workingStr);
            return result;
        }

        // Hypo and Induction
        String charOne = String.valueOf(firstIp.charAt(index)).toLowerCase();
        String charTwo = String.valueOf(firstIp.charAt(index)).toUpperCase();

        result.addAll(solveIt(firstIp,workingStr+charOne,index+1));
        result.addAll(solveIt(firstIp,workingStr+charTwo,index+1));

        return result;
    }

    public static void main(String[] args) {
        CaseChangePermutation changePermutation = new CaseChangePermutation();
        ArrayList<String> result =  changePermutation.solve("abc");
        for (String item:result) {
            System.out.println(item);
        }
    }


}
