package com.test.divideandconquer;

public class ZeroOneKnapsackFruit {

    public static int knapSack(int[] profits, int[] weights, int capacity) {
        return knapSackRecursive(profits, weights, capacity, 0, 0);
    }

    private static int knapSackRecursiveWorking(int[] profits, int[] weights, int capacity, int currentCapacity, int value, int index) {
        // BC
        if (capacity <= 0 || index < 0 || index >= weights.length) {
            return value;
        }
        // Hypo
        int includeCurrent = 0;
        if (weights[index] <= capacity) {
            includeCurrent = profits[index]
                    + knapSackRecursiveWorking(profits, weights, capacity - weights[index],
                    capacity - weights[index], value, index + 1);
        }
        int skipCurrent = knapSackRecursiveWorking(profits, weights, capacity,
                currentCapacity, value, index + 1);
        // Induction
        value = Math.max(includeCurrent, skipCurrent);
        return value;

    }

    private static int knapSackRecursive(int[] profits, int[] weights, int neededCapacity, int value, int index) {
        // BC
        if (neededCapacity == 0 || index < 0 || index >= weights.length) {
            return value;
        }
        // Hypo
        int includeCurrent = 0;
        if (weights[index] <= neededCapacity) {
            includeCurrent = profits[index]
                    + knapSackRecursive(profits, weights,
                    neededCapacity - weights[index], value, index + 1);
        }
        int skipCurrent = knapSackRecursive(profits, weights,
                neededCapacity, value, index + 1);
        // Induction
        value = Math.max(includeCurrent, skipCurrent);
        return value;

    }

    public static void main(String[] args) {
        System.out.println(ZeroOneKnapsackFruit.knapSack(new int[]{1, 6, 10, 16}, new int[]{1, 2, 3, 5}, 7));
    }
}
