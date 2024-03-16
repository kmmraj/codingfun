package com.test.hashtable;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    LinkedHashMap<Integer, Integer> isbnToPrice;

    LRUCache(final int capacity) {
        this.isbnToPrice = new LinkedHashMap<>(capacity, 1.0f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> e) {
                return this.size() > capacity;
            }
        };
    }

    public Integer lookup(Integer key) {
        if (!isbnToPrice.containsKey(key)) {
            return null;
        }
        return isbnToPrice.get(key);
    }

    public Integer insert(Integer key, Integer value) {
        // We add the value for key only if key is not present - we don’t update // existing values.
        Integer currentValue = isbnToPrice.get(key);
        if (!isbnToPrice.containsKey(key)) {
            isbnToPrice.put(key, value);
            return currentValue;
        } else {
            return null;
        }
    }


    public Integer erase(Object key) {
        return isbnToPrice.remove(key);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(4);
        lruCache.insert(1, 1);
        lruCache.insert(2, 2);
        lruCache.insert(3, 3);
        lruCache.insert(4, 4);
        System.out.println("lruCache.lookup(1) = " + lruCache.lookup(1));
        lruCache.insert(5, 5);
        System.out.println("lruCache.lookup(2) = " + lruCache.lookup(2));
        lruCache.erase(1);
        System.out.println("lruCache.lookup(1) = " + lruCache.lookup(1));
        lruCache.insert(6, 6);
        System.out.println("lruCache.lookup(3) = " + lruCache.lookup(3));
        lruCache.insert(7, 7);
        System.out.println("lruCache.lookup(4) = " + lruCache.lookup(4));
        lruCache.insert(8, 8);
        System.out.println("lruCache.lookup(5) = " + lruCache.lookup(5));
        lruCache.insert(9, 9);
        System.out.println("lruCache.lookup(6) = " + lruCache.lookup(6));
        lruCache.insert(10, 10);
        System.out.println("lruCache.lookup(7) = " + lruCache.lookup(7));
        lruCache.insert(11, 11);
        System.out.println("lruCache.lookup(8) = " + lruCache.lookup(8));
    }

}
