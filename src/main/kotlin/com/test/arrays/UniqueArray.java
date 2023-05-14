package com.test.arrays;

import java.util.HashSet;
import java.util.Set;

public class UniqueArray {

    public boolean isUnique(int[] intArray) {
        Set<Integer> uniqueSet = new HashSet<>();
        for(int indx=0; indx <= intArray.length -1 ; indx++){
            if(!uniqueSet.add(intArray[indx])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        int[] array = {1,1,2,3,4,5,5,7,8};
        int[] array = {1,2,3,4,5,7,8};
        UniqueArray uniqueArray = new UniqueArray();
        boolean isUnique = uniqueArray.isUnique(array);
        System.out.println(isUnique);
    }
}
