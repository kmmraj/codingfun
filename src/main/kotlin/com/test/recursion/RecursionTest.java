package com.test.recursion;

import java.util.ArrayList;
import java.util.List;

public class RecursionTest {

    private int countIt(List<Integer> arrayList){
        int count = 0;
        // BC
        if(arrayList.size() == 0)
            return count;

        arrayList.remove(arrayList.size()-1);
        count = 1+countIt(arrayList);
        return count;
    }

    private List<Integer> countList(List<List<Integer>> aLOfAl){
        List<Integer> answerList = new ArrayList<>();
        //#A BC
        if(aLOfAl.size() == 0)
            return answerList;
        //#B Hypo & Choice D
        int count = countIt(aLOfAl.get(aLOfAl.size()-1));
        aLOfAl.remove(aLOfAl.size()-1);
        answerList = countList(aLOfAl);
        //#C Update post recursion
        answerList.add(count);
        return answerList;
    }

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);

        RecursionTest test = new RecursionTest();
//        System.out.println(test.countIt(arrayList));

        List<Integer> arrayListA = new ArrayList<>() ;
        arrayListA.add(1);
        arrayListA.add(2);

        List<Integer> arrayListB = new ArrayList<>() ;
        arrayListB.add(3);
        arrayListB.add(4);
        arrayListB.add(5);

        List<List<Integer>> alOfAL = new ArrayList<>();
        alOfAL.add(arrayList);
        alOfAL.add(arrayListA);
        alOfAL.add(arrayListB);
        System.out.println(test.countList(alOfAL));
    }
}
