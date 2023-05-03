package com.test.strings;

public class RunLengthEncoding {
    public String runLengthEncoding(String string) {
        // Write your code here.
        int charCount = 1;
        char prevChar;
        string = string + "\n";
        StringBuilder returnString = new StringBuilder();
        for (int idx = 1; idx < string.length(); idx++) {
            prevChar = string.charAt(idx - 1);
            if (prevChar == string.charAt(idx)) {
                charCount++;
                if (charCount == 9) {
                    returnString.append(charCount).append(string.charAt(idx - 1));
                    charCount = 0;
                }
            } else {
                returnString.append(charCount).append(string.charAt(idx - 1));
                charCount = 1;
            }
        }
        return returnString.toString();
    }

    public static void main(String[] args) {
        String input = "AAAAAAAAAAAAABBCCCCDD";
        String expected = "9A4A2B4C2D";
        System.out.println(new RunLengthEncoding().runLengthEncoding(input));
    }
}
