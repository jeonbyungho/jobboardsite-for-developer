package com.jobboard.web;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PasswordEncryptionUtil {
    private static PasswordEncryptionUtil instance;

    public static PasswordEncryptionUtil getInstance(){
        if(instance == null){
            instance = new PasswordEncryptionUtil();
        }
        return instance;
    }

    public String encrypt(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            
            StringBuffer sb = new StringBuffer();
            byte[] digest = md.digest();
            for (byte b: digest){
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return null;
    }

    public String decrypt(){
        return null;
    }
}