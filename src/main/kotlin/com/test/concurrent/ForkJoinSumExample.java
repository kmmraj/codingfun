package com.test.concurrent;
//n this example:
//
//SumTask is a custom RecursiveTask that calculates the sum of a subarray.
//The task is split into two subtasks if the size of the array is larger than a specified threshold (THRESHOLD).
//The main method creates a ForkJoinPool and submits the SumTask to it.
//The invoke method is used to start the computation and obtain the result.
//The result is printed, and the ForkJoinPool is shut down.
//This example demonstrates how the ForkJoinPool divides a large task into smaller subtasks
// and uses multiple threads to execute them in parallel, improving the performance of certain types of computations.
// The specific algorithm used here is a basic example,
// and in practice, you'd choose to use Fork/Join for
// problems that are inherently recursive and can be parallelized effectively.
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinSumExample {

    // Custom RecursiveTask to calculate the sum of an array
    static class SumTask extends RecursiveTask<Long> {
        private static final int THRESHOLD = 5; // Threshold for splitting the task
        private int[] array;
        private int start;
        private int end;

        SumTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            if (end - start <= THRESHOLD) {
                // If the task is small enough, compute the sum directly
                long sum = 0;
                for (int i = start; i < end; i++) {
                    sum += array[i];
                }
                return sum;
            } else {
                // Split the task into two subtasks
                int mid = (start + end) / 2;
                SumTask leftTask = new SumTask(array, start, mid);
                SumTask rightTask = new SumTask(array, mid, end);

                // Fork the subtasks in parallel
                leftTask.fork();
                rightTask.fork();

                // Join the results from the subtasks
                long leftResult = leftTask.join();
                long rightResult = rightTask.join();

                // Combine the results
                return leftResult + rightResult;
            }
        }
    }

    public static void main(String[] args) {
        // Create an array for testing
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        // Create a ForkJoinPool
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        // Create a task to compute the sum of the array
        SumTask sumTask = new SumTask(array, 0, array.length);

        // Submit the task to the ForkJoinPool
        long result = forkJoinPool.invoke(sumTask);

        // Print the result
        System.out.println("Sum: " + result);

        // Shutdown the ForkJoinPool
        forkJoinPool.shutdown();
    }
}
