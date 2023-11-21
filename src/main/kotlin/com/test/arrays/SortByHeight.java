package com.test.arrays;

import java.util.PriorityQueue;
import java.util.Queue;

public class SortByHeight {

    int[] solution(int[] a) {
        Queue<Integer> pQueue = new PriorityQueue<>();
        for (int i : a) {
            if (i != -1) {
                pQueue.add(i);
            }
        }

        for (int index = 0; index < a.length; index++) {
            if(a[index] != -1 && !pQueue.isEmpty()){
                a[index] = pQueue.poll();
            }
        }
        return a;

    }

    public static void main(String[] args) {
        SortByHeight sortByHeight = new SortByHeight();
        int[] a = {-1, 150, 190, 170, -1, -1, 160, 180};
        int[] result = sortByHeight.solution(a);
        for (int i : result) {
            System.out.print(i + "  ");
        }
    }
}
