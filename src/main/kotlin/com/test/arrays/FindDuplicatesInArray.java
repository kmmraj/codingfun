package com.test.arrays;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicatesInArray {

    public static int[] removeDuplicates(int[] arr) {

        List<Integer> uniqueElementList = new ArrayList<>();
       // uniqueElement[0] = arr[0];
        uniqueElementList.add(arr[0]);
        for(int indx=1; indx<=arr.length-1; indx++){
            if(arr[indx-1] != arr[indx]){
                uniqueElementList.add(arr[indx]);
            }
        }
        int[] uniqueElementArray = new int[uniqueElementList.size()];
        for(int indx=0; indx<=uniqueElementList.size()-1; indx++){
            uniqueElementArray[indx] = uniqueElementList.get(indx);
        }
        return uniqueElementArray;
    }

    public static void main(String[] args) {
        int[] array = {1,1,2,3,4,5,5,7,8};
        int[] uniqueElementArray = removeDuplicates(array);
        for(int indx=0; indx<uniqueElementArray.length; indx++){
            System.out.println(uniqueElementArray[indx]);
        }
    }
}
