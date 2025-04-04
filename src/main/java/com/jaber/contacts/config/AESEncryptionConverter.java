package com.jaber.contacts.config;


import jakarta.annotation.PostConstruct;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;


@Converter
public class AESEncryptionConverter implements AttributeConverter<String, String> {

    @Value("${aes.secret.key}")
    private String key;

    SecretKey secretKey;

    @PostConstruct
    public void init() {
        byte[] decodedKey = Base64.getDecoder().decode(key);
        byte[] aesKey = Arrays.copyOf(decodedKey, 32);
        secretKey = new SecretKeySpec(aesKey, "AES");
    }

    @Override
    public String convertToDatabaseColumn(String field) {
        try {
            System.out.println("AESEncryptionConverter.convertToDatabaseColumn");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encrypted = cipher.doFinal(field.getBytes());
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (GeneralSecurityException e) {
            throw new RuntimeException("Failed to encrypt", e);
        }

    }

    @Override
    public String convertToEntityAttribute(String field) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            System.out.println("AESEncryptionConverter.convertToEntityAttribute");
            byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(field));
            return new String(decrypted);
        } catch (GeneralSecurityException e) {
            throw new RuntimeException("Failed to decrypt", e);
        }
    }
}
