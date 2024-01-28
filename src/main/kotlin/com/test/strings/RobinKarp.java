package com.test.strings;

public class RobinKarp {
    public static int rabinKarp(String text, String pattern) {
        if (pattern.length() > text.length()) {
            return -1; // s is not a substring of t.
        }
        System.out.println("text is " + text + " pattern is " + pattern);
        System.out.println("text.length() is " + text.length() + " pattern.length() is " + pattern.length());
        final int BASE = 26;
        int tHash = 0, sHash = 0; // Hash codes for the substring of t and s.
        int powerS = 1; // Base value of power S.
        for (int idx = 0; idx < pattern.length(); idx++) {
            powerS = idx > 0 ? powerS * BASE : 1;
            tHash = tHash * BASE + text.charAt(idx);
            sHash = sHash * BASE + pattern.charAt(idx);
        }

        if (tHash == sHash && text.substring(0,  pattern.length()).equals(pattern)) {
            return 0; // Found a match.
        }
        System.out.println("tHash is " + tHash + " sHash is " + sHash);
        for (int idx = pattern.length(); idx < text.length(); idx++) {
            // Checks the two substrings are actually equal or not, to protect
            // against hash collision.
            if (tHash == sHash && text.substring(idx - pattern.length(), idx).equals(pattern)) {
                return idx - pattern.length(); // Found a match.
            }

        // Uses rolling hash to compute the new hash code.
            System.out.println("Removed text is " + text.charAt(idx - pattern.length())
                    + " added text is "+text.charAt(idx) + " idx is " + idx);
            tHash -= text.charAt(idx - pattern.length()) * powerS;
            tHash = tHash * BASE + text.charAt(idx);
            System.out.println("tHash is "+ tHash + " sHash is " + sHash);
            System.out.println(" text.substring(idx - pattern.length(), idx) is "
                    + text.substring(idx - pattern.length(), idx));

        }


        System.out.println("text.substring(text.length() - pattern.length()) is "
                + text.substring(text.length() - pattern.length()));

        // Tries to match s and t.substring(t.length() - s.lengthO).
        if (tHash == sHash && text.substring(text.length() - pattern.length()).equals(pattern)) {
            return text.length() - pattern.length();
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("RobinKarp.rabinKarp(\"GACGCCA\",\"CGC\") should be 2 and result is "
                + RobinKarp.rabinKarp("GACGCCA", "CGC"));

        System.out.println("RobinKarp.rabinKarp(\"GACGCCA\",\"CCA\") should be 4 and result is "
                + RobinKarp.rabinKarp("GACGCCA", "CCA"));
    }

}
