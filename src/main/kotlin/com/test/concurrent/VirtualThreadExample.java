package com.test.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VirtualThreadExample {
// Need java 19+
    public static void main(String[] args) throws InterruptedException {
        // Create an ExecutorService for virtual threads
        try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {

            // Submit a task to the ExecutorService
            executorService.submit(() -> {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Virtual thread: " + i);
                }
            });

            // Shutdown the ExecutorService
            executorService.shutdown();
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        }

        System.out.println("Main thread finished");
    }
}
