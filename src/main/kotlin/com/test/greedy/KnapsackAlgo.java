package com.test.greedy;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class KnapsackAlgo {

    static class KnapsackItem implements Comparable<KnapsackItem> {
        int weight;
        int value;
        double valuePerWeight;

        public KnapsackItem(int weight, int value) {
            this.weight = weight;
            this.value = value;
            this.valuePerWeight = (double) value / weight;
        }

        @Override
        public int compareTo(@NotNull KnapsackItem o) {
            return Double.compare(o.valuePerWeight, this.valuePerWeight);
        }
    }

    static List<KnapsackItem> knapSack(final List<KnapsackItem> items, final int capacity) {
        items.sort(KnapsackItem::compareTo);
        List<KnapsackItem> selectedItems = new ArrayList<>();
        int currentCapacity = 0;
        int neededCapacity = capacity;
        int index = 0;
        while (index < items.size()) {
            KnapsackItem currentItem = items.get(index);
            if (currentItem.weight <= neededCapacity) {
                selectedItems.add(currentItem);
                currentCapacity = currentCapacity + currentItem.weight;
                neededCapacity = capacity - currentCapacity;
            } else {
                index++;
            }
            if (neededCapacity == 0) {
                return selectedItems;
            }
        }

        return selectedItems;
    }

    static List<KnapsackItem> knapSackRecursionTry(final List<KnapsackItem> items, final int capacity) {
        items.sort(KnapsackItem::compareTo);
        List<KnapsackItem> selectedItems = new ArrayList<>();
        int currentCapacity = 0;
        int index = 0;
        knapsackIt(items, selectedItems, index, capacity, capacity, currentCapacity);

        return selectedItems;
    }

    static List<KnapsackItem> knapsackIt(List<KnapsackItem> items,
                                         List<KnapsackItem> selectedItems,
                                         int index,
                                         int neededCapacity, int capacity, int currentCapacity) {

        // BC
        if (index >= items.size()) {
            return selectedItems;
        }

        if (neededCapacity == 0) {
            return selectedItems;
        }

        // H & I

        KnapsackItem currentItem = items.get(index);
        if (currentItem.weight <= neededCapacity) {
            selectedItems.add(currentItem);
            currentCapacity = currentCapacity + currentItem.weight;
            neededCapacity = capacity - currentCapacity;
            selectedItems = knapsackIt(items, selectedItems, index, neededCapacity, capacity, currentCapacity);
        } else {
            index++;
            selectedItems = knapsackIt(items, selectedItems, index, neededCapacity, capacity, currentCapacity);
        }

        return selectedItems;
    }


    static Comparator<KnapsackItem> comparatorValue = (o1, o2) -> o1.value - o2.value;

    // TODO : Fix this with the backtracking and return value to the max of KnapsackItems value
    static KnapsackItem knapsackItBkTrack(List<KnapsackItem> items,
                                          KnapsackItem selectedItem,
                                          int index,
                                          int neededCapacity, int capacity, int currentCapacity) {

        // BC
        if (index >= items.size()) {
            return selectedItem;
        }

        if (neededCapacity == 0) {
            return selectedItem;
        }

        // H & I

        KnapsackItem currentItem = items.get(index);
        if (currentItem.weight <= neededCapacity) {
            selectedItem = currentItem;
            currentCapacity = currentCapacity + currentItem.weight;
            neededCapacity = capacity - currentCapacity;
        } else {
            index++;
        }
        KnapsackItem selectedItemOne = null;
        KnapsackItem selectedItemTwo = null;
        selectedItem = comparatorValue.compare(
                knapsackItBkTrack(items, selectedItemOne, index, neededCapacity, capacity, currentCapacity),
                knapsackItBkTrack(items, selectedItemTwo, index+1, neededCapacity, capacity, currentCapacity)) > 0
                ? selectedItemOne
                : selectedItemTwo;

        return selectedItem;

    }


    public static void main(String[] args) {

        KnapsackItem knapsackItem1 = new KnapsackAlgo.KnapsackItem(1, 4);
        KnapsackItem knapsackItem2 = new KnapsackAlgo.KnapsackItem(2, 9);
        KnapsackItem knapsackItem3 = new KnapsackAlgo.KnapsackItem(3, 15);
        KnapsackItem knapsackItem4 = new KnapsackAlgo.KnapsackItem(4, 25);

        List<KnapsackItem> items = Arrays.asList(knapsackItem1, knapsackItem2, knapsackItem3, knapsackItem4);
//        List<KnapsackItem> selectedItems = KnapsackAlgo.knapSack(items, 11);
        List<KnapsackItem> selectedItems = KnapsackAlgo.knapSackRecursionTry(items, 11);
        System.out.println(" Selected Items are: ");
        selectedItems.forEach(knapsackItem -> System.out.print(" ( weight: " + knapsackItem.weight + " : value : " + knapsackItem.value + " ) , "));

    }
}
