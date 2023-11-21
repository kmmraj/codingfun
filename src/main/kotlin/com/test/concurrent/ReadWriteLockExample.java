package com.test.concurrent;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
//n this example:
//
//The SharedData class contains a shared data structure, an int in this case, and a ReadWriteLock.
//The readData method acquires the read lock using lock.readLock().lock() for reading the data.
//The writeData method acquires the write lock using lock.writeLock().lock() for writing to the data.
//Multiple reader threads (Reader) can read the data concurrently using the read lock.
//Writer threads (Writer) acquire the write lock exclusively to perform write operations.
//Key points:
//
//The use of ReadWriteLock allows multiple threads to read the data simultaneously,
// improving concurrency for read-heavy scenarios.
//
//The read lock is shared among multiple threads for concurrent read access,
// while the write lock is exclusive, ensuring that only one thread can write at a time.
//
//The ReentrantReadWriteLock implementation allows a thread holding the read lock
// to re-enter the read lock or upgrade to the write lock without releasing the read lock first.
//
//It's important to release the locks in a finally block
// to ensure they are always released, even if an exception occurs.
//
//This example demonstrates the benefit of using ReadWriteLock
// when dealing with shared data that has frequent reads and less frequent writes.
// It helps to achieve better concurrency by allowing multiple threads to read concurrently
// while ensuring exclusive access during write operations.
public class ReadWriteLockExample {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();
        int numberOfReaders = 3;
        int numberOfWriters = 2;

        // Create and start multiple reader threads
        for (int i = 1; i <= numberOfReaders; i++) {
            new Thread(new Reader(sharedData, "Reader " + i)).start();
        }

        // Create and start multiple writer threads
        for (int i = 1; i <= numberOfWriters; i++) {
            new Thread(new Writer(sharedData, "Writer " + i)).start();
        }
    }

    static class SharedData {
        private int data = 0;
        private ReadWriteLock lock = new ReentrantReadWriteLock(); // Create a ReadWriteLock

        public int readData() {
            // Acquire the read lock
            lock.readLock().lock();
            try {
                // Perform read operation
                System.out.println(Thread.currentThread().getName() + " read data: " + data);
                return data;
            } finally {
                // Release the read lock
                lock.readLock().unlock();
            }
        }

        public void writeData(int newValue) {
            // Acquire the write lock
            lock.writeLock().lock();
            try {
                // Perform write operation
                System.out.println(Thread.currentThread().getName() + " wrote data: " + newValue);
                data = newValue;
            } finally {
                // Release the write lock
                lock.writeLock().unlock();
            }
        }
    }

    static class Reader implements Runnable {
        private SharedData sharedData;
        private String threadName;

        Reader(SharedData sharedData, String threadName) {
            this.sharedData = sharedData;
            this.threadName = threadName;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                sharedData.readData();
            }
        }
    }

    static class Writer implements Runnable {
        private SharedData sharedData;
        private String threadName;

        Writer(SharedData sharedData, String threadName) {
            this.sharedData = sharedData;
            this.threadName = threadName;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                sharedData.writeData(i + 1);
            }
        }
    }
}

