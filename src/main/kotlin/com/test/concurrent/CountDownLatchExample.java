package com.test.concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch finishSignal = new CountDownLatch(3);

        for (int i = 1; i <= 3; i++) {
            new Thread(new Runner(startSignal, finishSignal, i)).start();
        }

        // Wait for all runners to be ready
        Thread.sleep(2000); // Simulating some setup time
        System.out.println("Race starts!");
        startSignal.countDown(); // Start the race

        // Wait for all runners to finish
        finishSignal.await();
        System.out.println("All runners finished! Celebration time!");
    }

    static class Runner implements Runnable {
        private final CountDownLatch startSignal;
        private final CountDownLatch finishSignal;
        private final int runnerNumber;

        Runner(CountDownLatch startSignal, CountDownLatch finishSignal, int runnerNumber) {
            this.startSignal = startSignal;
            this.finishSignal = finishSignal;
            this.runnerNumber = runnerNumber;
        }

        @Override
        public void run() {
            try {
                System.out.println("Runner " + runnerNumber + " ready, waiting for the race to start");
                startSignal.await(); // Wait for the race to start
                System.out.println("Runner " + runnerNumber + " running the race");
                Thread.sleep(2000); // Simulating running time
                System.out.println("Runner " + runnerNumber + " finished the race");
                finishSignal.countDown(); // Signal that the runner finished
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
