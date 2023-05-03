package com.test.arrays;

public class ValidStartingCity {
    public int validStartingCity(int[] distances, int[] fuel, int mpg) {
        // Write your code here.
        int distanceToTravel=0;
        int fuelRemaining =0;
        int minGasLeft = Integer.MAX_VALUE;
        int minGasCity =0;
        for (int idx = 0; idx < distances.length; idx++) {
            distanceToTravel = distances[idx];
             fuelRemaining =  ((fuel[idx] * mpg) +fuelRemaining)  - distanceToTravel;

            if(fuelRemaining < minGasLeft){
                minGasLeft = fuelRemaining;
                minGasCity = idx;
            }


        }
        return (minGasCity+1)%distances.length;
    }

    public static void main(String[] args) {
        TestCase1();
    }

    public static void TestCase1() {
        int[] distances = new int[] {5, 25, 15, 10, 15};
        int[] fuel = new int[] {1, 2, 1, 0, 3};
        int mpg = 10;
        int expected = 4;
        int actual = new ValidStartingCity().validStartingCity(distances, fuel, mpg);
        System.out.println(expected == actual);
    }
}
