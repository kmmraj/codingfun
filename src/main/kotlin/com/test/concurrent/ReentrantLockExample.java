package com.test.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        int numberOfThreads = 3;

        // Create and start multiple threads
        for (int i = 1; i <= numberOfThreads; i++) {
            new Thread(new CounterIncrementer(sharedResource, "Thread " + i)).start();
        }
    }

    static class SharedResource {
        private int counter = 0;
        private final Lock lock = new ReentrantLock(); // Create a ReentrantLock

        public void increment() {
            // Acquire the lock
            lock.lock();
            try {
                // Critical section: Increment the counter
                counter++;
                System.out.println(Thread.currentThread().getName() + " incremented the counter to " + counter);
            } finally {

                // Ensure the lock is always released, even if an exception occurs
                lock.unlock();
            }
        }

        public int getCounter() {
            return counter;
        }
    }

    static class CounterIncrementer implements Runnable {
        private final SharedResource sharedResource;
        private final String threadName;

        CounterIncrementer(SharedResource sharedResource, String threadName) {
            this.sharedResource = sharedResource;
            this.threadName = threadName;
        }

        @Override
        public void run() {
            // Each thread increments the counter multiple times
            for (int i = 0; i < 5; i++) {
                sharedResource.increment();
            }
            System.out.println(this.threadName + " completed ");
//            System.out.println(Thread.currentThread().getName() + " completed ");
        }
    }
}
