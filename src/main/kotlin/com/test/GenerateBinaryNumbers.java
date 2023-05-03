package com.test;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryNumbers {

    public static String[] generateBinaryNumber(int limit){

        String[] returnArray = new String[limit];

        Queue<String> queue = new LinkedList<String>();
        queue.add("1");
        for (int index = 0; index < limit; index++) {
            String s1 =  queue.peek();
            returnArray[index] = s1;
            System.out.println(s1);
           // String s2 = s1;
            queue.remove();
            queue.add(s1+'0');
            queue.add(s1+'1');
        }

        return returnArray;
    }

    static void generatePrintBinary(int n)
    {
        // Create an empty queue of strings
        Queue<String> q = new LinkedList<String>();

        // Enqueue the first binary number
        q.add("1");

        // This loops is like BFS of a tree with 1 as root
        // 0 as left child and 1 as right child and so on
        while(n-- > 0)
        {
            // print the front of queue
            String s1 = q.peek();
            q.remove();
            System.out.println(s1);

            // Store s1 before changing it
            String s2 = s1;

            // Append "0" to s1 and enqueue it
            q.add(s1 + "0");

            // Append "1" to s2 and enqueue it. Note that s2 contains
            // the previous front
            q.add(s2 + "1");
        }
    }

    public static void main(String[] args) {

        generateBinaryNumber(12);
    }
}
