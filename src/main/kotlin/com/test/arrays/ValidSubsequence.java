package com.test.arrays;
//https://www.algoexpert.io/questions/Validate%20Subsequence
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidSubsequence {

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        // Write your code here.
        int secIdx=0;
        for (int idx = 0; idx < array.size(); idx++) {
            if(array.get(idx) == sequence.get(secIdx)){
                secIdx++;
            }
            if(secIdx == sequence.size())
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        //{"array": [5, 1, 22, 25, 6, -1, 8, 10], "sequence": [1, 6, -1, 10]}

        List<Integer> array = new ArrayList<>(Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10));
        List<Integer> sequence = new ArrayList<>(Arrays.asList(1, 6, -1, 10));
        System.out.println(ValidSubsequence.isValidSubsequence(array,sequence));

    }
}
