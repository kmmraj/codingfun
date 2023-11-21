package com.test.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringsRearrangement {

    public static void main(String[] args) {
        String[] inputArray = new String[] {"abc", "bef", "bcc", "bec", "bbc", "bdc"};
        StringsRearrangement stringsRearrangement = new StringsRearrangement();
        System.out.println(stringsRearrangement.solution(inputArray));
    }

    boolean solution(String[] inputArray) {

        ArrayList<String> solution = new ArrayList<>();
        ArrayList<String> inputList = new ArrayList<>(Arrays.asList(inputArray));

        List<Integer> outputList = new ArrayList<>();
        int[] outputArray = outputList.stream().mapToInt(i -> i).toArray();
        return bt(inputList, solution);
    }

    boolean bt(ArrayList<String> inputArray, ArrayList<String> solution) {
        for (int index = 0; index < inputArray.size(); index++) {
            solution.add(inputArray.remove(index));
            if (inputArray.isEmpty() && checkSolution(solution)) {
                return true;
            } else if (bt(inputArray, solution)) {
                return true;
            }
            inputArray.add(index, solution.remove(solution.size() - 1));
        }
        return false;
    }

    boolean checkSolution(ArrayList<String> solution) {
        for (int i = 0; i < solution.size() - 1; i++) {
            int diff = 0;
            for (int j = 0; j < solution.get(i).length(); j++) {
                if (solution.get(i).charAt(j) != solution.get(i + 1).charAt(j)) {
                    diff++;
                }
            }
            if (diff != 1) {
                return false;
            }
        }
        return true;
    }
}


//boolean solution(String[] inputArray) {
//
//    Map<Integer,ArrayResultSet> resultSetMap = new HashMap<>();
//    for (int index = 0; index < inputArray.length; index++) {
//        char[] charArray = inputArray[index].toCharArray();
//        ArrayResultSet iResultSet = new ArrayResultSet(charArray,
//                                                       inputArray[index],
//                                                       false);
//        resultSetMap.put(index, iResultSet);
//    }
//
//    //
//    for (int idx = 0; idx < inputArray.length; idx++) {
//        ArrayResultSet resultSetTarget = resultSetMap.get(idx);
//        for (int jdx = 0; jdx < inputArray.length; jdx++) {
//              ArrayResultSet resultSetCandidate = resultSetMap.get(jdx);
//              if(!resultSetCandidate.isUsed){
//                 int diff =  compareCharArray(resultSetTarget.charArray,
//                                              resultSetCandidate.charArray);
//                 if(diff == 1){
//                     resultSetCandidate.setIsUsed(true);
//                     resultSetTarget.matchFound = true;
//                     resultSetTarget.matchIndex = jdx;
//                 }
//              }
//        }
//    }
//    return true;
//}
////"abc", "bef", "bcc", "bec", "bbc", "bdc"
//// "abc", "bbc", "bcc","bdc", "bec", "bef"
//int compareCharArray(char[] arrayOne, char[] arrayTwo){
//    // abc <=> bbc (works)
//    // abc <=> bcc (No)
//    if(arrayOne.length != arrayTwo.length){
//        return -1;
//    }
//    //int diffCount = 0;
//    int matchFound = 0;
//    for (int idx = 0; idx < arrayOne.length; idx++) {
//        for(int jdx = idx; jdx < arrayOne.length; jdx++) {
//            if(arrayOne[idx] == arrayTwo[jdx]){
//                matchFound++;
//            }
//        }
//    }
//
//    return arrayOne.length - matchFound;
//}
//
//class ArrayResultSet{
//    char[] charArray;
//    String text;
//    boolean isUsed;
//    boolean matchFound;
//    int matchIndex;
//
//    public ArrayResultSet(char[] charArray,String text,boolean isUsed){
//        this.charArray = charArray;
//        this.text = text;
//        this.isUsed = isUsed;
//        this.matchFound = false;
//        this.matchIndex = -1;
//    }
//
//    void setIsUsed(boolean isUsed){
//        this.isUsed = isUsed;
//    }
//}
