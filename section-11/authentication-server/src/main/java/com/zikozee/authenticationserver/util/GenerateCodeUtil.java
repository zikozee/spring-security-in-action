package com.zikozee.authenticationserver.util;

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

            int c = random.nextInt(9000) + 1000;

            code = String.valueOf(c);
        }catch (NoSuchAlgorithmException ex){
            throw new RuntimeException("Problem when generating random code");
        }

        return code;
    }
}
