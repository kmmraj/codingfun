package com.test.crypto;


import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;

public class AESGCMProvider {

    protected static final int GCM_IV_LENGTH = 12; // in bytes

    public static void main(String[] args) throws Exception {
        // The data to be encrypted
        String plaintext = "Hello, AES-GCM!";

        // Generate a random encryption key
        String secretKeyString = Argon2KeyGeneration.getDerivedKey("password1337%#$");
        // Create the SecretKey using SecretKeySpec
        SecretKey secretKey = new SecretKeySpec(secretKeyString.getBytes(), "AES");

        // Encrypt the data
        String encryptedData = encryptAESGCM(plaintext, secretKey);

        // Decrypt the encrypted data
        String decryptedData = decryptAESGCM(encryptedData, secretKey);

        System.out.println("Original Text: " + plaintext);
        System.out.println("Encrypted Text: " + encryptedData);
        System.out.println("Decrypted Text: " + decryptedData);
    }



    private static String encryptAESGCM(String plaintext, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        byte[] iv = new byte[128]; // 96 bits
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(iv);
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(128, iv);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, gcmParameterSpec);

        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    private static String decryptAESGCM(String encryptedText, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        byte[] iv = new byte[12]; // 96 bits
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(128, iv);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, gcmParameterSpec);

        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }
}

