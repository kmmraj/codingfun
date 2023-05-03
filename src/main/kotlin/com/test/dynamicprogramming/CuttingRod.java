package com.test.dynamicprogramming;

public class CuttingRod {
    int [][] dp;

    public CuttingRod(int length, int[] price){
        this.dp = new int[length+1][price.length+1];
    }

    public int getMaxValueDP(int length, int[] price){

      //Init + BC
         for (int indexI = 0; indexI < length+1; indexI++) {
            for (int indexJ = 0; indexJ < price.length+1; indexJ++) {
                if(indexI ==0 || indexJ ==0){
                    this.dp[indexI][indexJ] =0;
                }
            }
        }

        int [] lenArr = new int[length+1];
        for (int i = 0; i <length+1 ; i++) {
            lenArr[i] = i+1;
        }

        for (int indexI = 1; indexI < length+1 ; indexI++) {
            for (int indexJ = 1; indexJ < price.length+1; indexJ++) {
                if(lenArr[indexI-1] <= indexJ) { // AA -- lenArr[indexI-1]
                    dp[indexI][indexJ] = Math.max(price[indexI-1] + dp[indexI][indexJ-lenArr[indexI-1]], // This is unbounded - diff is dp[indexI]
                            // in Bounded it is  dp[indexI-1]
                            // AA -- lenArr[indexI-1]
                            dp[indexI-1][indexJ]);
                } else {
                    dp[indexI][indexJ] = dp[indexI-1][indexJ];
                }

            }
        }

        return dp[length][price.length];

    }
    public int getMaxvalue(int length, int[] price){
        int [] lenArr = new int[length];
        for (int i = 0; i <length ; i++) {
            lenArr[i] = i+1;
        }
        int index =length;


        return solveIt(price,index);
    }

    private int solveIt( int[] price, int index){
        // BC
        if(index <= 0){
            return 0;
        }

        int maxValue = Integer.MIN_VALUE;
        // Induction & Hypo
        for (int idx = 0; idx < index; idx++) {
            maxValue =  Math.max(
                    maxValue,
                    price[idx]+solveIt(price,index-idx-1)
            );
        }

        return maxValue;
    }



    public static void main(String[] args) {
        int [] price = {1,5,8,9,10,17,17,20};
        CuttingRod rod = new CuttingRod(price.length,price);

        System.out.println(rod.getMaxvalue(8,price));
        System.out.println(rod.getMaxValueDP(8,price));
    }

}
