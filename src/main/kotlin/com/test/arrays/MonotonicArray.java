package com.test.arrays;

public class MonotonicArray {
    public static boolean isMonotonic(int[] array) {
        boolean isUpwardTrend = false;
        boolean isDownwardTrend= false;
        for (int idx = 1; idx < array.length; idx++) {
            if(array[idx] == array[idx-1]){
                continue;
            }
            if(array[idx] > array[idx-1]){
                isUpwardTrend = true;
            } else {
                isDownwardTrend = true;
            }
            if(isDownwardTrend && isUpwardTrend){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int [] array = new int[] {-1, -5, -10, -1100, -1100, -2, -1101, -1102, -9001};
        boolean expected = true;
        System.out.println(MonotonicArray.isMonotonic(array));
    }
}
