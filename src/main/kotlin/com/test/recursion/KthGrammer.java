package com.test.recursion;

public class KthGrammer {

    public int kthGrammar(int N, int K) {
        // BC
        if(N==1 && K==1)
            return 0;

        // Hypothesis
        int mid = (int) (Math.pow(2,N-1) / 2);
        if(K <=  mid) {
            return kthGrammar(N-1,K);
        } else {
            return kthGrammar(N-1,K-mid) == 0 ? 1: 0;
        }

        // Induction


    }

    public static void main(String[] args) {
        KthGrammer grammer = new KthGrammer();
        int answer;
//        answer  = grammer.kthGrammar(1,1);
//        System.out.println("(1,1) :"+answer);
//
//        answer  = grammer.kthGrammar(2,2);
//        System.out.println("(2,2) :"+answer);

        answer  = grammer.kthGrammar(4,7);
        System.out.println("(2,2) :"+answer);
    }
}
