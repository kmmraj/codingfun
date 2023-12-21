package com.test.strings;
//Check if the given string is a correct time representation of the 24-hour clock.
//
//Example
//
//For time = "13:58", the output should be
//solution(time) = true;
//For time = "25:51", the output should be
//solution(time) = false;
//For time = "02:76", the output should be
//solution(time) = false.
//Input/Output
//
//[execution time limit] 3 seconds (java)
//
//[memory limit] 1 GB
//
//[input] string time
//
//A string representing time in HH:MM format. It is guaranteed that the first two characters,
// as well as the last two characters, are digits.
//
//[output] boolean
//
//true if the given representation is correct, false otherwise.
public class ValidTime {
    boolean solution(String time) {

        String regex = "^([0-9]{2}[::]){1}([0-9]{2})$";
        if(!time.matches(regex)){
            return false;
        }

        String[] timeArray = time.split(":");

        if((Integer.parseInt(timeArray[0]) > 23) || (Integer.parseInt(timeArray[0]) < 0) ){
            return false;
        }

        if((Integer.parseInt(timeArray[1]) > 59) || (Integer.parseInt(timeArray[1]) < 0) ){
            return false;
        }
        return true;

    }

    public static void main(String[] args) {
        ValidTime validTime = new ValidTime();
        System.out.println("The value should be true and the actual value is: " + validTime.solution("13:58"));
        System.out.println("The value should be false and the actual value is: " + validTime.solution("25:51"));
        System.out.println("The value should be false and the actual value is: " + validTime.solution("02:76"));
    }
}
