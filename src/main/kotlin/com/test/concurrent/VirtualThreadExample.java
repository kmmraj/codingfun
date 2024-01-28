package com.test.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//Virtual threads (also known as lightweight threads or fibers) are a new thread implementation
// designed to improve the performance and scalability of applications that handle many concurrent tasks.
// They differ from traditional operating system (OS) threads in several key ways:
//
//1. Mapping to OS Threads:
//
//Traditional Threads: Each thread is directly mapped to an OS thread, managed by the kernel.
//Virtual Threads: Multiple virtual threads can be mapped to a single OS thread,
//reducing the overhead associated with context switching and thread management at the OS level.
//
//2. Scheduling:
//
//Traditional Threads: Scheduled by the OS, which can introduce context switching overhead.
//Virtual Threads: Scheduled by the Java Virtual Machine (JVM) or language runtime,
// often using cooperative multitasking techniques, reducing context switching overhead and improving responsiveness.
//
//3. Memory Footprint:
//
//Traditional Threads: Each thread has its own stack, consuming a significant amount of memory,
// especially for many threads.
//Virtual Threads: Share a common stack or use smaller stacks,
// reducing memory usage and allowing more threads to be active within the same process.

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
