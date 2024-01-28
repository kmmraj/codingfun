package com.test.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
//You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
//
//On each day, you may decide to buy and/or sell the stock.
// You can only hold at most one share of the stock at any time.
// However, you can buy it then immediately sell it on the same day.
//
//Find and return the maximum profit you can achieve.
//
//
//
//Example 1:
//
//Input: prices = [7,1,5,3,6,4]
//Output: 7
//Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
//Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
//Total profit is 4 + 3 = 7.
//Example 2:
//
//Input: prices = [1,2,3,4,5]
//Output: 4
//Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
//Total profit is 4.
//Example 3:
//
//Input: prices = [7,6,4,3,1]
//Output: 0
//Explanation: There is no way to make a positive profit,
//so we never buy the stock to achieve the maximum profit of 0.
//
//
//Constraints:
//
//1 <= prices.length <= 3 * 104
//0 <= prices[i] <= 104
public class BestTimeToBuyStock2 {

    public static int maxProfitByDP(int[] prices) {
        int stockValue = Integer.MIN_VALUE, cashValue=0;
        System.out.println("Price array is "+ Arrays.toString(prices));
        for(final int price: prices){
            int prevStockValue = stockValue;
            int prevCashValue = cashValue;
            System.out.println(" PrevStockValue is "+prevStockValue+ " prevCashValue is "+prevCashValue + " price is "+ price);
            stockValue = Math.max(stockValue, prevCashValue-price);
            System.out.println("StockValue = Math.max("+stockValue+" , "+ prevCashValue+" - "+price+")");
            cashValue = Math.max(cashValue,prevStockValue+price);
            System.out.println("CashValue = Math.max("+cashValue+" , "+prevStockValue+" + "+price+")");
            System.out.println(" StockValue is "+stockValue+ " CashValue is "+cashValue);
        }

        return cashValue;

    }

    public static int maxProfitByInflectionPoints(int[] prices) {
        // Option#2 - Finding the increase and decrease inflection points
        int profit = 0;
        int index=0;
        while (index<prices.length-1){
            // Find the raising price inflection
            while(index<prices.length-1 && prices[index+1]<=prices[index]){
                index++;
            }
            int buy = prices[index];

            // Find the decreasing price inflection
            while(index<prices.length-1 && prices[index+1] > prices[index]){
                index++;
            }
            int sell = prices[index];
            profit = profit + sell-buy;
        }
        return profit;
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        List<Integer> firstProfitList = new ArrayList<>();

        //for(final int price: prices){
        for(int idx=0;idx<prices.length;++idx){
            minPrice = Math.min(minPrice,prices[idx]);
            maxProfit = Math.max(maxProfit,prices[idx]-minPrice);
            firstProfitList.add(maxProfit);
        }

        int maxPrice = Integer.MIN_VALUE;
        int maxTotalProfit = 0;
        for(int index=prices.length-1; index>0;--index){
            maxPrice = Math.max(maxPrice,prices[index]);
            maxTotalProfit = Math.max(maxTotalProfit, ((maxPrice - prices[index]) + firstProfitList.get(index-1)));
        }
        return maxTotalProfit;

    }

    public static int maxProfitByTwoTimesTrade(int[] prices) {
        int profit = 0;
        int minValue = Integer.MIN_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for (int idx = 1; idx < prices.length; idx++) {
            if(prices[idx-1] < prices[idx]){
                minValue = Math.max(prices[idx-1],minValue);
                maxValue = Math.max(prices[idx],maxValue);
            }

            if(minValue > Integer.MIN_VALUE && maxValue >Integer.MIN_VALUE) {
                profit += maxValue- minValue;
                maxValue = minValue = 0;
            }
        }
        return profit;
    }
    public static void main(String[] args) {
        BestTimeToBuyStock2 bestTimeToBuyStock2 = new BestTimeToBuyStock2();
//        System.out.println("Max profit of [7,1,5,3,6,4] is 7 and result is " + bestTimeToBuyStock2.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
//        System.out.println("Max profit of [1,2,3,4,5] is 4 and result is " + bestTimeToBuyStock2.maxProfit(new int[]{1, 2, 3, 4, 5}));
//        System.out.println("Max profit of [7,6,4,3,1] is 0 and result is " + bestTimeToBuyStock2.maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println("Max profit of [7,1,5,3,6,4] is 7 and result is "
                + maxProfitByTwoTimesTrade(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println("Max profit of [7,1,5,3,6,4] is 7 and result is "
                + maxProfitByDP(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println("Max profit of [1,2,3,4,5] is 4 and result is "
                + maxProfitByInflectionPoints(new int[]{1, 2, 3, 4, 5}));

        System.out.println("Max profit of [1,2,3,4,5] is 4 and result is "
                + maxProfitByTwoTimesTrade(new int[]{1, 2, 3, 4, 5}));
        System.out.println("Max profit of [1,2,3,4,5] is 4 and result is "
                + maxProfitByDP(new int[]{1, 2, 3, 4, 5}));
        System.out.println("Max profit of [1,2,3,4,5] is 4 and result is "
                + maxProfitByInflectionPoints(new int[]{1, 2, 3, 4, 5}));
        System.out.println("Max profit of [7,6,4,3,1] is 0 and result is "
                + maxProfitByInflectionPoints(new int[]{7, 6, 4, 3, 1}));
        System.out.println("Max profit of [7,6,4,3,1] is 0 and result is "
                + maxProfitByTwoTimesTrade(new int[]{7, 6, 4, 3, 1}));
        System.out.println("Max profit of [3,3,5,0,0,3,1,4] is 6 and result is "
                + maxProfitByTwoTimesTrade(new int[]{3,3,5,0,0,3,1,4}));
        System.out.println("Max profit of [3,3,5,0,0,3,1,4] is 6 and result is "
                + maxProfitByDP(new int[]{3,3,5,0,0,3,1,4}));
        System.out.println("Max profit of [3,3,5,0,0,3,1,4] is 6 and result is "
                + maxProfitByInflectionPoints(new int[]{3,3,5,0,0,3,1,4}));

    }

}
