package com.test.concurrent;

public class ThreadLocalExample {

    // Create a ThreadLocal variable to store a user name
    private static final ThreadLocal<String> userNameThreadLocal = new ThreadLocal<>();

    // Method to set the user name in the ThreadLocal variable
    public static void setUserName(String userName) {
        userNameThreadLocal.set(userName);
    }

    // Method to get the user name from the ThreadLocal variable
    public static String getUserName() {
        return userNameThreadLocal.get();
    }

    public static void main(String[] args) {
        // Create and start Thread 1
        Thread thread1 = new Thread(() -> {
            setUserName("User1");
            System.out.println("Thread 1: User Name - " + getUserName());
        });

        // Create and start Thread 2
        Thread thread2 = new Thread(() -> {
            setUserName("User2");
            System.out.println("Thread 2: User Name - " + getUserName());
        });

        // Start both threads
        thread1.start();
        thread2.start();

        // Wait for both threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // In the main thread, access the ThreadLocal variable
        // It will be null because the main thread did not set a user name
        System.out.println("Main Thread: User Name - " + getUserName());
    }
}

