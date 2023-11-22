package com.test.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class ConsistencyModels {


    public static void main(String[] args) {
        SequentialConsistency.main(args);
        WeakOrdering.main(args);
    }
}


class SequentialConsistency {
    private static int x = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            x = 10; // Write 10 to x
        });

        Thread t2 = new Thread(() -> {
            int y = x; // Read x
            System.out.println("y = " + y);
        });

        t1.start();
        t2.start();
    }
}

class WeakOrdering {
    private static int x, y;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int index = 0; index < 100; index++) {
                x = 10; // Write 10 to x
                y = 20; // Write 20 to y
            }
        });

        Thread t2 = new Thread(() -> {
            for (int index = 0; index < 100; index++) {
            int z = x + y; // Read x and y
            System.out.println("z = " + z);
            }
        });

        t1.start();
        t2.start();
    }
}


class ReleaseConsistency {
    private static int x;
    private static volatile boolean released = false;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            x = 10; // Write 10 to x
            release(); // Release operation
        });

        Thread t2 = new Thread(() -> {
            acquire(); // Acquire operation
            int y = x; // Read x
            System.out.println("y = " + y);
        });

        t1.start();
        t2.start();
    }

    private static void release() {
        released = true;
    }

    private static void acquire() {
        while (!released) {
            // Wait for release operation to complete
        }
    }
}


class SCAtomicOperations {
    private static AtomicInteger x = new AtomicInteger(0);

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            x.set(10); // Atomic write to x
        });

        Thread t2 = new Thread(() -> {
            int y = x.get(); // Atomic read of x
            System.out.println("y = " + y);
        });

        t1.start();
        t2.start();
    }
}



