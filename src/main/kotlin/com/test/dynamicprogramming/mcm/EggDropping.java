package com.test.dynamicprogramming.mcm;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class EggDropping {

    int[][] dpT;

    //1. Identify i and j (i=1, j= N)
    //2. BC  if(K==0) return N  if(N==0 || N==1) return N
    //3. K loop (for idx=1; idx<=K; idx++)
    //4. Derive answer
    // worst case of attempts
    // attempts = 0
    // Broken Egg: superEggDrop(K-1,N-1),
    // Non Broken Egg: superEggDrop(K,N-idx)
    // attempt ++;
    // Worst case ? Math.max
    // Minimize the attempts

    public int superEggDrop(int K, int N) {

        //BC

        if(N==0 || N==1)
            return N;
        if(K==1)
            return N;


        // K Loop
        int attempt =1;
        int minAttempt = Integer.MAX_VALUE;

        for (int idx = 1; idx <= N ; idx++) {
            int worstCase = attempt
                    + Math.max(
                            superEggDrop(K-1,idx-1), // Broken Egg
                    superEggDrop(K,N-idx)); // Non Broken Egg

            minAttempt =  Math.min(minAttempt,worstCase);
        }

        return minAttempt;
    }

    public int superEggDropMemonized(int K, int N) {

        dpT = new int[K + 1][N + 1];
        for (int idx = 0; idx <= K; idx++) {
            Arrays.fill(dpT[idx], -1);
        }

        return solveIt(K, N);
    }

    public int superEggDropBSearchMemoized(int K, int N) {

        dpT = new int[K + 1][N + 1];
        for (int idx = 0; idx <= K; idx++) {
            Arrays.fill(dpT[idx], -1);
        }

        return solveItBTreeMemoized(K, N);
    }

    private int solveItBTreeMemoized(int noOfEggs, int noOfFloors) {
        //BC

        // if no of floor is 0 or 1, then irrespective of number of eggs, you need only 1 egg,
        // number of tries is floor count.
        if(noOfFloors==0 || noOfFloors==1)
            return noOfFloors;
        // if you have one egg, irresoective of number of floors, you need to drop it all floors,
        // number of tries is floor count.
        if(noOfEggs==1)
            return noOfFloors;

        if(dpT[noOfEggs][noOfFloors] !=-1){
            return dpT[noOfEggs][noOfFloors];
        }

        // noOfEggs Loop
        int anAttempt = 1;
        int minAttempt = Integer.MAX_VALUE;

        int low = 1;
        int high = noOfFloors;

        while (low <= high) {
            int mid = low + (high-low)/2;
            int brokenAttempt;
            int nonBrokenAttempt;

            if(dpT[noOfEggs-1][mid-1] == -1){
                brokenAttempt =  solveItBTreeMemoized(noOfEggs-1,mid-1); // Broken Egg
                dpT[noOfEggs-1][mid-1] = brokenAttempt;
            } else {
                brokenAttempt = dpT[noOfEggs-1][mid-1];

            }

            if(dpT[noOfEggs][noOfFloors-mid] ==-1){
                nonBrokenAttempt =  solveItBTreeMemoized(noOfEggs,noOfFloors-mid); // Non Broken Egg
                dpT[noOfEggs][noOfFloors-mid] = nonBrokenAttempt;
            } else {
                nonBrokenAttempt = dpT[noOfEggs][noOfFloors-mid];
            }

            int worstCase = anAttempt
                    + Math.max(
                    brokenAttempt,
                    nonBrokenAttempt);

            minAttempt =  Math.min(minAttempt,worstCase);

            if(brokenAttempt == nonBrokenAttempt) // left == right
                break;
            else if(brokenAttempt < nonBrokenAttempt) // left < right
                low = mid+1;
            else high = mid-1;
        }

        return dpT[noOfEggs][noOfFloors] = minAttempt;
    }
    private int solveIt(int K, int N) {
        //BC

        if(N==0 || N==1)
            return N;
        if(K==1)
            return N;

        if(dpT[K][N] !=-1){
            return dpT[K][N];
        }

        // K Loop
        int attempt =1;
        int minAttempt = Integer.MAX_VALUE;

        for (int idx = 1; idx <= N ; idx++) {

            int brokenAttempt;
            int nonBrokenAttempt;

            if(dpT[K-1][idx-1] == -1){
                brokenAttempt =  solveIt(K-1,idx-1); // Broken Egg
                dpT[K-1][idx-1] = brokenAttempt;
            } else {
                brokenAttempt = dpT[K-1][idx-1];

            }

            if(dpT[K][N-idx] ==-1){
                nonBrokenAttempt =  solveIt(K,N-idx); // Non Broken Egg
                dpT[K][N-idx] = nonBrokenAttempt;
            } else {
                nonBrokenAttempt = dpT[K][N-idx];
            }
            int worstCase = attempt
                    + Math.max(
                    brokenAttempt,
                    nonBrokenAttempt);

            minAttempt =  Math.min(minAttempt,worstCase);
            //dpT[]
        }

        return dpT[K][N] = minAttempt;
    }

    private int solveItMemoized(int K, int N) {
        //BC

        if(N==0 || N==1)
            return N;
        if(K==1)
            return N;


        // K Loop
        int attempt =1;
        int minAttempt = Integer.MAX_VALUE;

        for (int idx = 1; idx <= N ; idx++) {

            int brokenAttempt;
            int nonBrokenAttempt;

            if(dpT[K-1][idx-1] == -1){
                brokenAttempt =  solveIt(K-1,idx-1); // Broken Egg
                dpT[K-1][idx-1] = brokenAttempt;
            } else {
                brokenAttempt = dpT[K-1][idx-1];
            }

            if(dpT[K][N-idx] ==-1){
                nonBrokenAttempt =  solveIt(K,N-idx); // Non Broken Egg
                dpT[K][N-idx] = nonBrokenAttempt;
            } else {
                nonBrokenAttempt = dpT[K][N-idx];
            }
            int worstCase = attempt
                    + Math.max(
                    brokenAttempt,
                    nonBrokenAttempt);

            minAttempt =  Math.min(minAttempt,worstCase);
            //dpT[]
        }

        return minAttempt;
    }



    public static void main(String[] args) {
        EggDropping dropping = new EggDropping();
        System.out.println(dropping.superEggDropBSearchMemoized(1,2));
        System.out.println(dropping.superEggDropBSearchMemoized(2,6));

        Instant start = Instant.now();
        System.out.println(dropping.superEggDropBSearchMemoized(100,10000));
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start,end);
        System.out.println("Time taken: "+timeElapsed.toMillis());

        start = Instant.now();
      //  System.out.println(dropping.superEggDrop(10,30));
        end = Instant.now();
        timeElapsed = Duration.between(start,end);
        System.out.println("Time taken: "+timeElapsed.toMillis());
    }
}
