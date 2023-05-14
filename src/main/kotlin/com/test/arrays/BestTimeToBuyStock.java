package com.test.arrays;

public class BestTimeToBuyStock {

    int[][] dpT;
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minValue = Integer.MIN_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for (int idx = 1; idx < prices.length; idx++) {
            if(prices[idx-1] < prices[idx]){
                minValue = Math.max(prices[idx-1],minValue);
                maxValue = Math.max(prices[idx],maxValue);
            }

            if(minValue > 0 && maxValue >0) {
                profit += maxValue- minValue;
                maxValue = minValue = 0;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int [] prices = {7,1,5,3,6,4};
        BestTimeToBuyStock time = new BestTimeToBuyStock();
//        System.out.println(time.max2Profit(prices));
//        System.out.println(time.solveItKenadeAlgo(prices));
        System.out.println(time.maxProfitTest(prices));
    }

    public int max2Profit(int[] prices) {
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


    private int solveItKenadeAlgo(int[] prices) {

        if(prices.length ==0)
            return 0;
        int maxCurr =0;
        int maxSoFar =Integer.MIN_VALUE;
        for (int idxI = 1; idxI < prices.length ; idxI++) {
            maxCurr+= prices[idxI]-prices[idxI-1];
            maxCurr = Math.max(0, maxCurr);
            maxSoFar = Math.max(maxCurr,maxSoFar);
        }
        return maxSoFar == Integer.MIN_VALUE?0:maxSoFar;
    }


    private int solveItRecursively(int[] prices, int buyIdx, int sellIdx){

        // BC
        if(buyIdx>=sellIdx)
            return 0;

        // Hypo & Choices
        int profit = prices[sellIdx] - prices[buyIdx];
        profit = profit > 0 ? profit: 0;
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
