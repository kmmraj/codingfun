package com.test.designpattern;

public class SingletonExample {
}

class ClassicSingleton {

    // Private constructor to prevent instantiation from outside
    private ClassicSingleton() {
    }

    // The single instance of the class
    private static final ClassicSingleton instance = new ClassicSingleton();

    // Public method to access the instance
    public static ClassicSingleton getInstance() {
        return instance;
    }

    // Other methods and properties
    // ...

    public static void main(String[] args) {
        ClassicSingleton classicSingleton = ClassicSingleton.getInstance();
        System.out.println(classicSingleton);
    }
}


class LazySingleton {

    // Private constructor to prevent instantiation from outside
    private LazySingleton() {
    }

    // The single instance of the class (not created until needed)
    private static LazySingleton instance;

    // Public method to access the instance, creating it if necessary
    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    // Other methods and properties
    // ...
    public static void main(String[] args) {
        LazySingleton lazySingleton = LazySingleton.getInstance();
        System.out.println(lazySingleton);
    }
}


class BillPughSingleton {

    // Private constructor to prevent instantiation from outside
    private BillPughSingleton() {
    }

    // Static inner helper class to provide lazy initialization
    private static class SingletonHelper {
        private static final BillPughSingleton instance = new BillPughSingleton();
    }

    // Public method to access the instance
    public static BillPughSingleton getInstance() {
        return SingletonHelper.instance;
    }

    // Other methods and properties
    // ...

    public static void main(String[] args) {
        BillPughSingleton billPughSingleton = BillPughSingleton.getInstance();
        System.out.println(billPughSingleton);
    }
}


enum EnumSingleton {
    INSTANCE;

    public void doSomething() {
        // Singleton logic
    }

    public static void main(String[] args) {
        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
        System.out.println(enumSingleton);
    }
}



class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {
    }

    public static synchronized ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        ThreadSafeSingleton threadSafeSingleton = ThreadSafeSingleton.getInstance();
        System.out.println(threadSafeSingleton);
    }
}


class DoubleCheckedLockingSingleton {
    //n this example:
    //
    //The volatile keyword is used for the instance variable.
    // This ensures that any thread reading the instance field sees
    // the most recent modification made by any other thread.
    // Without this, there is a chance that a thread might see a partially initialized instance.
    //
    //The first check (if (instance == null)) is performed outside the synchronized block to avoid
    // unnecessary synchronization once the instance is already created.
    //
    //The second check is inside the synchronized block to ensure
    // that only one thread at a time can create the instance.
    //
    //This way, multiple threads can check if the instance is null without blocking,
    // and only one thread will enter the synchronized block to create the instance if it's not already created.
    // This pattern helps in reducing the overhead of synchronization when the instance is already created.
    private static volatile DoubleCheckedLockingSingleton instance;

    private DoubleCheckedLockingSingleton() {
    }

    public static DoubleCheckedLockingSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedLockingSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        DoubleCheckedLockingSingleton doubleCheckedLockingSingleton = DoubleCheckedLockingSingleton.getInstance();
        System.out.println(doubleCheckedLockingSingleton);
    }
}




