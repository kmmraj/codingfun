package com.test.bitwise;

public class BitWiseComplement {
    // Option#1
    public int bitwiseComplement(int n) {
        if (n==0) return 1;
        //  System.out.println(" n is "+n +" bitString is "+Integer.toBinaryString(n));
        StringBuffer sb = new StringBuffer();
        while(n!=0){
            int complementValue = n%2 ==0 ? 1: 0;
            sb.append(complementValue);
            n = n/2;
        }
        String bitString = sb.reverse().toString();
        // System.out.println(" n is " +n+ " Complent String is "+bitString);
        int result=0;
        int factor = 1;
        for(int idx=bitString.length()-1;idx>=0; idx--){
            // System.out.println("bitString.charAt(idx) is " + bitString.charAt(idx));
            // System.out.println("bitString.charAt(idx) -'0' is " + (bitString.charAt(idx)-'0'));
            int intValue = (int)bitString.charAt(idx)-'0';
            // int complementValue = intValue==0 ? 1: 0;
            result = result + ((intValue) * factor); // Complement here
            // System.out.println("result is "+result);
            factor = factor * 2;
        }
        return result;
    }

    public int bitwiseComplement2(int n) {
        if (n==0) return 1;
        int result=0;
        int factor = 1;
        while(n!=0){
            int complementValue = n%2 ==0 ? 1: 0;
            result = result + ((complementValue) * factor);
            // System.out.println("result is "+result);
            factor = factor * 2;
            n = n/2;
        }
        return result;
    }

    public int bitwiseComplement2_1(int n) {
        if (n==0) return 1;
        int result=0;
        int factor = 1;
        while(n!=0){
//            int complementValue = n%2 ==0 ? 1: 0;
            System.out.println("n is "+n+ " n>>1 &1 is "+(n>>1 & 1) + " n>>1^1 is "+((n>>1 & 1)));
            int complementValue = ((n>>1 & 1)^1);
            System.out.println("complementValue is "+complementValue);
            result = result + ((complementValue) * factor);
            // System.out.println("result is "+result);
            factor = factor * 2;
            n = n/2;
        }
        return result;
    }

    public int bitwiseComplement3(int N) {
        int bigNumWithOnly1S = 1;
        while ( bigNumWithOnly1S < N) {
            bigNumWithOnly1S = bigNumWithOnly1S * 2 + 1;
            // 1, 11, 111, 1111, 11111, 111111, 1111111, 11111111
            // 1, 1*2+1=3, 3*2+1=7, 7*2+1=15, 15*2+1=31, 31*2+1=63, 63*2+1=127, 127*2+1=255
        }
        return N ^ bigNumWithOnly1S;
    }


    public static void main(String[] args) {
        BitWiseComplement bitWiseComplement = new BitWiseComplement();
        System.out.println("bitWiseComplement.bitwiseComplement(5) and the value should be 2 and it is = "
                + bitWiseComplement.bitwiseComplement(5));
        System.out.println("bitWiseComplement.bitwiseComplement2(5) and the value should be 2 and it is = "
                + bitWiseComplement.bitwiseComplement2(5));
        System.out.println("bitWiseComplement.bitwiseComplement2_1(5) and the value should be 2 and it is = "
                + bitWiseComplement.bitwiseComplement2_1(5));
        System.out.println("bitWiseComplement.bitwiseComplement3(5) and the value should be 2 and it is = "
                + bitWiseComplement.bitwiseComplement3(5));

        System.out.println("bitWiseComplement.bitwiseComplement(7) and the value should be 0 and it is = "
                + bitWiseComplement.bitwiseComplement(7));
        System.out.println("bitWiseComplement.bitwiseComplement2(7) and the value should be 0 and it is = "
                + bitWiseComplement.bitwiseComplement2(7));
        System.out.println("bitWiseComplement.bitwiseComplement2_1(7) and the value should be 0 and it is = "
                + bitWiseComplement.bitwiseComplement2_1(7));
        System.out.println("bitWiseComplement.bitwiseComplement3(7) and the value should be 0 and it is = "
                + bitWiseComplement.bitwiseComplement3(7));

        System.out.println("bitWiseComplement.bitwiseComplement(10) and the value should be 5 and it is = "
                + bitWiseComplement.bitwiseComplement(10));
        System.out.println("bitWiseComplement.bitwiseComplement2(10) and the value should be 5 and it is = "
                + bitWiseComplement.bitwiseComplement2(10));
        System.out.println("bitWiseComplement.bitwiseComplement2_1(10) and the value should be 5 and it is = "
                + bitWiseComplement.bitwiseComplement2_1(10));
        System.out.println("bitWiseComplement.bitwiseComplement3(10) and the value should be 5 and it is = "
                + bitWiseComplement.bitwiseComplement3(10));

    }
}
