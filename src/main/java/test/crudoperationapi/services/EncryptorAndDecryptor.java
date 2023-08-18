package test.crudoperationapi.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;

public class EncryptorAndDecryptor {

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    public String encode(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    public Boolean matches(String inputPassword, String encodedPassword) {
        if(bCryptPasswordEncoder.matches(inputPassword, encodedPassword)){
            return true;
        }else{
            return false;
        }
    }
}
