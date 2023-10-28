package com.test.crypto;

import org.bouncycastle.crypto.generators.Argon2BytesGenerator;
import org.bouncycastle.crypto.params.Argon2Parameters;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
//import org.apache.commons.codec.digest.SCrypt;



public class KDF {

    //The PBKDF2 calculation function takes several input parameters:
    // hash function for the HMAC, the password (bytes sequence),
    // the salt (bytes sequence),
    // iterations count and
    // the output key length (number of bytes for the derived key).

    private static String pbkdf2(String algorithm,
                                 String input,
                                 String salt,
                                 int count,
                                 int keyLength) throws
            NoSuchAlgorithmException, InvalidKeyException {
        SecretKeySpec keySpec = new SecretKeySpec(input.getBytes(), algorithm);
        Mac mac = Mac.getInstance(algorithm);
        mac.init(keySpec);
        byte[] result = mac.doFinal(salt.getBytes());
        for (int i = 1; i < count; i++) {
            result = mac.doFinal(result);
        }
        return convertByteToHex(result);
    }

    private static String pbkdf2_Alt(final char[] password, final byte[] salt, final int iterations, final int keyLength) {

        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, keyLength);
            SecretKey key = skf.generateSecret(spec);
            byte[] result = key.getEncoded();
            return convertByteToHex(result);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
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

    //write some code to derive a key from a password using the Scrypt algorithm

    public static byte[] deriveKey(String password, byte[] salt, int n, int r, int p) {
        SecureRandom random = new SecureRandom();
//        return SCrypt.scrypt(password.getBytes(), salt, n, r, p, random);
        return null;
    }

    private static byte[] generateSalt16Byte() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);

        return salt;
    }


    private static void argon2() {
        byte[] salt = generateSalt16Byte();
        String password = "mohan8383377^#%#%";

        int iterations = 2;
        int memLimit = 66536;
        int hashLength = 32;
        int parallelism = 1;

        Argon2Parameters.Builder builder = new Argon2Parameters.Builder(Argon2Parameters.ARGON2_id)
                .withVersion(Argon2Parameters.ARGON2_VERSION_13)
                .withIterations(iterations)
                .withMemoryAsKB(memLimit)
                .withParallelism(parallelism)
                .withSalt(salt);

        Argon2BytesGenerator generate = new Argon2BytesGenerator();
        generate.init(builder.build());
        byte[] result = new byte[hashLength];
        generate.generateBytes(password.getBytes(StandardCharsets.UTF_8), result, 0, result.length);

        Argon2BytesGenerator verifier = new Argon2BytesGenerator();
        verifier.init(builder.build());
        byte[] testHash = new byte[hashLength];
        verifier.generateBytes(password.getBytes(StandardCharsets.UTF_8), testHash, 0, testHash.length);

        System.out.println(bytesToHex(result));
        System.out.println(bytesToHex(testHash));

       // Argon2.
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }








public static void main(String[] args) {
        try {
            System.out.println(KDF.pbkdf2("HmacSHA256", "password", "salt", 10000, 512));
            System.out.println(KDF.pbkdf2_Alt( "password".toCharArray(), "salt".getBytes(), 10000, 512));
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }

        // Log the time taken to generate the hash
        long startTime = System.nanoTime();
        argon2();
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("Execution time in nanoseconds: " + timeElapsed);
        System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);

    }
}
