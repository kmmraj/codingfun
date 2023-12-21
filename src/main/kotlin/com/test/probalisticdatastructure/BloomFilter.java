package com.test.probalisticdatastructure;

import java.util.BitSet;

public class BloomFilter<T> {
    private final BitSet bitSet;
    private final int size;
    private final int numHashFunctions;

    public BloomFilter(int size, int numHashFunctions) {
        this.bitSet = new BitSet(size);
        this.size = size;
        this.numHashFunctions = numHashFunctions;
    }

    public void add(T element) {
        for (int i = 0; i < numHashFunctions; i++) {
            int hash = hash(element, i);
            bitSet.set(Math.abs(hash) % size, true);
        }
    }

    public boolean contains(T element) {
        for (int i = 0; i < numHashFunctions; i++) {
            int hash = hash(element, i);
            if (!bitSet.get(Math.abs(hash) % size)) {
                return false; // If any bit is not set, the element is definitely not in the set
            }
        }
        return true; // All bits are set, indicating a potential membership
    }

    private int hash(T element, int hashFunctionIndex) {
        return Math.abs(element.hashCode() + hashFunctionIndex * element.hashCode());
    }

    public static void main(String[] args) {
        // Create a Bloom filter with a size of 20 and 3 hash functions
        BloomFilter<String> bloomFilter = new BloomFilter<>(20, 3);

        // Add elements to the filter
        bloomFilter.add("apple");
        bloomFilter.add("banana");
        bloomFilter.add("cherry");

        // Check membership
        System.out.println("Contains apple: " + bloomFilter.contains("apple"));     // true
        System.out.println("Contains orange: " + bloomFilter.contains("orange"));   // false
        System.out.println("Contains cherry: " + bloomFilter.contains("cherry"));   // true
    }
}

