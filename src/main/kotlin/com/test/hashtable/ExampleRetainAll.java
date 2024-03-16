package com.test.hashtable;

import java.util.HashSet;

public class ExampleRetainAll {
    public static void main(String[] args) {
        try
        {
            HashSet<Integer> hash_set1 = new HashSet<Integer>();
            hash_set1.add(1);
            hash_set1.add(8);
            hash_set1.add(5);
            hash_set1.add(3);
            hash_set1.add(0);

            HashSet<Integer> hash_set2 = new HashSet<Integer>();
            hash_set2.add(8);
            hash_set2.add(1);
            hash_set2.add(3);
            hash_set2.add(4);

            System.out.println("hash_set1 before retainAll() implementation: "+hash_set1);
            System.out.println("Collection that needs to be retained: "+hash_set2);

            hash_set1.retainAll(hash_set2);
            System.out.println("hash_set1 after retainAll() implementation: "+hash_set1);
            System.out.println();

            HashSet<Integer> hash_set3 = null;

            System.out.println("hash_set2 before retainAll() implementation: "+hash_set2);
            System.out.println("Collection that needs to be retained: "+hash_set3);

            hash_set2.retainAll(hash_set3);
            System.out.println("hash_set2 after retainAll() implementation: "+hash_set2);

        }
        catch(NullPointerException e)
        {
            System.out.println("Exception thrown : " + e);
        }

        // Example of removeAll
        HashSet<Integer> hash_set1 = new HashSet<Integer>();
        hash_set1.add(1);
        hash_set1.add(8);
        hash_set1.add(5);
        hash_set1.add(3);
        hash_set1.add(0);

        HashSet<Integer> hash_set2 = new HashSet<Integer>();
        hash_set2.add(8);
        hash_set2.add(1);
        hash_set2.add(3);
        hash_set2.add(4);

        System.out.println("hash_set1 before removeAll() implementation: "+hash_set1);
        System.out.println("Collection that needs to be removed: "+hash_set2);

        hash_set1.removeAll(hash_set2);
        System.out.println("hash_set1 after removeAll() implementation: "+hash_set1);
    }
}
