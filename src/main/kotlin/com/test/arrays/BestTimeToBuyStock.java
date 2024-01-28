package com.test.arrays;

public class BestTimeToBuyStock {

    int[][] dpT;


    public int maxProfitEOPI(int[] prices) {
        // new int[]{5,7,9,4,2,5,3,8,1,6};
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (final int price: prices){
            maxProfit = Integer.max(maxProfit,price-minPrice); // Find the max profit so far using the min price so far
            minPrice = Integer.min(minPrice,price); // Find the minimum price so far and then find the max profit
        }
        return maxProfit;
    }

    private int getMaxProfitRecursively(int[] prices,int start, int end){
        // BC
        if(start >= end){
            return 0;
        }

        // H & I
        int profit = prices[end] - prices[start];
        return Math.max(profit, Math.max(getMaxProfitRecursively(prices,start+1,end),
                getMaxProfitRecursively(prices,start,end-1)));
    }

    public static void main(String[] args) {
        int [] prices = {7,1,5,3,6,4};
        BestTimeToBuyStock time = new BestTimeToBuyStock();
        System.out.println("Result of maxProfitTest is " +time.maxProfitTest(prices));
        System.out.println("Result of maxProfitEOPI is " + time.maxProfitEOPI(prices));
        System.out.println("Result of max2ProfitByKenadeAlgo is " + time.max2ProfitByKenadeAlgo(prices));
        System.out.println("Result of using Recursion is " + time.max2ProfitByRecursion(prices));

        System.out.println();

        // Another test case
        prices = new int[]{1,2,3,4,5};
        System.out.println("Result of maxProfitTest is " +time.maxProfitTest(prices));
        System.out.println("Result of maxProfitEOPI is " + time.maxProfitEOPI(prices));
        System.out.println("Result of max2ProfitByKenadeAlgo is " + time.max2ProfitByKenadeAlgo(prices));
        System.out.println("Result of using Recursion is " + time.max2ProfitByRecursion(prices));
        System.out.println();

        // Another test case
        prices = new int[]{7,6,4,3,1};
        System.out.println("Result of maxProfitTest is " +time.maxProfitTest(prices));
        System.out.println("Result of maxProfitEOPI is " + time.maxProfitEOPI(prices));
        System.out.println("Result of max2ProfitByKenadeAlgo is " + time.max2ProfitByKenadeAlgo(prices));
        System.out.println("Result of using Recursion is " + time.max2ProfitByRecursion(prices));
        System.out.println();

        // Another test case
        prices = new int[]{5,7,9,4,2,5,3,8,1,6};
        System.out.println("Result of maxProfitTest is " +time.maxProfitTest(prices));
        System.out.println("Result of maxProfitEOPI is " + time.maxProfitEOPI(prices));
        System.out.println("Result of max2ProfitByKenadeAlgo is " + time.max2ProfitByKenadeAlgo(prices));
        System.out.println("Result of using Recursion is " + time.max2ProfitByRecursion(prices));
        System.out.println();
    }

    public int max2ProfitDP(int[] prices) {
        int profit = 0, idx=0;
        dpT = new int[prices.length+1][prices.length+1];
        for (int idxI = 0; idxI < prices.length+1; idxI++) {
            for (int idxJ = 0; idxJ < prices.length+1; idxJ++) {
                dpT[idxI][idxJ] = Integer.MIN_VALUE;
            }
        }
        //profit = solveItRecursively(prices,0,prices.length-1);
        profit = solveItMemoized(prices,0,prices.length-1);
        return profit;
    }


    private int max2ProfitByKenadeAlgo(int[] prices) {
//7,1,5,3,6,4
        if(prices.length ==0)
            return 0;
        int maxCurr =0;
        int maxSoFar =Integer.MIN_VALUE;
        for (int idxI = 1; idxI < prices.length ; idxI++) {
            maxCurr+= prices[idxI]-prices[idxI-1]; // -6, 4, 2,5,3
            maxCurr = Math.max(0, maxCurr); // 0,4,2,5,3
            maxSoFar = Math.max(maxCurr,maxSoFar); // 0,4,4,5,3
        }
        return maxSoFar == Integer.MIN_VALUE?0:maxSoFar;
    }

    public int max2ProfitByRecursion(int[] prices){
       return solveItRecursively(prices,0,prices.length-1);
    }

    private int solveItRecursively(int[] prices, int buyIdx, int sellIdx){

        // BC
        if(buyIdx>=sellIdx)
            return 0;

        // Hypo & Choices
        int profit = prices[sellIdx] - prices[buyIdx];
        profit = Math.max(profit, 0);
        profit = Math.max(profit,
                Math.max(
                        solveItRecursively(prices,buyIdx+1,sellIdx),
                        solveItRecursively(prices,buyIdx,sellIdx-1)
                ));
        return profit;

    }
    private int solveIt(int[] prices, int idx, int profit) {
        //BC
        if(idx == prices.length){
            return profit;
        }

        // Hypothesis & Choices
        for (int idxI = idx; idxI < prices.length; idxI++) {
            for (int idxJ = idxI; idxJ < prices.length; idxJ++) {
                profit = Math.max(profit,solveIt(prices,idx+1,prices[idxJ]-prices[idxI]));
            }
        }
        return profit;
    }

    private int solveItMemoized(int[] prices, int buyIdx, int sellIdx) {
        //BC
        if(buyIdx>=sellIdx)
            return 0;

        // Hypo & Choices

        if(dpT[buyIdx][sellIdx] != Integer.MIN_VALUE){

            return dpT[buyIdx][sellIdx];
        }

        int profit = prices[sellIdx]-prices[buyIdx];
        profit = profit>0?profit:0;
        int profitOne;
        int profitTwo;

        if(dpT[buyIdx+1][sellIdx] != Integer.MIN_VALUE){
            profitOne = dpT[buyIdx+1][sellIdx];
        }  else {
            dpT[buyIdx+1][sellIdx] = profitOne  = solveItMemoized(prices,buyIdx+1,sellIdx);
        }

        if(dpT[buyIdx][sellIdx-1] != Integer.MIN_VALUE){
            profitTwo = dpT[buyIdx][sellIdx-1];
        }  else {
            dpT[buyIdx][sellIdx-1] = profitTwo  = solveItMemoized(prices,buyIdx,sellIdx-1);
        }


        dpT[buyIdx][sellIdx]= profit = Math.max(profit,Math.max(profitOne,profitTwo));

        return profit;
    }


    public int maxProfitTest(int[] prices) {
        if(prices.length ==0){
            return 0;
        }
        int minAmount = prices[0];
        int maxAmount = prices[0];


        // int [] prices = {7,1,5,3,6,4};
        // int [] prices = {7,6,4,3,1};
        // int [] prices =
        for(int indx=1; indx<= prices.length-1; indx++){
            if(prices[indx] < minAmount){
                minAmount = prices[indx];
                maxAmount = prices[indx];
            }

            if(prices[indx] > maxAmount) {
                maxAmount = prices[indx];
            }
        }

        return maxAmount - minAmount;
    }
}
