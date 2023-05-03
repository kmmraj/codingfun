package com.test.recursion;

public class TowerOfHanoi {



    private static void solveTH(int size, String source, String helper, String destination, int moveCount) {

        // BC
        if(size == 1){
            moveCount++;
            System.out.printf("Step %d : Moving disk %d from %s to %s%n", moveCount,size,source,destination);
            return;
        }

        // Hypothesis
        solveTH(size-1,source,destination,helper,moveCount); // source --> helper

        //Induction
        moveCount++;
        System.out.printf("Step %d : Moving disk %d from %s to %s%n", moveCount,size,source,destination);
        solveTH(size-1,helper,source,destination,moveCount); // helper --> destination

    }

    public static void main(String[] args) {
        solveTH(3,"S","H","D",0);

    }
}
