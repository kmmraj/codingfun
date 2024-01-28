package com.test.strings;

import java.util.Arrays;

public class StringLibsExample {

    public static void main(String[] args) {
        //The key methods on strings are
        // charAt(1),
        String exampleOne = "Hello World";
        System.out.println("exampleOne.charAt(0) = " + exampleOne.charAt(0));
        System.out.println("exampleOne.charAt(1) = " + exampleOne.charAt(1));

        // compareTo(“foo”),
        String exampleTwo = "foo";
        System.out.println("exampleOne.compareTo(exampleTwo) = " + exampleOne.compareTo(exampleTwo));
        System.out.println("exampleTwo.compareTo(exampleOne) = " + exampleTwo.compareTo(exampleOne));
        String exampleThree = "foo";
        System.out.println("exampleTwo.compareTo(exampleThree) = " + exampleTwo.compareTo(exampleThree));
        String exampleFour = "food";
        System.out.println("exampleTwo.compareTo(exampleFour) = " + exampleTwo.compareTo(exampleFour));
        String exampleFive = "foods";
        System.out.println("exampleTwo.compareTo(exampleFive) = " + exampleTwo.compareTo(exampleFive));
        String exampleSix = "foods are good";
        System.out.println("exampleTwo.compareTo(exampleSix) = " + exampleTwo.compareTo(exampleSix));
        // compareToIgnoreCase(“foo”),
        String exampleSeven = "FOO";
        System.out.println("exampleTwo.compareToIgnoreCase(exampleSeven) = " + exampleTwo.compareToIgnoreCase(exampleSeven));
        // concat(“bar”) (returns a new string —does not update the invoking string),
        System.out.println("exampleTwo.concat(exampleSeven) = " + exampleTwo.concat(exampleSeven));
        // contains(“aba”),
        String exampleEight = "aba";
        System.out.println("exampleTwo.contains(exampleEight) = " + exampleTwo.contains(exampleEight));
        // endsWith(“YZ”),
        String exampleNine = "YZ";
        System.out.println("exampleTwo.endsWith(exampleNine) = " + exampleTwo.endsWith(exampleNine));
        System.out.println("\"fooYZ\".endsWith(\"YZ\") = " + "fooYZ".endsWith("YZ"));
        // indexOf(“needle”),
        System.out.println("\"One needle is \".indexOf(exampleEleven) = " + "One needle is ".indexOf("needle"));
        // indexOf(“needle” , 12)
        System.out.println("\"One needle is not enough five needles are needed \".indexOf(\"needle\",5) = "
                + "One needle is not enough five needles are needed ".indexOf("needle", 5));
        // indexOff(’A’),
        System.out.println("\"One needle is not enough five needles are needed \".indexOf('a') = "
                + "One needle is not enough five needles are needed ".indexOf('a'));
        // indexOff(’B’, offset),
        System.out.println("\"One needle is not enough five needles are needed \".indexOf('e',10) = "
                + "One needle is not enough five needles are needed ".indexOf('e', 10));
        // lastlndexOf(“needle”),
        System.out.println("\"One needle is not enough five needles are needed \".lastIndexOf(\"needle\") = "
                + "One needle is not enough five needles are needed ".lastIndexOf("needle"));
        // length(),
        System.out.println("\"One needle is not enough five needles are needed \".length() = "
                + "One needle is not enough five needles are needed ".length());
        // replace(’a' ’A’),
        System.out.println("\"One needle is not enough five needles are needed \".replace('a','A') = "
                + "One needle is not enough five needles are needed ".replace('a', 'A'));
        // replace(“a” “ABC”),
        System.out.println("\"One needle is not enough five needles are needed \".replace(\"a\",\"ABC\") = "
                + "One needle is not enough five needles are needed ".replace("a", "ABC"));
        // “foo::bar::abc”.split(“::”),
        System.out.println("\"foo::bar::abc\".split(\"::\") = " + Arrays.toString("foo::bar::abc".split("::")));
        // startsWith(prefix),
        System.out.println("\"foo::bar::abc\".startsWith(\"foo\") = " + "foo::bar::abc".startsWith("foo"));
        // startsWith(“www” , “http://”.lengthO),
        System.out.println("\"http://www.google.com\".startsWith(\"www\", \"http://\".length()) = "
                + "http://www.google.com".startsWith("www", "http://".length()));

        // substring(l),
        System.out.println("\"http://www.google.com\".substring(7) = "
                + "http://www.google.com".substring(7));
        // substring(l,5),
        System.out.println("\"http://www.google.com\".substring(7,10) = "
                + "http://www.google.com".substring(7, 10));
        // toCharArray(),
        System.out.println("\"http://www.google.com\".toCharArray() = "
                + Arrays.toString("http://www.google.com".toCharArray()));
        // toLowerCase(),
        System.out.println("\"http://www.GOOGLE.com\".toLowerCase() = "
                + "http://www.GOOGLE.com".toLowerCase());

        // trim().
        System.out.println("\"   http://www.GOOGLE.com   \".trim() = "
                + "   http://www.GOOGLE.com   ".trim());
        //- The substring () method is particularly important, and also easy to get wrong,
        // since it has two variants: one takes a start index, and returns a suffix (easily confused with prefix)
        // and the other takes a start
        // and end index (the returned substring includes the character at start but not the character at end).

        System.out.println("\"http://www.google.com\".substring(7) = "
                + "http://www.google.com".substring(7));
        System.out.println("\"http://www.google.com\".substring(7,10) = "
                + "http://www.google.com".substring(7, 10));

        // The key methods on StringBuilder are
        // append(“foo”),
        StringBuilder sb = new StringBuilder();
        sb.append("foo");
        System.out.println("sb = " + sb);
        // Other StringBuilder methods include
        // reverse(),
        System.out.println("sb.reverse() = " + sb.reverse());
        // insert(0, “bar”),
        System.out.println("sb.insert(0, \"bar\") = " + sb.insert(0, "bar"));
        // delete(0, 3),
        System.out.println("sb.delete(0, 3) = " + sb.delete(0, 3));
        // deleteCharAt(0),
        System.out.println("sb.deleteCharAt(0) = " + sb.deleteCharAt(0));
        // replace(0, 3, “abc”),
        System.out.println("sb.replace(0, 3, \"abc\") = " + sb.replace(0, 3, "abc"));

        // StringBuilder is not thread-safe, but StringBuffer is.
        // StringBuilder is faster than StringBuffer.
        // StringBuffer is thread-safe.
        // StringBuffer is slower than StringBuilder.
        // StringBuffer is mutable.
        // StringBuilder is mutable.
        // StringBuffer is synchronized.
        // StringBuilder is not synchronized.
        // Key methods of StringBuffers are append(), insert(), delete(), deleteCharAt(), replace(), reverse(), substring(), and capacity().

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("foo");
        System.out.println("stringBuffer = " + stringBuffer);
        // Other StringBuffer methods include
        // reverse(),
        System.out.println("stringBuffer.reverse() = " + stringBuffer.reverse());
        // insert(0, “bar”),
        System.out.println("stringBuffer.insert(0, \"bar\") = " + stringBuffer.insert(0, "bar"));
        // delete(0, 3),
        System.out.println("stringBuffer.delete(0, 3) = " + stringBuffer.delete(0, 3));

        System.out.println("------------------------------------");
        System.out.println("String to int conversion of 1234 = " + new StringLibsExample().stringToInt("1234"));
        System.out.println("String to int conversion of -1234 = " + new StringLibsExample().stringToInt("-1234"));

        System.out.println("int to String conversion of 1234 = " + new StringLibsExample().intToString(1234));
        System.out.println("int to String conversion of -1234 = " + new StringLibsExample().intToString(-1234));

    }


    private Integer stringToInt(String str) {
        int intValue = 0;
        int startIdx = str.charAt(0) == '-' ? 1 : 0;
        for (int idx = startIdx; idx < str.length(); idx++) {
            int val = str.charAt(idx) - '0';
            intValue = intValue * 10 + val;
        }
        return startIdx == 0 ? intValue : (intValue * -1);
    }

    private String intToString(int intVal) {
        boolean isNegative = intVal <= 0;
        StringBuilder sb = new StringBuilder();
        intVal = Math.abs(intVal);
        while (intVal != 0) {
            int remainder = intVal % 10;
            sb.append(remainder);
            intVal = intVal / 10;
        }
        if(isNegative){
            sb.append("-");
        }
        return sb.reverse().toString();
    }
}
