package com.test.dynamicprogramming;

public class ConvertStringWithMinInsertAndDelete {

    private int[] getMinDelAndInsert(String text1, String text2) {
       int lcs =  solveItDp(text1,text2,text1.length(),text2.length());
       int noOfDeletes = text1.length() - lcs;
       int noOfInserts = text2.length() - lcs;
       return new int[] {noOfDeletes,noOfInserts};
    }

    private int solveItDp(String text1, String text2, int indexI, int indexJ) {
        int[][] dpTopDown = new int[indexI+1][indexJ+1];

        initDp(indexI, indexJ, dpTopDown);
        printDp(dpTopDown,indexI,indexJ);

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
        printDp(dpTopDown,indexI,indexJ);
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
        String text1 = "heap";
        String text2 = "pea";
        ConvertStringWithMinInsertAndDelete minInsertAndDelete = new ConvertStringWithMinInsertAndDelete();
        int[] minInsertAndDeletes = minInsertAndDelete.getMinDelAndInsert(text1,text2);
        System.out.println("No of Delete is: " + minInsertAndDeletes[0] + " and Insert is: "+minInsertAndDeletes[1]);
    }
}
