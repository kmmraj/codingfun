package com.test.crypto;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class Argon2KeyGeneration {

    public static void main(String[] args) {
        String key = getDerivedKey("myPassword123%$#$#");

        // Print the key (in bytes)
        System.out.println("Generated Key (Bytes): " + key);

        // Print the key as a hexadecimal string
        System.out.println("Generated Key (Hex): " + byteArrayToHexString(key.getBytes()));
    }

    public static String getDerivedKey(String passwordInput) {
        // Parameters for Argon2
        int iterations = 10;
        int memory = 65536; // in KB
        int parallelism = 1;

        // Password or passphrase
        char[] password = passwordInput.toCharArray();

        // Generate the key using Argon2
        Argon2 argon2 = Argon2Factory.create();
        String key = argon2.hash(iterations, memory, parallelism, password);

        // Clean up the Argon2 instance
        argon2.wipeArray(password);
        return key;
    }

    // Convert a byte array to a hexadecimal string
    private static String byteArrayToHexString(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xFF & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
