package com.test;

import java.util.ArrayList;

public class SortArray {

    void sort (ArrayList<Integer> integers) {
        //BC
        if(integers.isEmpty())
            return;
        //Hypothesis
        int lastValue = integers.get(integers.size()-1);
        integers.remove(integers.size()-1);
        sort(integers);

        // Induction
        insert(integers,lastValue);
        System.out.println("Lastvalue is : "+ lastValue);

    }

    private void insert(ArrayList<Integer> integers, int lastValue) {
        //BC
        if(integers.isEmpty() || integers.get(integers.size()-1) < lastValue){
            integers.add(lastValue);
            return;
        }

        // Hypothesis
        int greaterVal = integers.get(integers.size()-1);
        integers.remove(integers.size()-1);
        insert(integers,lastValue);

        // Induction
        integers.add(greaterVal);
        return;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(5);
        arrayList.add(2);
        arrayList.add(4);
        arrayList.add(3);
        SortArray sortArray = new SortArray();
        sortArray.sort(arrayList);
    }
}
