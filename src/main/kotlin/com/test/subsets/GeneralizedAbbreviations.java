// https://www.geeksforgeeks.org/alphanumeric-abbreviations-of-a-string/
package com.test.subsets;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviations {

   // List<String> listOfAbbreviation;

    private List<String> getComb(String str) {

        return generateAbbreviation(str, 0, str.length(), "",new ArrayList<>());
    }

    private List<String> generateAbbreviation(String str, int index, int maxIndex, String workingString,List<String> listOfAbbreviation) {
        // BC
        if (index == maxIndex) {
            listOfAbbreviation.add(workingString);
            return listOfAbbreviation;
        }

        // Hypothesis

        // Add and call the flow
        workingString = workingString + str.charAt(index);
        generateAbbreviation(str, index + 1, maxIndex, workingString,listOfAbbreviation);

        // Remove and call the flow

        workingString = workingString.substring(0, workingString.length() - 1);

        int count = 1;
        if (!workingString.isEmpty()
                && workingString.charAt(workingString.length() - 1) >= '0'
                && workingString.charAt(workingString.length() - 1) <= '9') {
            count = count + (workingString.charAt(workingString.length() - 1) - '0');
            // Remove the last digit
            workingString = workingString.substring(0, workingString.length() - 1);

        }
        workingString = workingString + (char) (count + '0');


        generateAbbreviation(str, index + 1, maxIndex, workingString,listOfAbbreviation);
        return listOfAbbreviation;
    }


    public static void main(String[] args) {

        String str = "GFG";
        GeneralizedAbbreviations generalizedAbbreviations = new GeneralizedAbbreviations();
//        generalizedAbbreviations.listOfAbbreviation = new ArrayList<>();
//        generalizedAbbreviations.listOfAbbreviation = generalizedAbbreviations.getComb(str);
//        for (String abbreviation : generalizedAbbreviations.listOfAbbreviation) {
//            System.out.print(abbreviation + " , ");
//        }
        List<String> listOfAbbreviation = generalizedAbbreviations.getComb(str);
        for (String abbreviation : listOfAbbreviation) {
            System.out.print(abbreviation + " , ");
        }
    }


}
