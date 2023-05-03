package com.test.try2;

public class TrySingleton {
    private TrySingleton() {
    }


    static TrySingleton instance;

    public static TrySingleton getInstance() {
        if (instance == null) {
            synchronized (TrySingleton.class) {
                if (instance == null) {
                    instance = new TrySingleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        TrySingleton trySingleton = TrySingleton.getInstance();
    }
}
