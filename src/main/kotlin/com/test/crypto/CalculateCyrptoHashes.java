package com.test.crypto;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;

public class CalculateCyrptoHashes {

    //  Write a program to calculate hashes of given text message: SHA-224, SHA-256, SHA3-224, SHA3-384, Keccak-384 and Whirlpool.
    //  The program should take the text message as input and print the hashes in the following format:

    private static String sha224(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-224");
        byte[] messageDigest = md.digest(input.getBytes());
        return convertByteToHex(messageDigest);
    }

    private static String sha256(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] messageDigest = md.digest(input.getBytes());
        return convertByteToHex(messageDigest);
    }

    private static String sha3_224(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA3-224");
        byte[] messageDigest = md.digest(input.getBytes());
        return convertByteToHex(messageDigest);
    }

    private static String sha3_384(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA3-384");
        byte[] messageDigest = md.digest(input.getBytes());
        return convertByteToHex(messageDigest);
    }

    private static String keccak_384(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("Keccak-384");
        byte[] messageDigest = md.digest(input.getBytes());
        return convertByteToHex(messageDigest);
    }

    private static String whirlpool(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("Whirlpool");
        byte[] messageDigest = md.digest(input.getBytes());
        return convertByteToHex(messageDigest);
    }

    private static String convertByteToHex(byte[] messageDigest) {
        StringBuilder hexString = new StringBuilder();
        for (byte digest : messageDigest) {
            String hex = Integer.toHexString(0xff & digest);
            if (hex.length() == 1)
                hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    //HMAC Calculation
    //https://www.baeldung.com/java-hmac
    //https://www.baeldung.com/java-hmac-sha
    //https://www.baeldung.com/java-hmac-sha256
    //https://www.baeldung.com/java-hmac-sha512

    private static String hmac(String algorithm, String data, String key) throws NoSuchAlgorithmException, InvalidKeyException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), algorithm);
        Mac mac = Mac.getInstance(algorithm);
        mac.init(secretKeySpec);
        return convertByteToHex(mac.doFinal(data.getBytes()));
    }



    public static void main(String[] args) {


        for (Provider provider : Security.getProviders()) {
            System.out.println("Provider: " + provider.getName());
            for (Provider.Service service : provider.getServices()) {
                System.out.println("  Algorithm: " + service.getAlgorithm());
            }
        }

        String input = "hello";
        try {
            System.out.println("SHA-224: " + sha224(input));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("SHA-256: " + sha256(input));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("SHA3-224: " + sha3_224(input));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("SHA3-384: " + sha3_384(input));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Keccak-384: " + keccak_384(input));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Whirlpool: " + whirlpool(input));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        //HMAC
        try {
            System.out.println("HMAC: " + hmac("HmacSHA384", input, "cryptography"));
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("HMAC: " + hmac("HmacSHA384", input, "again"));
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }

    }
}
