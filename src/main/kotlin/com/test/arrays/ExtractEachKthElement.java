package com.test.arrays;

import java.util.ArrayList;
import java.util.List;

public class ExtractEachKthElement {
    int[] solution(int[] inputArray, int k) {
        List<Integer> outputList = new ArrayList<>();
        for (int index = 0; index < inputArray.length; index++) {
            if((index+1) %k != 0){
                outputList.add(inputArray[index]);
            }
        }
        return outputList.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        ExtractEachKthElement extractEachKthElement = new ExtractEachKthElement();
        int[] inputArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 3;
        int[] outputArray = extractEachKthElement.solution(inputArray, k);
        for (int index = 0; index < outputArray.length; index++) {
            System.out.println(outputArray[index]);
        }
    }
}
