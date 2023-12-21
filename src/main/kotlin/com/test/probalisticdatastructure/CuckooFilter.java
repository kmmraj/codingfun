package com.test.probalisticdatastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CuckooFilter<T> {
    private static final int MAX_KICK_ATTEMPTS = 500;

    private final int size;
    private final int bucketSize;
    private final List<T>[] buckets;
    private final Random random;

    public CuckooFilter(int size, int bucketSize) {
        this.size = size;
        this.bucketSize = bucketSize;
        this.buckets = new ArrayList[size];
        this.random = new Random();
        initializeBuckets();
    }

    private void initializeBuckets() {
        for (int i = 0; i < size; i++) {
            buckets[i] = new ArrayList<>(bucketSize);
        }
    }

    public void add(T element) {
        int index1 = hash1(element);
        int index2 = hash2(element);

        if (!buckets[index1].contains(element)) {
            buckets[index1].add(element);
        } else if (!buckets[index2].contains(element)) {
            buckets[index2].add(element);
        } else {
            rehashAndAdd(element);
        }
    }

    public boolean contains(T element) {
        int index1 = hash1(element);
        int index2 = hash2(element);
        return buckets[index1].contains(element) || buckets[index2].contains(element);
    }

    private void rehashAndAdd(T element) {
        List<T>[] backup = buckets.clone();
        initializeBuckets();

        for (List<T> bucket : backup) {
            for (T item : bucket) {
                add(item);
            }
        }

        int index1 = hash1(element);
        int index2 = hash2(element);

        if (buckets[index1].size() < bucketSize) {
            buckets[index1].add(element);
        } else if (buckets[index2].size() < bucketSize) {
            buckets[index2].add(element);
        } else {
            int randomIndex = random.nextInt(2);
            int indexToEvict = (randomIndex == 0) ? index1 : index2;
            int evictedIndex = random.nextInt(bucketSize);

            T evictedElement = buckets[indexToEvict].get(evictedIndex);
            buckets[indexToEvict].set(evictedIndex, element);
            rehashAndAdd(evictedElement); // Recursively rehash and add the evicted element
        }
    }

    private int hash1(T element) {
        return Math.abs(element.hashCode() % size);
    }

    private int hash2(T element) {
        return Math.abs((element.hashCode() / size) % size);
    }

    public static void main(String[] args) {
        // Create a Cuckoo filter with a size of 10 and bucket size of 4
        CuckooFilter<String> cuckooFilter = new CuckooFilter<>(10, 4);

        // Add elements to the filter
        cuckooFilter.add("apple");
        cuckooFilter.add("banana");
        cuckooFilter.add("cherry");

        // Check membership
        System.out.println("Contains apple: " + cuckooFilter.contains("apple"));     // true
        System.out.println("Contains orange: " + cuckooFilter.contains("orange"));   // false
        System.out.println("Contains cherry: " + cuckooFilter.contains("cherry"));   // true
    }
}

