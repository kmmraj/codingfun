package com.test.concurrent;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static void main(String[] args) {
        // Example with a semaphore limiting access to 3 permits
        Semaphore semaphore = new Semaphore(3);

        // Acquiring permits by multiple threads
        new Thread(() -> accessResource(semaphore)).start();
        new Thread(() -> accessResource(semaphore)).start();
        new Thread(() -> accessResource(semaphore)).start();
    }

    private static void accessResource(Semaphore semaphore) {
        try {
            semaphore.acquire(); // Acquire a permit
            // Access the shared resource or critical section
            System.out.println(Thread.currentThread().getName() + " accessing resource");
            Thread.sleep(2000); // Simulating some work
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release(); // Release the permit
        }
    }
}

