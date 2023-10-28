package com.test.divideandconquer;

import java.util.*;

public class Fibonancci {

    public static void main(String[] args) {
        List<Integer> integerList = fibonancciTry1(10);
        System.out.println();
       integerList.forEach( num -> System.out.print(num + " , ") );

        System.out.println("Nth Fib Number is "+ Fibonancci.getNthFibNumber(5,new HashMap<>()));
        System.out.println("Nth Fib Number is "+ Fibonancci.getNthFibNumber(6,new HashMap<>()));
        //   System.out.println( Fibonancci.getFibSeries(6));
    }

    private static List<Integer> fibonancciTry1(int maxnumber){
        int num1 = 0;
        int num2 = 1;
        int sum = 0;
        Set<Integer> series = new HashSet<>();
        int index=0;
        series.add(num1);
        series.add(num2);
        while (index+2 < maxnumber){
            series.add(num1);
            sum = num1 + num2;
            num1 = num2;
            num2 = sum;
            series.add(sum);
            index++;
        }
        return series.stream().sorted().toList();
    }

    private static int getNthFibNumber(int fibNum, Map<Integer, Integer> intMap){
        // BC
        if(fibNum == 1 ){
            intMap.put(fibNum,0);
            return 0;
        }
        if( fibNum == 2){
            intMap.put(fibNum,1);
            return 1;
        }
//        if(fibNum == 3){
//            intMap.put(fibNum,2);
//            return 2;
//        }
        if(!intMap.containsKey(fibNum-1)){
            int reduceOne = getNthFibNumber(fibNum-1,intMap);
            intMap.put(fibNum-1,reduceOne);

        }
        if(!intMap.containsKey(fibNum-2)){
            int reduceTwo = getNthFibNumber(fibNum-2,intMap);
            intMap.put(fibNum-2,reduceTwo);
        }


        return  intMap.get(fibNum-1)+ intMap.get(fibNum-2);

    }

    private static void fibonancciRecursive() {
        Set<Integer> series = new HashSet<>();
        series.add(0);
        series.add(1);
        getFibSeries(10, series);
        List<Integer> seriesList = new ArrayList<>(series);
        Collections.sort(seriesList);
        System.out.println(seriesList);
    }

    private static int getFibSeries(int maxnumber, Set<Integer> series) {
        // BC
        if(maxnumber == 1){
             //series.add(0);
             return 0;
        }
        if(maxnumber == 2){
//            series.add(1);
            return 1;
        }
        // I
       int sum =  getFibSeries(maxnumber-2,series) + getFibSeries(maxnumber-1,series);
       series.add(sum);
       return sum;
    }
}
