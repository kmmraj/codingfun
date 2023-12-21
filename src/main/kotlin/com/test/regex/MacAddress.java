package com.test.regex;

public class MacAddress {
    //A media access control address (MAC address) is a unique identifier assigned to network interfaces for communications on the physical network segment.
    //
    //The standard (IEEE 802) format for printing MAC-48 addresses in human-friendly form is six groups of two hexadecimal digits (0 to 9 or A to F), separated by hyphens (e.g. 01-23-45-67-89-AB).
    //
    //Your task is to check by given string inputString whether it corresponds to MAC-48 address or not.
    //
    //Example
    //
    //For inputString = "00-1B-63-84-45-E6", the output should be
    //solution(inputString) = true;
    //For inputString = "Z1-1B-63-84-45-E6", the output should be
    //solution(inputString) = false;
    //For inputString = "not a MAC-48 address", the output should be
    //solution(inputString) = false.
    //Input/Output
    //
    //[execution time limit] 3 seconds (java)
    //
    //[memory limit] 1 GB
    //
    //[input] string inputString
    //
    //Guaranteed constraints:
    //15 ≤ inputString.length ≤ 20.
    //
    //[output] boolean
    //
    //true if inputString corresponds to MAC-48 address naming rules, false otherwise.

    boolean solution(String inputString) {
        String regex = "^([0-9A-F]{2}[:-]){5}([0-9A-F]{2})$";
        return inputString.matches(regex);
    }

    public static void main(String[] args) {
        MacAddress macAddress = new MacAddress();
        System.out.println("\"00-1B-63-84-45-E6 is a mac add " + macAddress.solution("00-1B-63-84-45-E6"));
        System.out.println("\"Z1-1B-63-84-45-E6 is a mac add " + macAddress.solution("Z1-1B-63-84-45-E6"));
        System.out.println("\"not a MAC-48 address is a mac add " + macAddress.solution("not a MAC-48 address"));


    }
}
