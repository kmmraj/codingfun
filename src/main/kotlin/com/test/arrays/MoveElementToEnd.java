package com.test.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveElementToEnd {
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int idx = 0;
        int jdx = array.size()-1;
        while (idx < jdx) {
            if (array.get(idx) == toMove) {
                array.remove(idx);
                array.add(toMove);
                jdx--;
            } else {
                idx++;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<Integer>(Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2));
        int toMove = 2;
        List<Integer> expectedStart = new ArrayList<Integer>(Arrays.asList(1, 3, 4));
        List<Integer> expectedEnd = new ArrayList<Integer>(Arrays.asList(2, 2, 2, 2, 2));
        List<Integer> output = MoveElementToEnd.moveElementToEnd(array, toMove);
        for (int idx = 0; idx < output.size(); idx++) {
            System.out.printf("%2d ", output.get(idx));
        }
    }
}
