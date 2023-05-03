package com.test.recursion;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class LongestSubString {

//    String  lastBigCopy ="";
//    String workingCopy = "";

    public int lengthOfLongestSubstring(String s) {

        if(s.length() == 0){
            return 0;
        }

        return lengthOfLongestSubstringWithElimnateDups(s);
//        String[]  subString  = solve(s,s.length()-1);
//        return subString[1].length();

    }

    private int lengthOfLongestSubstringWithSlidingWindow(String s){

        int start =0;
        int end =0;
        int subStrSize =0;
        HashSet<Character> characters = new HashSet<Character>();
        while (end < s.length()){
            if(!characters.contains(s.charAt(end))){
                characters.add(s.charAt(end));
                end++;
                subStrSize = Math.max(subStrSize,end-start);
            } else {
                characters.remove(s.charAt(end));
                start++;
            }
        }
        return subStrSize;
    }

    private int lengthOfLongestSubstringWithElimnateDups(String s){

        int start =0;
        int end =0;
        int subStrSize =0;
        HashMap<Character,Boolean> characters = new HashMap<>();
        while (end < s.length()){
            if(!characters.containsKey(s.charAt(end))){
                characters.put(s.charAt(end),true);
                end++;
                //subStrSize = Math.max(subStrSize,end-start);
            } else {
                characters.put(s.charAt(end),false);
                end++;
            }
        }
        Collection<Boolean> charDups = characters.values();
        int nondupsCount = 0;
        for (boolean item:charDups) {
            if(item)
                nondupsCount++;
        }
        return nondupsCount;
    }

    private String[] solve(String string, int index) {

        String[] strArr = {"",""};
        //BC
        if(string.length() == 1){
            strArr[0] = strArr[1]=  string;
           return strArr;
        }

        // Hypo
        strArr =  solve(string.substring(0,string.length()-1),index-1);

        // Induction
        char charAtIndex = string.charAt(index);

        if(contains(strArr[0],charAtIndex)) {
           //if
            int remainingIndex = strArr[0].indexOf(charAtIndex);
            strArr[0] = strArr[0].substring(remainingIndex+1);
           // strArr[0] = ""; // Fix here, we need the index of the occurrence
            strArr[0] = strArr[0].concat(String.valueOf(charAtIndex));
        } else {
            strArr[0] =  strArr[0].concat(String.valueOf(charAtIndex));
        }

        if(strArr[1].length()  < strArr[0].length()){
            strArr[1] =  strArr[0];
        }

        return strArr;
    }

    private boolean contains(String s1,char c1){
        for (int index = 0; index < s1.length(); index++) {
           Character c2 = s1.charAt(index);
           if(c2.compareTo(c1) == 0) {
             return true;
           }
        }
        return false;
    }

    public static void main(String[] args) {

        LongestSubString  longestSubString = new LongestSubString();
        int length;

//        length  = longestSubString.lengthOfLongestSubstring("bbbb");
//        System.out.println("bbb sub string  length is "+ length);

        length  = longestSubString.lengthOfLongestSubstring("pwwkew");
        System.out.println("pwwkew sub string  length is "+ length);

        length  = longestSubString.lengthOfLongestSubstring("abcdabcdbb");
        System.out.println("abcabcbb sub string  length is "+ length);

        length  = longestSubString.lengthOfLongestSubstring(" ");
        System.out.println(" sub string  length is "+ length);

        length  = longestSubString.lengthOfLongestSubstring("  ");
        System.out.println(" sub string  length is "+ length);

        length  = longestSubString.lengthOfLongestSubstring("");
        System.out.println(" sub string  length is "+ length);

        length  = longestSubString.lengthOfLongestSubstring("ab");
        System.out.println("ab sub string  length is "+ length);

        length  = longestSubString.lengthOfLongestSubstring("dvdf");
        System.out.println("dvdf sub string  length is "+ length);

        length  = longestSubString.lengthOfLongestSubstring("dvdfev");
        System.out.println("dvdfev sub string  length is "+ length);



    }
}
