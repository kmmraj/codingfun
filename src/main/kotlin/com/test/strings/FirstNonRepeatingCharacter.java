package com.test.strings;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

    public int firstNonRepeatingCharacter(String string) {
        Map<Character,Integer> charMap = new HashMap<>();
        for (int idx = 0; idx < string.length(); idx++) {
            Character character = string.charAt(idx);
            int count =0;
            if(charMap.containsKey(character)){
                 count = charMap.get(character);
            }
            charMap.put(character,count+1);
        }

        for (int jdx = 0; jdx < string.length(); jdx++) {
            Character character = string.charAt(jdx);
            if(charMap.get(character) ==1){
                return jdx;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        TestCase1();
    }

    public static void TestCase1() {
        String input = "abcdcaf";
        int expected = 1;
        int actual = new FirstNonRepeatingCharacter().firstNonRepeatingCharacter(input);
        System.out.println(expected == actual);
    }
}
