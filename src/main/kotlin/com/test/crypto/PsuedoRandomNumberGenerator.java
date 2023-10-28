package com.test.crypto;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PsuedoRandomNumberGenerator {

    //Exercises: Pseudo-Random Generator
    //Write a code to generate 30 pseudo-random integers in the range [1...10], starting from certain entropy, taken as input, using HMAC key derivation.
    //From the entropy generate a seed (256-bit binary sequence) using SHA-256:
    //seed = SHA256(entropy)
    //Generate the n-th random number by the formula:
    //1 + HMAC-SHA256(n, seed) % 10
    //Print the numbers at the output, separated by space.
    //Sample input and corresponding output:
    //Input
    //Output
    //hello
    //8 4 10 5 5 3 5 7 10 6 4 9 2 3 2 8 3 3 10 6 8 10 9 10 1 3 6 4 4 10
    //random text
    //10 5 5 9 7 4 2 9 2 1 10 4 8 9 8 1 8 6 5 7 5 4 3 4 6 6 9 8 1 1
    //fun
    //6 5 9 2 2 5 1 6 10 10 10 1 8 10 6 9 2 1 5 10 1 4 8 5 6 3 8 4 2 1

    public static void main(String[] args) throws Exception {
        // Input entropy as a string
        String entropy = "hello";

        // Convert entropy to seed using SHA-256
        byte[] seed = sha256(entropy.getBytes());

        // Generate and print 30 random numbers in the range [1...10]
        for (int n = 1; n <= 30; n++) {
            int randomNumber = generateRandomNumber(n, seed);
            System.out.print(randomNumber + " ");
        }
    }

    private static byte[] sha256(byte[] input) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return md.digest(input);
    }

    private static int generateRandomNumber(int n, byte[] seed) throws Exception {
        Mac hmac = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKeySpec = new SecretKeySpec(seed, "HmacSHA256");
        hmac.init(secretKeySpec);

        byte[] hash = hmac.doFinal(intToBytes(n));
        int value = byteArrayToInt(hash);

        return 1 + Math.abs(value % 10);
    }

    private static byte[] intToBytes(int value) {
        byte[] result = new byte[4];
        for (int i = 3; i >= 0; i--) {
            result[i] = (byte) (value & 0xFF);
            value >>= 8;
        }
        return result;
    }

    private static int byteArrayToInt(byte[] bytes) {
        int value = 0;
        for (byte b : bytes) {
            value = (value << 8) | (b & 0xFF);
        }
        return value;
    }
}
