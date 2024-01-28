package com.test.strings;
// https://leetcode.com/problems/restore-ip-addresses/description/

/**
 * 93. Restore IP Addresses
 * A valid IP address consists of exactly four integers separated by single dots.
 * Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.
 *
 * For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses,
 * but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
 * Given a string s containing only digits,
 * return all possible valid IP addresses that can be formed by inserting dots into s.
 * You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.
 *
 *
 *
 * Example 1:
 * Input: s = "25525511135"
 * Output: ["255.255.11.135","255.255.111.35"]
 *
 * Example 2:
 * Input: s = "0000"
 * Output: ["0.0.0.0"]
 *
 * Example 3:
 * Input: s = "101023"
 * Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 20
 * s consists of digits only.
 */

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {
    List<String> resultList = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        //System.out.println("Input string is " + s);
        // solveIt(s, 0, "", 0);
        solveIt(s);
        return resultList;
    }

    private void solveIt(String ipAdd) {
        for (int idx = 1; idx < 4 && idx < ipAdd.length(); idx++) {
            for (int jdx = idx+1; jdx < idx + 4 && jdx < ipAdd.length(); jdx++) {
                for (int kdx = jdx+1; kdx < jdx + 4 && kdx < ipAdd.length(); kdx++) {
                    String seg1 = ipAdd.substring(0, idx),
                            seg2 = ipAdd.substring(idx, jdx),
                            seg3 = ipAdd.substring(jdx, kdx),
                            seg4 = ipAdd.substring(kdx);
                    System.out.println("seg1 is " + seg1 + " seg2 is " + seg2 + " seg3 is " + seg3 + " seg4 is " + seg4);
                    if (valid(seg1) && valid(seg2) && valid(seg3) && valid(seg4)) {
                        resultList.add(seg1 + "." + seg2 + "." + seg3 + "." + seg4);
                    }
                }

            }
        }
    }

    private boolean valid(String segment){
        if(segment.isEmpty()
                || (segment.charAt(0) == '0' && segment.length()>1)
                || segment.length() > 3
                || Integer.parseInt(segment) > 255){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        RestoreIPAddress restoreIPAddress = new RestoreIPAddress();
        System.out.println("expected is [ \"255.255.11.135\",\"255.255.111.35\"], actual is "
                + restoreIPAddress.restoreIpAddresses("25525511135"));
    }
}
