package com.test.recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    List<List<Integer>> answerSubset;
    List<Integer> innerList;

    public Subsets() {
        answerSubset = new ArrayList<List<Integer>>();
        innerList = new ArrayList<Integer>();
    }

    public List<List<Integer>> subsets(int[] nums) {
        return solveIt(nums,nums.length,0);
    }

    private List<List<Integer>> solveIt(int[] nums,int size, int index) {
        //BC
        if(index == size){
            answerSubset.add(new ArrayList<Integer>(innerList));
            innerList.clear();
            return answerSubset;
        }
        // Hypothesis & Induction
        innerList.add(nums[index]);
     //   answerSubset.add(new ArrayList<Integer>(innerList));
        answerSubset.addAll(solveIt(nums,size,index+1));
        return answerSubset;
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int [] nums = {1,2,3};
        List<List<Integer>> answer = subsets.subsets(nums);
        for (List<Integer> item:answer) {
            System.out.println(item);
        }
    }
}
