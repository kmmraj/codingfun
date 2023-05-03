package com.test.dynamicprogramming;

public class LongCommonSequence1 {

    int[][] dpM;
    int[][] dpTopDown;

    public int longestCommonSubsequence(String text1, String text2) {
        int t1Index=text1.length();
        int t2Index=text2.length();
        dpMemoizationInit(t1Index, t2Index);

//        return solveItRecursivelyWithMemoization(text1,text2, t1Index,t2Index);
        return solveItTopDownDp(text1,text2, t1Index,t2Index);
    }

    private void dpMemoizationInit( int t1Index, int t2Index) {
        this.dpM = new int [t1Index+1] [t2Index+1];

        for (int indexI = 0; indexI < t1Index+1; indexI++) {
            for (int indexJ = 0; indexJ < t2Index+1; indexJ++) {
                this.dpM[indexI][indexJ] = Integer.MIN_VALUE;
            }
        }
    }

    private void topDownDpInit(int t1Index, int t2Index) {
        this.dpTopDown = new int [t1Index+1] [t2Index+1];

        for (int indexI = 0; indexI < t1Index+1; indexI++) {
            for (int indexJ = 0; indexJ < t2Index+1; indexJ++) {
                if(indexI ==0 || indexJ ==0)
                    this.dpTopDown[indexI][indexJ] = 0;
            }
        }
    }

    private int solveItTopDownDp(String text1, String text2, int t1Index, int t2Index) {
        topDownDpInit(t1Index,t2Index);
        printMatrix(this.dpTopDown,t1Index+1,t2Index+1);

        //          x1        x2
        // dp                 a
        //         ------------------
        //  y1     |       |        |
        //         |   #   |   $    |
        //         |       |        |
        //         ------------------
        //  y2     |       |        |   // if (x2 == y2) {
        //    a    |   @   |        |       dp[x2][y2] = 1+ dp[x1][y1]  (#)
        //         |       |        |       } else {
        //         ------------------       dp[x2][y2] = Max( dp[x1][y2], dp[x2][y1] ) (Max of (@,$)
        //                                  }
        for (int indexI = 1; indexI < t1Index+1; indexI++) {
            for (int indexJ = 1; indexJ < t2Index+1; indexJ++) {
                if(text1.charAt(indexI-1) == text2.charAt(indexJ-1)){
                    this.dpTopDown[indexI][indexJ] = 1+ dpTopDown[indexI-1][indexJ-1];
                } else {
                    this.dpTopDown[indexI][indexJ] = Math.max(
                            dpTopDown[indexI][indexJ-1],
                            dpTopDown[indexI-1][indexJ]
                    );
                }

            }
        }
        printMatrix(this.dpTopDown,t1Index+1,t2Index+1);
        return this.dpTopDown[t1Index][t2Index];
    }

    private static void printMatrix(int[][] dp, int xLength, int yLength){
        System.out.println("---------xxx---------------");
        for (int xAx = 0; xAx < xLength; xAx++) {
            for (int yAx = 0; yAx < yLength; yAx++) {
                System.out.printf("%2d, ", dp[xAx][yAx]);
            }
            System.out.println();
        }
        System.out.println("---------xxx---------------");
    }

    private int solveItRecursivelyWithMemoization(String text1, String text2, int t1Index, int t2Index) {
        // BC
        if(t1Index ==0 || t2Index ==0){
            return 0;
        }


        // Hypo + CD

        if(text1.charAt(t1Index-1) == text2.charAt(t2Index-1)){
            if(this.dpM[t1Index][t2Index] == Integer.MIN_VALUE){
                return this.dpM[t1Index][t2Index] = 1+ solveItRecursivelyWithMemoization(text1,text2,t1Index-1,t2Index-1);
            } else {
                System.out.println("Used Memoized");
                return this.dpM[t1Index][t2Index];
            }
        } else {
            if(this.dpM[t1Index][t2Index] == Integer.MIN_VALUE){
                return this.dpM[t1Index][t2Index]= Math.max(solveItRecursivelyWithMemoization(text1,text2,t1Index-1,t2Index),
                        solveItRecursivelyWithMemoization(text1,text2,t1Index,t2Index-1));
            } else {
                System.out.println("Used Memoized");
                return this.dpM[t1Index][t2Index];
            }

        }
    }

    private int solveItRecursively(String text1, String text2, int t1Index, int t2Index) {
        // BC
        if(t1Index ==0 || t2Index ==0){
            return 0;
        }

        // Hypo + CD

        if(text1.charAt(t1Index-1) == text2.charAt(t2Index-1)){
            return 1+ solveItRecursively(text1,text2,t1Index-1,t2Index-1);
        } else {
            return Math.max(solveItRecursively(text1,text2,t1Index-1,t2Index),
                    solveItRecursively(text1,text2,t1Index,t2Index-1));
        }
    }


    public String printCommonSubsequence(String text1, String text2) {
        int t1Index=text1.length();
        int t2Index=text2.length();
       // dpMemoizationInit(t1Index, t2Index);


//        return solveItRecursivelyWithMemoization(text1,text2, t1Index,t2Index);

//        PrintReturn printReturn =  new PrintReturn(0,"");
//        printReturn = solveItRecursivelyPrint(text1,text2, t1Index,t2Index,printReturn);
//        System.out.println(printReturn);
//         return printReturn.workingString.substring(0,printReturn.workingString.length()-1);

        return solveItTopDownPrint(text1,text2,t1Index,t2Index);
    }

    private String solveItTopDownPrint(String text1, String text2, int t1Index, int t2Index){

       topDownDpInit(t1Index,t2Index);
       printMatrix(this.dpTopDown,t1Index+1,t2Index+1);
       for (int indexI = 1; indexI < t1Index+1; indexI++) {
           for (int indexJ = 1; indexJ < t2Index+1; indexJ++) {
               if(text1.charAt(indexI-1) == text2.charAt(indexJ-1)) {
                   this.dpTopDown[indexI][indexJ] = 1+this.dpTopDown[indexI-1][indexJ-1];
                } else {
                    this.dpTopDown[indexI][indexJ] = Math.max(this.dpTopDown[indexI-1][indexJ],
                            this.dpTopDown[indexI][indexJ-1]);
               }
           }
       }
       printMatrix(this.dpTopDown,t1Index+1,t2Index+1);

       String returnLCS ="";
       int totalLCSCount = this.dpTopDown[t1Index][t2Index];
       while (t1Index > 0 && t2Index > 0){
           if(text1.charAt(t1Index-1) == text2.charAt(t2Index-1)){
               returnLCS = text1.charAt(t1Index - 1)+returnLCS;
               t1Index--;
               t2Index--;
           } else {
               if(this.dpTopDown[t1Index][t2Index-1] > this.dpTopDown[t1Index-1][t2Index]){
                   t2Index--;
               } else {
                   t1Index--;
               }
           }
       }

       // System.out.println(returnLCS);

       return returnLCS;
    }

    private PrintReturn solveItRecursivelyPrint(String text1, String text2, int t1Index, int t2Index, PrintReturn printReturn) {
        // BC
        if(t1Index == 0 || t2Index == 0){
            //return new PrintReturn(printReturn.workingCount, printReturn.workingString);
            return printReturn;
        }
        // Hypo  & Induction
        if(text1.charAt(t1Index-1)  == text2.charAt(t2Index-1)){
            printReturn.workingString = printReturn.workingString+text1.charAt(t1Index-1);
            printReturn.workingCount = 1+printReturn.workingCount;
            return solveItRecursivelyPrint(text1,
                    text2,
                    t1Index-1,
                    t2Index-1,
                    printReturn
                    );
        } else {
           PrintReturn option1 =  solveItRecursivelyPrint(text1,
                    text2,
                    t1Index-1,
                    t2Index,
                   printReturn);
            PrintReturn option2 = solveItRecursivelyPrint(text1,
                    text2,
                    t1Index,
                    t2Index-1,
                    printReturn);
           if( option1.workingCount >= option2.workingCount){
               return option1;
           } else {
               return option2;
           }
        }
    }

    private class PrintReturn {
        public int workingCount;
        public String  workingString;

        public PrintReturn(int workingCount, String workingString) {
            this.workingCount = workingCount;
            this.workingString = workingString;
        }

        @Override
        public String toString() {
            return "PrintReturn{" +
                    "workingCount=" + workingCount +
                    ", workingString='" + workingString + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        LongCommonSequence1 commonSequence1 = new LongCommonSequence1();
//        System.out.println(commonSequence1.longestCommonSubsequence(text1,text2));
        String text3 = "mhunuzqrkzsnidwbun", text4 = "szulspmhwpazoxijwbq";
//        System.out.println(commonSequence1.longestCommonSubsequence(text3,text4));
//        System.out.println(commonSequence1.longestCommonSubsequence(text3,text4));

        System.out.println("---- Print --------------------");
        System.out.println(commonSequence1.printCommonSubsequence(text1,text2));
        System.out.println(commonSequence1.printCommonSubsequence(text3,text4));
    }
}
