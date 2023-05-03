package com.test.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        return solveIt(n,n, "");
    }

    private  ArrayList<String> solveIt(int open, int close, String workingCopy){
        ArrayList<String> result =  new ArrayList<String>();
        // BC
        if(open == 0 && close == 0){
            result.add(workingCopy);
            return result;
        }

        // Hypo & Induction
        if(open == close){
            result.addAll(solveIt(open -1,close,workingCopy+"("));
        } else if(open < close) {
           // Two Paths
            result.addAll(solveIt(open,close -1,workingCopy+")"));
            if(open != 0) {
                result.addAll( solveIt(open-1,close ,workingCopy+"("));
            }
        }

        return result;
    }
    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();

        ArrayList<String> answer = (ArrayList<String>) generateParenthesis.generateParenthesis(3);
        for (String item: answer) {
            System.out.println(item);
        }
    }
}
