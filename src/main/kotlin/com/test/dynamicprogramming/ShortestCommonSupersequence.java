package com.test.dynamicprogramming;

public class ShortestCommonSupersequence {

    int[][] dpTopDown;

    int shortestSuperSequence(String text1, String text2){
        int t1Length = text1.length();
        int t2Length = text2.length();

        dpTopDown = new int[t1Length+1][t2Length+1];

        initTopDownMatrix(t1Length, t2Length);

        printTopDown(dpTopDown,text1,text2,t1Length,t2Length);

        for (int idxI = 1; idxI < t1Length+1; idxI++) {
            for (int idxJ = 1; idxJ < t2Length+1; idxJ++) {
                if(text1.charAt(idxI-1) == text2.charAt(idxJ-1)){
                    dpTopDown[idxI][idxJ] = 1+ dpTopDown[idxI-1][idxJ-1];
                } else {
                    dpTopDown[idxI][idxJ] = Math.max(dpTopDown[idxI-1][idxJ],dpTopDown[idxI][idxJ-1]);
                }
            }
        }

        printTopDown(dpTopDown,text1,text2,t1Length,t2Length);

        return t1Length+t2Length-dpTopDown[t1Length][t2Length];
    }

    public String shortestCommonSupersequence(String str1, String str2) {

        shortestSuperSequence(str1,str2);

        int t1Length = str1.length();
        int t2Length = str2.length();
        String scs = "";

        while (t1Length  >  0 &&  t2Length >0){
            if(str1.charAt(t1Length-1) == str2.charAt(t2Length-1)){
                scs = scs+str1.charAt(t1Length-1);
                t1Length--;
                t2Length--;
            } else {
                if(dpTopDown[t1Length-1][t2Length] > dpTopDown[t1Length][t2Length-1]){
                    scs = scs+str1.charAt(t1Length-1);
                    t1Length--;
                } else {
                    scs = scs+str2.charAt(t2Length-1);
                    t2Length--;
                }
            }
        }

        while (t1Length  >  0){
            scs = scs+str1.charAt(t1Length-1);
            t1Length--;
        }

        while (t2Length  >  0){
            scs = scs+str2.charAt(t2Length-1);
            t2Length--;
        }
        scs = new StringBuilder(scs).reverse().toString();
        return scs;
    }

    private void initTopDownMatrix(int t1Length, int t2Length) {
        for (int idxI = 0; idxI < t1Length+1; idxI++) {
            for (int idxJ = 0; idxJ < t2Length+1; idxJ++) {
                if(idxI==0 || idxJ == 0){
                    dpTopDown[idxI][idxJ] =0;
                }
            }
        }
    }

    private void printTopDown(int[][] dpTopDown, String text1, String text2, int t1Length, int t2Length) {
        for (int idxI = 0; idxI < t1Length+1; idxI++) {
            for (int idxJ = 0; idxJ < t2Length+1; idxJ++) {
                System.out.printf("%2d, ",dpTopDown[t1Length][t2Length]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ShortestCommonSupersequence supersequence = new ShortestCommonSupersequence();
        String text1  = "AGGTAB";
        String text2 = "GXTXAYB";
        System.out.println(supersequence.shortestSuperSequence(text1,text2));
        System.out.println(supersequence.shortestCommonSupersequence(text1,text2));
    }
}
