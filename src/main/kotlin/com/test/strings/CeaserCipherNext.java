package com.test.strings;

public class CeaserCipherNext {
    public static String caesarCypherEncryptor(String str, int key) {
        // Write your code here.
        char[] newChars = new char[str.length() + 1];
        key = key % 26;
        for (int idx = 0; idx < str.length(); idx++) {
            int newLetter = str.charAt(idx) + key;
            newLetter = newLetter <= 122 ? newLetter : (96 + (newLetter % 122));
            newChars[idx] = (char) (newLetter);
        }
        return new String(newChars);
    }

    public static void main(String[] args) {
        System.out.println(CeaserCipherNext.caesarCypherEncryptor("xyz", 2));
    }
}
