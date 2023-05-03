package com.test.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ClassPhotos {
    public boolean classPhotos(
            ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        // Write your code here.
        boolean redShirtback = false;
        Collections.sort(redShirtHeights,Collections.reverseOrder());
        Collections.sort(blueShirtHeights,Collections.reverseOrder());
        if(redShirtHeights.get(0) > blueShirtHeights.get(0))
            redShirtback = true;
        for (int idx = 0; idx < redShirtHeights.size(); idx++) {
            if(redShirtback){
              if(redShirtHeights.get(idx) <= blueShirtHeights.get(idx))
                  return false;
            } else {
                if(blueShirtHeights.get(idx) <= redShirtHeights.get(idx))
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        TestCase1();
        TestCase2();
        TestCase3();
        TestCase4();
    }

    public static void TestCase1() {
        ArrayList<Integer> redShirtHeights = new ArrayList<Integer>(Arrays.asList(5, 8, 1, 3, 4));
        ArrayList<Integer> blueShirtHeights = new ArrayList<Integer>(Arrays.asList(6, 9, 2, 4, 5));
        boolean expected = true;
        boolean actual = new ClassPhotos().classPhotos(redShirtHeights, blueShirtHeights);
        System.out.println(expected == actual);
    }

    public static void TestCase2() {
        ArrayList<Integer> blueShirtHeights = new ArrayList<Integer>(Arrays.asList(5, 4));
        ArrayList<Integer> redShirtHeights = new ArrayList<Integer>(Arrays.asList(5, 6));
        boolean expected = true;
        boolean actual = new ClassPhotos().classPhotos(redShirtHeights, blueShirtHeights);
        System.out.println(expected == actual);
    }
    public static void TestCase3() {
        ArrayList<Integer> blueShirtHeights = new ArrayList<Integer>(Arrays.asList(2, 4, 7, 5, 1));
        ArrayList<Integer> redShirtHeights = new ArrayList<Integer>(Arrays.asList(3, 5, 6, 8, 2));
        boolean expected = true;
        boolean actual = new ClassPhotos().classPhotos(redShirtHeights, blueShirtHeights);
        System.out.println(expected == actual);
    }

    public static void TestCase4() {
        ArrayList<Integer> blueShirtHeights = new ArrayList<Integer>(Arrays.asList(5, 8, 1, 3, 4, 9));
        ArrayList<Integer> redShirtHeights = new ArrayList<Integer>(Arrays.asList(6, 9, 2, 4, 5, 1));
        boolean expected = false;
        boolean actual = new ClassPhotos().classPhotos(redShirtHeights, blueShirtHeights);
        System.out.println(expected == actual);
    }
}
