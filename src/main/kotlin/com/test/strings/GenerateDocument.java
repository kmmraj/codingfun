package com.test.strings;

import java.util.HashMap;
import java.util.Hashtable;

public class GenerateDocument {
    public boolean generateDocument(String characters, String document) {
        HashMap<Character, Integer> charTable = new HashMap<>();
        for (int idx = 0; idx < characters.length(); idx++) {
            Character currentChar = characters.charAt(idx);
            generateCharCount(charTable, currentChar);
        }

        HashMap<Character, Integer> docTable = new HashMap<>();
        for (int jdx = 0; jdx < document.length(); jdx++) {
            Character currentChar = document.charAt(jdx);
            if (!charTable.containsKey(currentChar) || charTable.get(currentChar) == 0) {
                return false;
            }
            charTable.put(currentChar, charTable.get(currentChar) - 1);
        }

        return charTable.containsValue(1);

    }

    private void generateCharCount(HashMap<Character, Integer> charMap, Character currentChar) {
        Integer charCount;
        if (charMap.containsKey(currentChar)) {
            charCount = charMap.get(currentChar);
            charCount = charCount + 1;
        } else {
            charCount = 1;
        }
        charMap.put(currentChar, charCount);
    }

    public static void main(String[] args) {
        TestCase1();
    }

    public static void TestCase1() {
        String characters = "Bste!hetsi ogEAxpelrt x ";
        String document = "AlgoExpert is the Best!";
        boolean expected = true;
        boolean actual = new GenerateDocument().generateDocument(characters, document);
        System.out.println(expected == actual);
    }
}
