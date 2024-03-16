package com.test.binarysearch;

import java.util.BitSet;
import java.util.Iterator;

public class FindMissingElement {
    private static final int NUM_BUCKET = 1 << 16;

    public static int findMissingElement(Iterable<Integer> sequence) {
        int[] counter = new int[NUM_BUCKET];
        Iterator<Integer> s = sequence.iterator();
        while (s.hasNext()) {
            int idx = s.next() >>> 16;
            ++counter[idx];
        }
        for (int i = 0; i < counter.length; ++i) {
        // Look for a bucket that contains less than NUN_BUCKET elements.
            if (counter[i] < NUM_BUCKET) {
                BitSet bitVec = new BitSet(NUM_BUCKET);
                s = sequence.iterator(); // Search from the beginning again.
                while (s.hasNext()) {
                    int x = s.next();
                    if (i == (x >>> 16)) {
                        bitVec.set(((NUM_BUCKET) - 1) & x); // Gets the lower 16 bits of x.
                    }
                }

                for (int j = 0; j < (1 << 16); ++j) {
                    if (!bitVec.get(j)) {
                        return (i << 16) | j;
                    }
                }
            }
        }
        return -1; // no missing element.
    }
}
