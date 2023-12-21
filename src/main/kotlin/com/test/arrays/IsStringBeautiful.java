package com.test.arrays;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
//A string is said to be beautiful if each letter in the string appears at most as many times as the previous letter
// in the alphabet within the string; ie: b occurs no more times than a; c occurs no more times than b; etc.
// Note that letter a has no previous letter.
//
//Given a string, check whether it is beautiful.
//
//Example
//
//For inputString = "bbbaacdafe", the output should be solution(inputString) = true.
//
//This string contains 3 as, 3 bs, 1 c, 1 d, 1 e, and 1 f (and 0 of every other letter), so since there aren't
// any letters that appear more frequently than the previous letter, this string qualifies as beautiful.
//
//For inputString = "aabbb", the output should be solution(inputString) = false.
//
//Since there are more bs than as, this string is not beautiful.
//
//For inputString = "bbc", the output should be solution(inputString) = false.
//
//Although there are more bs than cs, this string is not beautiful because there are no as, so therefore
// there are more bs than as.
//
//Input/Output
//
//[execution time limit] 3 seconds (java)
//
//[memory limit] 1 GB
//
//[input] string inputString
//
//A string of lowercase English letters.
//
//Guaranteed constraints:
//3 ≤ inputString.length ≤ 50.
//
//[output] boolean
//
//Return true if the string is beautiful, false otherwise.
public class IsStringBeautiful {



    boolean solution(String inputString) {
        Map<Character,Integer> charMap = new TreeMap<>();
        char[] charArray = inputString.toCharArray();
        for(int index=0; index < charArray.length; index++) {
            if(charMap.containsKey(charArray[index])){
                int tempValue = charMap.get(charArray[index]);
                charMap.put(charArray[index], tempValue+1);
            } else {
                charMap.put(charArray[index], 1);
            }
        }

        Set<Map.Entry<Character, Integer>> entrySet = charMap.entrySet();
        int prevVal=Integer.MAX_VALUE, currVal;
        int prevKey = 96, currKey;


        for(Map.Entry<Character, Integer> entry: entrySet) {
            currVal =  entry.getValue();
            currKey =  entry.getKey().charValue();

            // System.out.println(" Key is " + entry.getKey() + " Value is " + entry.getValue());
            // System.out.println(" currVal is " + currVal + " prevVal is " + prevVal);
            //  System.out.println(" currKey is " + currKey + " prevKey is " + prevKey);
            if(currVal > prevVal || currKey != prevKey+1){
                return false;
            }
            prevVal = currVal;
            prevKey = currKey;

        }

        return true;

    }

}
