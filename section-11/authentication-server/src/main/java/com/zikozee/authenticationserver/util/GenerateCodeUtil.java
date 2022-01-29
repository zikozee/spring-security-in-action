package com.zikozee.authenticationserver.util;

import org.springframework.http.HttpHeaders;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.security.crypto.keygen.StringKeyGenerator;

import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @author : Ezekiel Eromosei
 * @created : 27 Nov, 2021
 */

public class GenerateCodeUtil {

    private GenerateCodeUtil(){}

    public static String generateCode(){
        String code;

        try{
            SecureRandom random = SecureRandom.getInstanceStrong();

            int c = random.nextInt(900000) + 100000;

            code = String.valueOf(c);
        }catch (NoSuchAlgorithmException ex){
            throw new RuntimeException("Problem when generating random code");
        }

        return code;
    }

    public static String generateUserKey(){
        // you could also encrypt key
        StringKeyGenerator keyGen = KeyGenerators.string();
        return keyGen.generateKey();
    }
}
