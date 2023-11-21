package com.test.concurrent;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class MyRecursiveAction extends RecursiveAction {
    private static final int THRESHOLD = 10;
    private int[] array;
    private int start;
    private int end;

    public MyRecursiveAction(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if (end - start <= THRESHOLD) {
            // Perform the action directly
            for (int i = start; i < end; i++) {
                array[i] = array[i] * 2;
            }
        } else {
            // Split the task into two subtasks
            int mid = (start + end) / 2;
            MyRecursiveAction leftAction = new MyRecursiveAction(array, start, mid);
            MyRecursiveAction rightAction = new MyRecursiveAction(array, mid, end);

            // Fork the subtasks in parallel
            leftAction.fork();
            rightAction.fork();

            // Join the results from the subtasks
            leftAction.join();
            rightAction.join();
        }
    }

    public static void main(String[] args) {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        MyRecursiveAction myRecursiveAction = new MyRecursiveAction(array,0,array.length);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(myRecursiveAction);


        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " , ");
        }

    }
}
