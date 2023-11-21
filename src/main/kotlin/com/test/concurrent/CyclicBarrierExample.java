package com.test.concurrent;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> System.out.println("All parties arrived!"));

        for (int i = 1; i <= 3; i++) {
            new Thread(new Worker(cyclicBarrier, i)).start();
        }
    }

    static class Worker implements Runnable {
        private final CyclicBarrier cyclicBarrier;
        private final int workerNumber;

        Worker(CyclicBarrier cyclicBarrier, int workerNumber) {
            this.cyclicBarrier = cyclicBarrier;
            this.workerNumber = workerNumber;
        }

        @Override
        public void run() {
            try {
                System.out.println("Worker " + workerNumber + " is waiting");
                cyclicBarrier.await();
                System.out.println("Worker " + workerNumber + " is continuing with its work");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

