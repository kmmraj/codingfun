package com.test.arrays;

import java.util.Arrays;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class ArraysOfSimilar {
//    boolean solution(int[] a, int[] b) {
//        if(a.length != b.length){
//            return false;
//        }
//        Queue<Integer> pQueueOne = new PriorityQueue<>();
//        Queue<Integer> pQueueTwo = new PriorityQueue<>();
//
//        for (int index = 0; index < a.length; index++) {
//            pQueueOne.add(a[index]);
//            pQueueTwo.add(b[index]);
//        }
//
//        // System.out.println("Queue One content "+ pQueueOne.toString() + " size "+ pQueueOne.size());
//        // System.out.println("Queue Two content "+ pQueueTwo.toString());
//
//        int size = pQueueOne.size();
//        for (int index = 0; index < size; index++) {
//            // System.out.println("Queue One content "+ pQueueOne.peek() + "Queue Two content "+ pQueueTwo.peek());
//            if(!Objects.equals(pQueueOne.poll(), pQueueTwo.poll())){
//                return false;
//            }
//        }
//        return true;
//
//        //long count = pQueueOne.stream().flatMap(pq1 -> pQueueTwo.stream().map(pq2 -> pq1 != pq2)).count();
//        //return count>1;
//
//    }

    boolean solution(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        }
        // a: [1, 2, 1, 2, 2, 1]
        // b: [2, 2, 1, 1, 2, 1]
        int[] prevPair = new int[2];
        int[] currPair = new int[2];
        System.out.println("a is" + Arrays.toString(a));
        System.out.println("b is" + Arrays.toString(b));
        int diffCount = 0;
        for (int index = 0; index < b.length; index++) {
            if (a[index] != b[index]) {
                diffCount++;
                if (diffCount == 1) {
                    prevPair[0] = a[index];
                    prevPair[1] = b[index];
                }
                if (diffCount == 2) {
                    currPair[0] = a[index];
                    currPair[1] = b[index];
                    // System.out.println("prevPair[0] != currPair[1] && prevPair[1] != currPair[0] " + prevPair[0] + " != " + currPair[1] + " && " + prevPair[1] +  " != " + currPair[0] );
                    if (prevPair[0] != currPair[1] || prevPair[1] != currPair[0]) {
                        return false;
                    } else {
                        continue;
                    }
                }
                if (diffCount > 2) {
                    return false;
                }

            }

        }


        return true;
    }


    boolean workingSolution(int[] a, int[] b){
        int diffIndexOne = -1;
        int diffIndexTwo = -1;
        for (int index = 0; index < a.length; index++) {
            if (a[index] != b[index]) {
                if (diffIndexOne == -1) {
                    diffIndexOne = index;
                } else if (diffIndexTwo == -1) {
                    diffIndexTwo = index;
                } else {
                    return false; // too many differences
                }
            }
        }
        return diffIndexOne == -1 || (diffIndexTwo != -1 && a[diffIndexOne] == b[diffIndexTwo] && a[diffIndexTwo] == b[diffIndexOne]);
    }

    public static void main(String[] args) {
        ArraysOfSimilar arraysOfSimilar = new ArraysOfSimilar();
        int[] a = {121, 144, 19, 161, 19, 144, 19, 11};
        int[] b = {121, 14641, 20736, 361, 25921, 361, 20736, 361};
        System.out.println(arraysOfSimilar.solution(a,b));

        a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
        b = new int[]{121, 144, 19, 11, 19, 144, 19, 161};
        System.out.println(arraysOfSimilar.solution(a,b));
    }

}
