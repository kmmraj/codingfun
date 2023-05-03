package com.test.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;

public class MinimumWindowSubString {

    public String minWindow(String s, String t) {
        int start=0;
        int end=0;
        String minWindow = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        minWindow = minWindow+minWindow+minWindow+minWindow+minWindow+minWindow+minWindow+minWindow+minWindow+minWindow+minWindow+minWindow;
        String minWindowCopy = minWindow;

        if(s.length() == 0 || t.length() == 0 || s.length() < t.length())
            return "";

        if(s.equals(t))
            return s;

        HashMap<Character, Integer> containMap = getContainMap(t);
        Integer totalCount = containMap.size();



        while (start < s.length() && end <= s.length()){
            String substr = s.substring(start,end);
            // fix contains

            if(doesSubStrExist(substr,containMap, totalCount)){
                minWindow = minWindow.length() < substr.length() ? minWindow:substr; // Fix this
                start = start+1;
            }
            end = end+1;

        }
        return minWindow == minWindowCopy ? "": minWindow;
    }

    private boolean doesSubStrExist(String subStr, HashMap<Character, Integer> containMap, Integer totalCount){

        if(subStr.length() == 0)
            return false;

        int endj=0;
        int starti=0;
        boolean result = true;
        while (starti < subStr.length() && endj < subStr.length()){
            char charAtEval = subStr.charAt(endj);
            if(containMap.containsKey(charAtEval)){
                int charCount = containMap.get(charAtEval);
                charCount--;
                if(charCount <= 0){
                    charCount=0;
                }

                if(charCount == 0){
                    totalCount--;
                }
                containMap.put(charAtEval,charCount);
                endj++;
            } else {
                result =  false;
                // TODO: Fix the charCount and total count here
                char charAtEvalStartI = subStr.charAt(starti);
                if(containMap.containsKey(charAtEvalStartI)) {
                    int charCount = containMap.get(charAtEvalStartI);
                    if(charCount ==0){
                        totalCount++;
                    }
                    charCount++;
                    containMap.put(charAtEvalStartI,charCount);
                }

                starti++;
            }
        }

        if(totalCount != 0)
            result = false;

        // TODO : Improvise the result with subsequent calls
        return result; // return starti, endji, totalcount
    }

    public String minWindowOld(String s, String t) {
        int start=0;
        int end=0;
        String minWindow = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        minWindow = minWindow+minWindow+minWindow+minWindow+minWindow+minWindow+minWindow+minWindow+minWindow+minWindow+minWindow+minWindow;
        String minWindowCopy = minWindow;

        if(s.length() == 0 || t.length() == 0 || s.length() < t.length())
            return "";

        if(s.equals(t))
            return s;

        HashMap<Character, Integer> containMap = getContainMap(t);
        Integer totalCount = containMap.size();

//        while (start < s.length() && end <= s.length()){
//            String substr = s.substring(start,end);
//            // fix contains
//            if(doesItContain(substr,t)){
//                minWindow = minWindow.length() < substr.length() ? minWindow:substr; // Fix this
//                start = start+1;
//            } else {
//                end = end+1; // fix here
//            }
//
//        }

        while (start < s.length() && end <= s.length()){
            String substr = s.substring(start,end);
            // fix contains
            if(doesSubStrExist(substr,containMap, totalCount)){
                minWindow = minWindow.length() < substr.length() ? minWindow:substr; // Fix this
                start = start+1;
            }
                end = end+1;

        }
        return minWindow == minWindowCopy ? "": minWindow;
    }



    private boolean doesItContain(String subStr, String t){
        // TODO: Try to rewrite it check occurrence of each chars in t with substr

        if(subStr.length() < t.length())
            return false;
        HashMap<Character, ArrayList<Integer>> containMap = new HashMap<Character, ArrayList<Integer>>(); // Does HashMap work on aa  vs aaa ?
        for (int tIndex = 0; tIndex < t.length(); tIndex++) {
            char character = t.charAt(tIndex);
            int  index =  subStr.indexOf(character);
            if(index == -1){
                return false;
            } else {
                if(containMap.containsKey(character)){
                    ArrayList<Integer> charIndexArray =  containMap.get(character);
                    int  charIndex = charIndexArray.get(charIndexArray.size()-1);
                    int newIndex = subStr.indexOf(character,charIndex+1);

                    if(newIndex == -1){
                        return false;
                    } else {
                        charIndexArray.add(newIndex);
                        containMap.put(character,charIndexArray);
                    }
                }  else {
                    ArrayList<Integer> charIndexArray = new ArrayList<Integer>();
                    charIndexArray.add(index);
                    containMap.put(character,charIndexArray);
                }
            }
        }
        return true;
    }

    private HashMap<Character, Integer> getContainMap(String t){
        HashMap<Character, Integer> containMap = new HashMap<Character, Integer>();
        for (int tIndex = 0; tIndex < t.length(); tIndex++) {
            char character =  t.charAt(tIndex);
            if(containMap.containsKey(character)) {
                int charCount = containMap.get(character);
                containMap.put(character, charCount);
            } else {
                containMap.put(character, 1);
            }
        }

        return containMap;
    }



    public static void main(String[] args) {

        MinimumWindowSubString windowSubString = new MinimumWindowSubString();
        String answer;

        answer = windowSubString.minWindow("ADOBECODEBANC","ABC");
        System.out.println(answer);

        answer = windowSubString.minWindow("a","a");
        System.out.println(answer);

        answer = windowSubString.minWindow("ADOBECODEBANC","");
        System.out.println(answer);

        answer = windowSubString.minWindow("ADOBECODEBANC","B");
        System.out.println(answer);

        answer = windowSubString.minWindow("ADOBECODEBANC","ADOBECODEBANC");
        System.out.println(answer);

        answer = windowSubString.minWindow("aa","aaa");
        System.out.println(answer);

        answer = windowSubString.minWindow("abc","ac");
        System.out.println(answer);
        answer = windowSubString.minWindow("a","b");
        System.out.println(answer);

        answer = windowSubString.minWindow("bbaa","aba");
        System.out.println(answer);

        answer = windowSubString.minWindow("aaflslflsldkalskaaa","aaa");
        System.out.println(answer);

        answer = windowSubString.minWindow("baab","bbb");
        System.out.println(answer);
    }
}
