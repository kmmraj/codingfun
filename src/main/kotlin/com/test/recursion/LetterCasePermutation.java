package com.test.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LetterCasePermutation {

    List<String> result;
    Queue<String> queue;

    public List<String> letterCasePermutation(String S) {
//       if (S == null) {
//           return new ArrayList<>();
//       }
//         this.result = new ArrayList<>();
//         return letterCasePermutation(S, "", 0);
        return letterCasePermutationWithDFS(S);
    }

    //a1b2
    public List<String> letterCasePermutationWithDFS(String S) {
        if (S == null) {
            return new LinkedList<>();
        }
        this.queue = new LinkedList<>();
        queue.offer(S);
        for (int idx = 0; idx < S.length(); idx++) {
           if(Character.isDigit(S.charAt(idx))){
               continue;
           }
           int size = queue.size();
            for (int jdx = 0; jdx < size; jdx++) {
                String workingCopy = queue.poll();
                assert workingCopy != null;
                char[] workingArr = workingCopy.toCharArray();
                workingArr[idx] = Character.toLowerCase(workingArr[idx]);
                queue.offer(String.valueOf(workingArr));
                workingArr[idx] = Character.toUpperCase(workingArr[idx]);
                queue.offer(String.valueOf(workingArr));
            }

        }
        return new LinkedList<>(queue);
    }

    private List<String> letterCasePermutation(String s, String workingCopy, int idx) {
        // BC
        if(idx == s.length()){
            result.add(workingCopy);
            return result;
        }

        // Hypothesis & Induction
        Character character = s.charAt(idx);
        if(Character.isDigit(character)){
            String choiceOne = String.valueOf(character);
            letterCasePermutation(s, workingCopy+choiceOne, idx+1);
        } else {
            String choiceOne = String.valueOf(character).toLowerCase();
            String choiceTwo = String.valueOf(character).toUpperCase();
            letterCasePermutation(s, workingCopy+choiceOne, idx+1);
            letterCasePermutation(s, workingCopy+choiceTwo, idx+1);
        }
        return result;
    }


    public List<String> solve(String input){

      // return solveIt(input,"", 0);
        return letterCasePermutation(input);
    }

    private List<String> solveIt(String input, String workingCopy, int index){
        List<String> result = new ArrayList<>();
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
        List<String> result;
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
