package com.test.misc;

public class DigitDegree {

    int solution(int n) {
        int counter = 0;
        // if(n<10){
        //     return 0;
        // }
        // if(n%10 ==0){
        //     return 1;
        // }
        //
        while( n >= 10){
            counter++;
            int sum = 0;
            while (n > 0){
                sum = sum + n % 10;
                n = n / 10;
            }
            n = sum;
            //System.out.println("N value is "+ n +" and counter is " + counter);
        }
        return counter;
    }

    public static void main(String[] args) {
        DigitDegree digitDegree = new DigitDegree();
        System.out.println(digitDegree.solution(91));
        System.out.println(digitDegree.solution(100));
        System.out.println(digitDegree.solution(99));
        System.out.println(digitDegree.solution(999));
        System.out.println(digitDegree.solution(887));

    }
}
