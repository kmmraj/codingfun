package com.test.arrays;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CommonCharCount {

    int solution(String s1, String s2) {

        Map<Character,Integer> charMapOne = new TreeMap<>();
        Map<Character,Integer> charMapTwo = new TreeMap<>();
        for (int idx = 0; idx < s1.length(); idx++) {
            if(charMapOne.containsKey(s1.charAt(idx))){
                int temp = charMapOne.get(s1.charAt(idx));
                charMapOne.put(s1.charAt(idx), temp+1);
            } else {
                charMapOne.put(s1.charAt(idx), 1);
            }
        }

        for (int idx = 0; idx < s2.length(); idx++) {
            if(charMapTwo.containsKey(s2.charAt(idx))){
                int temp = charMapTwo.get(s2.charAt(idx));
                charMapTwo.put(s2.charAt(idx), temp+1);
            } else {
                charMapTwo.put(s2.charAt(idx), 1);
            }
        }
        List<Integer> listOfCount =charMapOne
                .entrySet()
                .stream()
                .flatMap(
                        es1 -> charMapTwo
                                .entrySet()
                                .stream()
                                .filter(es2 -> es1.getKey().charValue() == es2.getKey().charValue())
                                .map(es2 -> Integer.min(es2.getValue(),es1.getValue())))
                .toList();

        return listOfCount
                .stream()
                .reduce(0, Integer::sum);

    }

    public static void main(String[] args) {
        CommonCharCount commonCharCount = new CommonCharCount();
        System.out.println(commonCharCount.solution("aabcc","adcaa"));
    }


}
