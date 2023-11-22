package com.test.concurrent;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Producer implements Runnable {
    private final BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            String data = produceData();
            try {
                queue.put(data);
                System.out.println("Produced: " + data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private String produceData() {
        // Simulate data production
        return "Data-" + Math.random();
    }
}

class Consumer implements Runnable {
    private final BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            String data;
            try {
                data = queue.take();
                System.out.println("Consumed: " + data);
                consumeData(data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void consumeData(String data) {
        // Simulate data consumption
        System.out.println("Processing data: " + data);
    }
}

public class ProducerConsumerExampleWithBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(10); // Queue size

        Thread producerThread = new Thread(new Producer(queue));
        Thread consumerThread = new Thread(new Consumer(queue));

        producerThread.start();
        consumerThread.start();
    }
}
