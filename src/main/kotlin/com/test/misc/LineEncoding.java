package com.test.misc;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class LineEncoding {
    String solution(String s) {
        StringBuilder returnString = new StringBuilder();
        Character prevChar = s.charAt(0);
        Character tempChar = s.charAt(s.length()-1);
        int charCount=1;
        for (int index = 1; index < s.length(); index++) {
            tempChar = s.charAt(index);
            if(tempChar == prevChar){
                charCount++;
            }else{
                returnString.append(charCount == 1 ? "":charCount).append(prevChar);
                prevChar = tempChar;
                charCount=1;
            }
        }
        returnString.append(charCount == 1 ? "":charCount).append(tempChar);
        return returnString.toString();

    }

    public static void main(String[] args) {
        LineEncoding lineEncoding = new LineEncoding();
        System.out.println("Expected encoding is 2a3bc and ans is "+lineEncoding.solution("aabbbc"));
        System.out.println("Expected encoding is 4c and ans is "+lineEncoding.solution("cccc"));
        System.out.println("Expected encoding is 2a3b4c and ans is "+lineEncoding.solution("aabbbcccc"));


    }
}
