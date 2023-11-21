package com.test.misc;
//An IP address is a numerical label assigned to each device (e.g., computer, printer) participating in a computer network that uses the Internet Protocol for communication. There are two versions of the Internet protocol, and thus two versions of addresses. One of them is the IPv4 address.
//
//Given a string, find out if it satisfies the IPv4 address naming rules.
//
//Example
//
//For inputString = "172.16.254.1", the output should be
//solution(inputString) = true;
//
//For inputString = "172.316.254.1", the output should be
//solution(inputString) = false.
//
//316 is not in range [0, 255].
//
//For inputString = ".254.255.0", the output should be
//solution(inputString) = false.
//
//There is no first number.
//
//Input/Output
//
//[execution time limit] 3 seconds (java)
//
//[memory limit] 1 GB
//
//[input] string inputString
//
//A string consisting of digits, full stops and lowercase English letters.
//
//Guaranteed constraints:
//1 ≤ inputString.length ≤ 30.
//
//[output] boolean
//
//true if inputString satisfies the IPv4 address naming rules, false otherwise.
public class IsValidIPV4Address {

    boolean solution(String inputString) {
        String[] ipArray = inputString.split("[.]");
        System.out.println("ipArray.length  " + ipArray.length);
        if(ipArray.length != 4){
            return false;
        }
        for (String ip : ipArray) {
            System.out.println(ip + " : ");
            System.out.println("ip.length() " + " = " + ip.length());
            if(ip.startsWith("0") && ip.length() > 1){
                return false;
            }
            int tempIp;
            try{
                tempIp = Integer.valueOf(ip);
            } catch(NumberFormatException ex){
                return false;
            }
            System.out.println("tempIp  " + tempIp);
            if(tempIp<0 || tempIp >255){
                return false;
            }
        }
        return true;

    }

//    boolean solutionWithRegEx(String inputString) {
//
//    }

    public static void main(String[] args) {
        IsValidIPV4Address isValidIPV4Address = new IsValidIPV4Address();
        System.out.println("172.16.254.1 " +isValidIPV4Address.solution("172.16.254.1"));
        System.out.println("172.316.254.1 " +isValidIPV4Address.solution("172.316.254.1"));
        System.out.println(".254.255.0 " +isValidIPV4Address.solution(".254.255.0"));
        System.out.println("1.1.1.1a " +isValidIPV4Address.solution("1.1.1.1a"));
        System.out.println("1 " +isValidIPV4Address.solution("1"));

    }
}
