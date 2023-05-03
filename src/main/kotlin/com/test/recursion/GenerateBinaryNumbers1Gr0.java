package com.test.recursion;

import java.util.ArrayList;

public class GenerateBinaryNumbers1Gr0 {

    private ArrayList<String> solve(int size) {
        return solveIt(size, "",0,0);
    }

    private ArrayList<String> solveIt(int size, String workingCopy, int ones, int zeros) {
        ArrayList<String> result = new ArrayList<String>();
        // BC
        if(ones+zeros == size){
            result.add(workingCopy);
            return result;
        }

        // Hypo & Induction
        if(ones == zeros){
            result.addAll(solveIt(size,workingCopy+"1", ones+1,zeros));
        } else {
            result.addAll(solveIt(size,workingCopy+"1", ones+1,zeros));
            result.addAll(solveIt(size,workingCopy+"0", ones,zeros+1));
        }


        return result;
    }

    public static void main(String[] args) {
        GenerateBinaryNumbers1Gr0 numbers1Gr0 = new GenerateBinaryNumbers1Gr0();
        ArrayList<String> result = numbers1Gr0.solve(3);
        for (String item: result) {
            System.out.println(item);
        }

    }


}
