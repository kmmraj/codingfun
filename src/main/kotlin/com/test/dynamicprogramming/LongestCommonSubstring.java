package com.test.dynamicprogramming;

public class LongestCommonSubstring {

    public int longestCommonSubstring(String text1, String text2) {

        int index1 = text1.length();
        int index2 = text2.length();
        int count  = 0;

        return solveIt(text1,text2,index1,index2,count);
    }

    private int solveIt(String text1, String text2, int index1, int index2, int count) {
        // BC
        if(index1 == 0 || index2 == 0)
            return count;

        // Hypo & Choice Decisions
//        if(text1.charAt(index1-1) == text2.charAt(index2-1)){
//            count = solveIt(text1,text2,index1-1,index2-1,count+1);
//        } else {
//            count = Math.max(count, Math.max(
//                    solveIt(text1,text2,index1-1,index2,0),
//                    solveIt(text1,text2,index1,index2-1,0)
//            ));
//        }

        if(text1.charAt(index1-1) == text2.charAt(index2-1)){
            return solveIt(text1,text2,index1-1,index2-1,count+1);
        } else {
            return Math.max(count, Math.max(
                    solveIt(text1,text2,index1-1,index2,0),
                    solveIt(text1,text2,index1,index2-1,0)
            ));
        }


        //return count;
    }

    public static void main(String[] args) {
        String text1 = "abcdxyz";
        String text2 = "xyzabcd";
        LongestCommonSubstring longestCommonSubstring = new LongestCommonSubstring();
        System.out.println(longestCommonSubstring.longestCommonSubstring(text1,text2));
        String text3 = "zxabcdezy";
        String text4 = "yzabcdezx";
        System.out.println(longestCommonSubstring.longestCommonSubstring(text3,text4));
    }
}
