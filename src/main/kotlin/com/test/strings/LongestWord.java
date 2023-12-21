package com.test.strings;
//Define a word as a sequence of consecutive English letters. Find the longest word from the given string.
//
//Example
//
//For text = "Ready, steady, go!", the output should be
//solution(text) = "steady".
//
//Input/Output
//
//[execution time limit] 3 seconds (java)
//
//[memory limit] 1 GB
//
//[input] string text
//
//Guaranteed constraints:
//4 ≤ text.length ≤ 50.
//
//[output] string
//
//The longest word from text. It's guaranteed that there is a unique output.
public class LongestWord {
    String solution(String text) {

        String resultString = "", tempString = "";

        for (int idx = 0; idx < text.length(); idx++) {
            int tempCharValue = text.charAt(idx);
          //  System.out.println("Temp Char Value is "+ tempCharValue);
            // if((tempCharValue >= 65 && tempCharValue<= 90)
            // || (tempCharValue >= 97 && tempCharValue<= 122)){
            //     tempString = tempString+text.charAt(idx);
            // }

            if((tempCharValue < 65)
                    || (tempCharValue > 90 && tempCharValue < 97) || tempCharValue > 122){
                if(tempString.length() > resultString.length()){
                    resultString = tempString;
                }
                tempString = "";
            } else {
                tempString = tempString+text.charAt(idx);
            }
            // if(tempCharValue == 44 || tempCharValue == 32){

            // }

        }

        if(tempString.length() > resultString.length()){
            resultString = tempString;
        }

        return resultString;

    }

    public static void main(String[] args) {
        System.out.println("The value should be steady and the actual value is: " + new LongestWord().solution("Ready, steady, go!"));
        System.out.println("The value should be steady and the actual value is: " + new LongestWord().solution("Ready[[[, steady, go!"));
        System.out.println("The value should be AA and the actual value is: " + new LongestWord().solution("A!! AA[]z"));
    }
}
