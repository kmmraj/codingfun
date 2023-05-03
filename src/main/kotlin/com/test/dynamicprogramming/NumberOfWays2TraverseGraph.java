package com.test.dynamicprogramming;

public class NumberOfWays2TraverseGraph {
    public int numberOfWaysToTraverseGraph(int width, int height) {
       //BC
        if(width==1 || height==1){
           return 1;
       }

        // Hypo & Induction
        return numberOfWaysToTraverseGraph(width-1,height)
                + numberOfWaysToTraverseGraph(width,height-1);
    }

    public int numberOfWaysToTraverseGraphDP(int width, int height) {

        int[][] dpM = new int[height+1][width+1];

        for (int widthIdx = 1; widthIdx < width+1; widthIdx++) {
            for (int heightIdx = 1; heightIdx < height+1; heightIdx++) {
               //BC
                if(widthIdx==1 || heightIdx==1){
                    dpM[heightIdx][widthIdx]= 1;
                } else {
                    // Induction
                    int downWays = dpM[height-1][width];
                    int sideWays = dpM[height][width-1];;
                    dpM[heightIdx][widthIdx]= downWays+sideWays;
                }
            }
        }
        return dpM[height][width];

    }

    public static void main(String[] args) {
        System.out.println( new NumberOfWays2TraverseGraph().numberOfWaysToTraverseGraph(2,3));
        System.out.println( new NumberOfWays2TraverseGraph().numberOfWaysToTraverseGraphDP(2,3));
    }
}
