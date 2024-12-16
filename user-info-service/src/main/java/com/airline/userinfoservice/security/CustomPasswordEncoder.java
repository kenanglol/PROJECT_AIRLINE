package com.airline.userinfoservice.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Base64;

@Component
public class CustomPasswordEncoder implements PasswordEncoder {
    private static final int SALT_LENGTH = 32;
    
    public String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }
    
    @Override
    public String encode(CharSequence rawPassword) {
        throw new UnsupportedOperationException("Use encode(CharSequence rawPassword, String salt) instead");
    }
    
    public String encode(CharSequence rawPassword, String salt) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-512");
            md.update(Base64.getDecoder().decode(salt));
            byte[] hashedPassword = md.digest(rawPassword.toString().getBytes());
            return Base64.getEncoder().encodeToString(hashedPassword);
        } catch (Exception e) {
            throw new RuntimeException("Şifre hash'leme hatası", e);
        }
    }
    
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        throw new UnsupportedOperationException("Use matches(CharSequence rawPassword, String encodedPassword, String salt) instead");
    }
    
    public boolean matches(CharSequence rawPassword, String encodedPassword, String salt) {
        String newEncodedPassword = encode(rawPassword, salt);
        return encodedPassword.equals(newEncodedPassword);
    }
}