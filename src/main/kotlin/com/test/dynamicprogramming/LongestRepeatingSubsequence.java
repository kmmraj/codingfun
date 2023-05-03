package com.test.dynamicprogramming;

public class LongestRepeatingSubsequence {


    private  int findLongestRepeatingSubSeq(String str) {
        String text1 = str;
        String text2 = str;
        int [][] dpTopDown = new int[text1.length()+1][text2.length()+1];

        initDpTopDown(dpTopDown,text1.length(),text2.length());

        for (int idx = 1; idx < text1.length()+1 ; idx++) {
            for (int jdx = 1; jdx < text2.length()+1; jdx++) {
               if(text1.charAt(idx-1) == text2.charAt(jdx-1) && idx!=jdx){
                   dpTopDown[idx][jdx] = 1+dpTopDown[idx-1][jdx-1];
               } else {
                   dpTopDown[idx][jdx] = Math.max(dpTopDown[idx-1][jdx],
                           dpTopDown[idx][jdx-1]);
               }
            }
        }
        return dpTopDown[text1.length()][text1.length()];

    }

    private void initDpTopDown(int[][] dpTopDown, int t1Length, int t2Length) {
        for (int idx = 0; idx <t1Length+1 ; idx++) {
            for (int jdx = 0; jdx < t2Length+1; jdx++) {
                if(idx == 0 || jdx==0)
                    dpTopDown[idx][jdx] =0;
            }
        }
    }


    public static void main (String[] args) {
        String str = "aabb";
        LongestRepeatingSubsequence repeatingSubsequence = new LongestRepeatingSubsequence();

        System.out.println("The length of the largest subsequence that"
                +" repeats itself is : "+repeatingSubsequence.findLongestRepeatingSubSeq(str));
    }


}
