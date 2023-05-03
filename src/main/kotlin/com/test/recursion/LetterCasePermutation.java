package com.test.recursion;

import java.util.ArrayList;

public class LetterCasePermutation {


    public ArrayList<String> solve(String input){

       return solveIt(input,"", 0);
    }

    private ArrayList<String> solveIt(String input, String workingCopy, int index){
        ArrayList<String> result = new ArrayList<String>();
        //BC
        if(index == input.length()){
            result.add(workingCopy);
            return result;
        }

        //Hypo & Induction  -- Decision and Choices
        Character character = input.charAt(index);

        // Fix  this to skip two cases if it is a digit
        if(Character.isDigit(character)){
            String choiceOne =String.valueOf(character);
            result.addAll(solveIt(input,workingCopy+choiceOne,index+1));
        } else {
            String choiceOne = String.valueOf(character).toLowerCase();
            String choiceTwo = String.valueOf(character).toUpperCase();
            result.addAll(solveIt(input,workingCopy+choiceOne,index+1));
            result.addAll(solveIt(input,workingCopy+choiceTwo,index+1));
        }

        return result;

    }

    public static void main(String[] args) {
        LetterCasePermutation letterCasePermutation = new LetterCasePermutation();
        ArrayList<String> result;
        result = letterCasePermutation.solve("a1b2");
        for (String item: result) {
            System.out.println(item);
        }

        result = letterCasePermutation.solve("123");
        for (String item: result) {
            System.out.println(item);
        }

        result = letterCasePermutation.solve("3z4");
        for (String item: result) {
            System.out.println(item);
        }

        result = letterCasePermutation.solve("0");
        for (String item: result) {
            System.out.println(item);
        }
    }
}
