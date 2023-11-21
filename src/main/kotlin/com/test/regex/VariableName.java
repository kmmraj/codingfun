package com.test.regex;
//Correct variable names consist only of English letters, digits and underscores and they can't start with a digit.
//
//Check if the given string is a correct variable name.
//
//Example
//
//For name = "var_1__Int", the output should be
//solution(name) = true;
//For name = "qq-q", the output should be
//solution(name) = false;
//For name = "2w2", the output should be
//solution(name) = false.

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VariableName {
    boolean solution(String name) {
        // Pattern startsWithNumber = Pattern.compile("^[0-9]");

        return name.matches("^[a-zA-Z_][A-Za-z0-9_]*$");
        // return isMatching("^[^0-9 ][a-zA-Z0-9_]*$",name);// && !isMatching("^[A-Za-z_0-9]",name);

    }

    boolean isMatching(String regex, String text){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        int matches = 0;
        while (matcher.find()) {
            matches++;
        }
        return matches > 0;
    }

    public static void main(String[] args) {
        VariableName variableName = new VariableName();
        System.out.println("var_1__Int is "+ variableName.solution("var_1__Int"));
        System.out.println("qq-q is "+ variableName.solution("qq-q"));
        System.out.println("2w2 is "+ variableName.solution("2w2"));
        System.out.println(" variable is "+ variableName.solution(" variable"));
        System.out.println("va[riable0 is "+ variableName.solution("va[riable0"));
        System.out.println("variable0 is "+ variableName.solution("variable0"));
        System.out.println("a is "+ variableName.solution("a"));
        System.out.println("_Aas_23 is "+ variableName.solution("_Aas_23"));
        System.out.println("a a_2 is "+ variableName.solution("a a_2"));
        System.out.println("0ss is "+ variableName.solution("0ss"));
        System.out.println("a a_2 is "+ variableName.solution("a a_2"));
        System.out.println("ss0 is "+ variableName.solution("ss0"));

      // Character character = Character.valueOf( 65 + '0');
     //  System.out.println("character is "+ character.toString());

    }
}
