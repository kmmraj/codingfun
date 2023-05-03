package com.test.arrays;

public class FindTopTwoScores {

    public static int[] findTopTwoScores(int[] array){
        // TODO
        int firstScore = Integer.MIN_VALUE;
        int secondScore = Integer.MIN_VALUE;

        for(int indx=0; indx<= array.length-1; indx++){
            if(array[indx]> firstScore){
                secondScore = firstScore;
                firstScore = array[indx];
            }
            if(array[indx] < firstScore && array[indx] > secondScore){
                secondScore = array[indx];
            }
        }
        return new int[]{firstScore,secondScore};
    }

    public static void main(String[] args) {
//        int[] array = {1,2,3,4,5,6,7,9,8};
        int[] array = {84,85,86,87,85,90,85,83,23,45,84,1,2,0};
        int[] topTwoScores = findTopTwoScores(array);
        for(int indx=0; indx<topTwoScores.length;indx++) {
            System.out.println(topTwoScores[indx]);
        }
    }
}
