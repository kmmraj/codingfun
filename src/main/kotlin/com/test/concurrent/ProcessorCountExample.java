package com.test.concurrent;

public class ProcessorCountExample {
    public static void main(String[] args) {
        // Get the number of available processors
        int availableProcessors = Runtime.getRuntime().availableProcessors();

        System.out.println("Number of available processors: " + availableProcessors);
    }
}
