package com.test.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Resource {
    private int value;

    public Resource(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

class ResourceHandler implements Runnable {
    private final BlockingQueue<Resource> resourceQueue;

    public ResourceHandler(BlockingQueue<Resource> resourceQueue) {
        this.resourceQueue = resourceQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Acquire the resource from the queue
                Resource resource = resourceQueue.take();

                // Simulate some work on the shared resource
                int newValue = resource.getValue() + 1;
                resource.setValue(newValue);

                // Print the updated value
                System.out.println(Thread.currentThread().getName() + " updated resource: " + newValue);

                // Put the modified resource back into the queue
                resourceQueue.put(resource);

                // Simulate some delay before the next iteration
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class SharedResourceExample {
    public static void main(String[] args) {
        // Creating an ArrayBlockingQueue with a capacity of 1
        BlockingQueue<Resource> resourceQueue = new ArrayBlockingQueue<>(1);

        // Initializing the shared resource
        Resource sharedResource = new Resource(0);

        // Putting the initial resource into the queue
        try {
            resourceQueue.put(sharedResource);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Creating multiple threads to handle the shared resource
        Thread thread1 = new Thread(new ResourceHandler(resourceQueue));
        Thread thread2 = new Thread(new ResourceHandler(resourceQueue));

        // Starting the threads
        thread1.start();
        thread2.start();
    }
}

