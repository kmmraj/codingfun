package com.test.arrays.random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class NonUniformRandomNumbers {

    List<Double> prefixSumOfProbabilities = new ArrayList<>();
    List<Integer> values = new ArrayList<>();

    Random r = new Random();

    //https://leetcode.com/problems/random-pick-with-weight/

    //Given an array of positive integers w. where w[i] describes the weight of ith index (0-indexed).
    //
    //We need to call the function pickIndex() which randomly returns an integer in the range [0, w.length - 1].
    //pickIndex() should return the integer proportional to its weight in the w array.
    //For example, for w = [1, 3], the probability of picking the index 0 is 1 / (1 + 3) = 0.25
    // (i.e 25%) while the probability of picking the index 1 is 3 / (1 + 3) = 0.75 (i.e 75%).

    //More formally, the probability of picking index i is w[i] / sum(w).

    public NonUniformRandomNumbers(List<Integer> values, List<Double> probabilities) {
//        prefixSumOfProbabilities.add(0.0);
//        // Creating the endpoints for the intervals corresponding to the // probabilities.
//        for (double p : probabilities) {
//            prefixSumOfProbabilities.add(
//                    prefixSumOfProbabilities.get(prefixSumOfProbabilities.size() - 1) + p);
//        }
//        this.values = values;


    }
    public static int nonuniformRandomNumberGeneration(List<Integer> values, List<Double> probabilities) {
        List<Double> prefixSumOfProbabilities = new ArrayList<>();
        prefixSumOfProbabilities.add(0.0);
       // Creating the endpoints for the intervals corresponding to the // probabilities.
        for (double p : probabilities) {
            prefixSumOfProbabilities.add(
                    prefixSumOfProbabilities.get(prefixSumOfProbabilities.size() - 1) + p);
        }

        Random r = new Random();
        // Get a random number in [0.0,1.0)
        final double uniform01 = r.nextDouble();
        // Find the index of the interval that uniformSIl lies in.
        int it = Collections.binarySearch(prefixSumOfProbabilities, uniform01);
        if (it < 0) {
            // We want the index of the first element in the array which is
            // greater than the key.
            //
            // When a key is not present in the array, Collections.binarySearch() // returns the negative of 1 plus the smallest index whose entry
            // is greater than the key.

            // Therefore , if the return value is negative , by taking its absolute // value and adding 1 to it , we get the desired index.
            final int intervalIdx = (Math.abs(it) - 1) - 1;
            return values.get(intervalIdx);
        } else {
            // We have it >= (9, i.e., uniformQl equals an entry // in prefixSumOf Probabilities .
            //
            // Because we uniformQl is a random double, the probability of it
            // equalling an endpoint in prefixSumOfProbabilities is exceedingly low.
            // However, it is not (P, so to be robust we must consider this case.
            return values.get(it);
        }
    }

    public int pickIndex() {
        final double uniform01 = r.nextDouble();
        // Find the index of the interval that uniformSIl lies in.
        int it = Collections.binarySearch(prefixSumOfProbabilities, uniform01);
        if (it < 0) {
            // We want the index of the first element in the array which is
            // greater than the key.
            //
            // When a key is not present in the array, Collections.binarySearch() // returns the negative of 1 plus the smallest index whose entry
            // is greater than the key.

            // Therefore , if the return value is negative , by taking its absolute // value and adding 1 to it , we get the desired index.
            final int intervalIdx = (Math.abs(it) - 1) - 1;
            return values.get(intervalIdx);
        } else {
            // We have it >= (9, i.e., uniformQl equals an entry // in prefixSumOf Probabilities .
            //
            // Because we uniformQl is a random double, the probability of it
            // equalling an endpoint in prefixSumOfProbabilities is exceedingly low.
            // However, it is not (P, so to be robust we must consider this case.
            return values.get(it);
        }
    }

    public static void main(String[] args) {
        NonUniformRandomNumbers nonUniformRandomNumbers = new NonUniformRandomNumbers(List.of(3, 5, 7, 11),
                List.of(9.0 / 18, 6.0 / 18, 2.0 / 18, 1.0 / 18));
        System.out.println("Next pick is "+ nonUniformRandomNumbers.pickIndex());
        System.out.println("Next pick is "+ nonUniformRandomNumbers.pickIndex());
        System.out.println("Next pick is "+ nonUniformRandomNumbers.pickIndex());
        System.out.println("Next pick is "+ nonUniformRandomNumbers.pickIndex());
        System.out.println("Next pick is "+ nonUniformRandomNumbers.pickIndex());
        System.out.println("Next pick is "+ nonUniformRandomNumbers.pickIndex());
        System.out.println("Next pick is "+ nonUniformRandomNumbers.pickIndex());
        System.out.println("Next pick is "+ nonUniformRandomNumbers.pickIndex());
        System.out.println("Next pick is "+ nonUniformRandomNumbers.pickIndex());
        System.out.println("Next pick is "+ nonUniformRandomNumbers.pickIndex());
        System.out.println("Next pick is "+ nonUniformRandomNumbers.pickIndex());
        System.out.println("Next pick is "+ nonUniformRandomNumbers.pickIndex());
        System.out.println("Next pick is "+ nonUniformRandomNumbers.pickIndex());




    }
}
