package com.test.dynamicprogramming;

public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {

        String sReverse  = new StringBuilder(s).reverse().toString();
        return solveItDp(s,sReverse ,s.length(),s.length());
    }

    private int solveItDp(String text1, String text2, int indexI, int indexJ) {
        int[][] dpTopDown = new int[indexI+1][indexJ+1];

        initDp(indexI, indexJ, dpTopDown);
      //  printDp(dpTopDown,indexI,indexJ);

        for (int idxI = 1; idxI < indexI+1; idxI++) {
            for (int idxJ = 1; idxJ < indexJ+1; idxJ++) {
                if(text1.charAt(idxI-1) == text2.charAt(idxJ-1)){
                    dpTopDown[idxI][idxJ] = 1+dpTopDown[idxI-1][idxJ-1];
                } else {
                    dpTopDown[idxI][idxJ] = Math.max(dpTopDown[idxI-1][idxJ],
                            dpTopDown[idxI][idxJ-1]);
                }
            }
        }
    //    printDp(dpTopDown,indexI,indexJ);
        return dpTopDown[indexI][indexJ];
    }

    private void printDp(int[][] dp,int indexI, int indexJ) {
        System.out.println("--------XXXXX-------------");
        for (int idxI = 0; idxI < indexI+1; idxI++) {
            for (int idxJ = 0; idxJ < indexJ+1; idxJ++) {
                System.out.printf("%2d",dp[idxI][idxJ]);
            }
            System.out.println();
        }
        System.out.println("--------YYYYY-------------");
    }

    private void initDp(int indexI, int indexJ, int[][] dpTopDown) {
        for (int idxI = 0; idxI < indexI+1; idxI++) {
            for (int idxJ = 0; idxJ < indexJ+1; idxJ++) {
                if(idxI ==0 || idxJ ==0){
                    dpTopDown[idxI][idxJ] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence palindromicSubsequence = new LongestPalindromicSubsequence();
        String s = "cbbd";
        System.out.println(palindromicSubsequence.longestPalindromeSubseq(s));
        System.out.println(LongestPalindromicSubsequence.solveItRecursively("madeaam"));
        System.out.println(LongestPalindromicSubsequence.findLPSLength("madeaam"));
    }

    private static int solveItRecursively(String text) {
        return solveItRecursively(text, 0,text.length()-1);
    }

    private static int solveItRecursively(String text, int leftIndex, int rightIndex) {
        // BC
        if(leftIndex == text.length() || rightIndex == -1){ // check leftIndex == rightIndex
            return 0;
        }
//        if(leftIndex ==  rightIndex ){ // check leftIndex == rightIndex -- Does not work (rightfully)
//            return 0;
//        }

        // Induction
        if(text.charAt(leftIndex) == text.charAt(rightIndex)){
            return 1 + solveItRecursively(text,leftIndex+1,rightIndex-1); // TODO : Check 2+ ?
        }

        // Hypo
        int includeText = solveItRecursively(text,leftIndex,rightIndex-1);
        int skipText = solveItRecursively(text,leftIndex+1,rightIndex);

        return Math.max(includeText,skipText);

    }


    private static int findLPSLength(String st, int startIndex, int endIndex) { // More efficient
        if (startIndex > endIndex) {
            return 0;
        }
        if (startIndex == endIndex) {
            return 1;
        }

        int count1 = 0;
        if (st.charAt(startIndex) == st.charAt(endIndex)) {
            count1 = 2 + findLPSLength(st, startIndex+1, endIndex-1);
        }
        int count2 = findLPSLength(st, startIndex+1, endIndex);
        int count3 = findLPSLength(st, startIndex, endIndex-1);

        return Math.max(count1, Math.max(count2, count3));
    }

    public static int findLPSLength(String st) {
        return findLPSLength(st, 0, st.length()-1);
    }
}
