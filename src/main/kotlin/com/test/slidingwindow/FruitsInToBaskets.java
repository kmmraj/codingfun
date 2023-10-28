package com.test.slidingwindow;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//https://leetcode.com/problems/fruit-into-baskets/description/
public class FruitsInToBaskets {

    //{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}
    //{1, 2, 3, 2, 2}
    //{0, 1, 2, 2}
    public int totalFruit(int[] fruits) {
        int totalFruits = 0;
        int left = 0;
        int right = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        while (left < fruits.length && right < fruits.length) {
            if (queue.contains(fruits[right])) {
                totalFruits = Integer.max(totalFruits, right - left+1);
            } else {
                if(queue.size() >=2 ){
                    if(queue.peekLast() == 0 || queue.peekLast() == 1){
                           queue.pop();
                    }
                    left++;
                }
                queue.add(fruits[right]);
            }
            right++;
        }
        return totalFruits;

    }

    public int totalFruitWithHM(int[] fruits) {
        int totalFruits = 0;
        int left = 0;
        int right = 0;
        Map<Integer,Integer> fruitMap = new HashMap<>();
        while (right < fruits.length) {

            fruitMap.put(fruits[right], fruitMap.getOrDefault(fruits[right],0)+1);
            while (fruitMap.size() > 2) {
                fruitMap.put(fruits[left], fruitMap.get(fruits[left])-1);
                if(fruitMap.get(fruits[left]) == 0){
                    fruitMap.remove(fruits[left]);
                }
                left++;
            }
            totalFruits = Integer.max(totalFruits, right - left+1);
            right++;
        }
        return totalFruits;

    }

    public static void main(String[] args) {
//        System.out.println("Fruits in to baskets: " + new FruitsInToBaskets().totalFruitWithHM(new int[]{1, 2, 1}));
//        System.out.println("Fruits in to baskets: " + new FruitsInToBaskets().totalFruitWithHM(new int[]{0, 1, 2, 2}));
//        System.out.println("Fruits in to baskets: " + new FruitsInToBaskets().totalFruitWithHM(new int[]{1, 2, 3, 2, 2}));
        System.out.println("Fruits in to baskets: " + new FruitsInToBaskets().totalFruitWithHM(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));

    }
}
