package com.test.dynamicprogramming;

public class LevenshteinDistance {

    public static int levenshteinDistance(String str1, String str2) {

        int dpM[][] = new int [str1.length()+1][str2.length()+1];
        // BC
        for (int idx = 0; idx < str1.length()+1; idx++) {
            for (int jdx = 0; jdx < str2.length()+1; jdx++) {
               dpM[idx][jdx] = jdx;
            }
            dpM[idx][0] = idx;
        }

        // Hypo & Induction

        for (int idx = 1; idx < str1.length()+1; idx++) {
            for (int jdx = 1; jdx < str2.length()+1; jdx++) {

                if(str2.charAt(jdx-1) == str1.charAt(idx-1)){
                    dpM[idx][jdx] = dpM[idx-1][jdx-1];
                } else {
                    dpM[idx][jdx] = 1+ Math.min(dpM[idx-1][jdx-1], Math.min(dpM[idx][jdx-1],dpM[idx-1][jdx]));
                }
            }
        }
        return dpM[str1.length()][str2.length()];
    }

    public static void main(String[] args) {
        TestCase1();
    }


    public static void TestCase1() {
        System.out.println(LevenshteinDistance.levenshteinDistance("abc", "yabd") == 2);
    }
}
