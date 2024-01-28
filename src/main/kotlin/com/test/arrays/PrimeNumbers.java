package com.test.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeNumbers {

    private static int[] generatePrimeNumbers(int number) {
        List<Integer> primeNumbers = new ArrayList<>();
        boolean[] isPrime = new boolean[number+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        isPrime[2] = true;
        int index=2;
        while(index<=number){
            if(isPrime[index]){
                primeNumbers.add(index);
                for(int idx=index; idx<number;idx=idx+index){
                    isPrime[idx] = false;
                }
            }
            index++;
        }
      // return primeNumbers.stream().mapToInt(Integer::intValue).toArray();
        return primeNumbers.stream().mapToInt(i->i).toArray();
    }
    public static void main(String[] args) {

        System.out.println("Generate primeNumbers until 19 "
                + Arrays.toString(PrimeNumbers.generatePrimeNumbers(19)));

        System.out.println("Generate primeNumbers until 100 "
                + Arrays.toString(PrimeNumbers.generatePrimeNumbers(100)));

    }


}
