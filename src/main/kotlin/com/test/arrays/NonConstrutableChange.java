package com.test.arrays;

import java.util.Arrays;

public class NonConstrutableChange {

    public int nonConstructibleChange(int[] coins) {
        Arrays.sort(coins);
        int currentChange=0;
        for (int coin : coins) {
            if(coin > currentChange+1){
                return currentChange+1;
            } else {
                currentChange = coin+currentChange;
            }
        }
        return currentChange;
    }

    public static void main(String[] args) {

    }
}
