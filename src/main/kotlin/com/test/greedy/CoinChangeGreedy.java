package com.test.greedy;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CoinChangeGreedy {


    static List<Integer> coinChangeProblem(int[] coins, int N) {
        List<Integer> selectedCoins = new ArrayList<>();
        PriorityQueue<Integer> priorityQueueMax = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int coin : coins) {
            priorityQueueMax.add(coin);
        }
        int change = N;
        while (!priorityQueueMax.isEmpty() && change > 0) {
            int currentChange = priorityQueueMax.poll();
            int maxAmount =  (N/currentChange) * currentChange;
            System.out.println("maxAmount: " + maxAmount + " currentChange: " + currentChange + " change: " + change + " amount: " + N);
            if (currentChange <= change) {
                change = change - currentChange;
                selectedCoins.add(currentChange);
                priorityQueueMax.offer(currentChange);
            }
        }

//        AtomicInteger sum  = new AtomicInteger();
//        selectedCoins.forEach(coin -> sum.set(sum.get() + coin));
//
//        if(sum.get() != N){
//            return -1;
//        }

        return selectedCoins;
    }

    static List<Integer> coinChange(int[] coins, int amount) {
        List<Integer> selectedCoins = new ArrayList<>();
        PriorityQueue<Integer> priorityQueueMax = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int coin : coins) {
            priorityQueueMax.add(coin);
        }
        int change = amount;
        while (!priorityQueueMax.isEmpty() && change >= 0) {
            int currentChange = priorityQueueMax.poll();
            int maxAmount =  amount/currentChange * currentChange;
            System.out.println("maxAmount: " + maxAmount + " currentChange: " + currentChange + " change: " + change + " amount: " + amount);
            if (currentChange <= change) {
                change = change - currentChange;
                selectedCoins.add(currentChange);
                priorityQueueMax.offer(currentChange);
            }

        }

        AtomicInteger sum = new AtomicInteger();
        selectedCoins.forEach(coin -> sum.set(sum.get() + coin));


//        if (sum.get() <= amount) {
//            selectedCoins.size()+1;
//        }

        return selectedCoins;
    }

    public static void main(String[] args) {
        int[] input = {2, 3, 4, 7, 22, 15, 1, 5, 8};
        List<Integer> selectedCoins = CoinChangeGreedy.coinChangeProblem(input, 100);
        System.out.println("\nSelected coins are: ");
        selectedCoins.forEach(coin -> System.out.print(coin + ", "));

        int[] input1 = {186, 419, 83, 408};
        selectedCoins = CoinChangeGreedy.coinChange(input1, 6249);
        System.out.println("\nSelected coins are: ");
        selectedCoins.forEach(coin -> System.out.println(coin + " "));
    }
}
