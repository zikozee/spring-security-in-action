package com.zikozee.reactiveoauthresourceserver.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;

import org.springframework.security.oauth2.jwt.NimbusReactiveJwtDecoder;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * @author: Ezekiel Eromosei
 * @created: 02 April 2022
 */

@Configuration
public class ProjectConfig {
    private Logger log = LoggerFactory.getLogger(ProjectConfig.class);

    @Value("${jwk.endpoint}")
    private String jwkEndpoint;

//    @Value("${publicKey}")
//    private String publicKey;


    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http){
        return
                http.authorizeExchange()
                        .anyExchange().authenticated()
                        .and().oauth2ResourceServer()
                        .jwt(jwtSpec -> {
                            jwtSpec.jwkSetUri(jwkEndpoint);   // todo info: specifies how the token is validated (i.e authorization server signature validation)
//                            jwtSpec.jwtDecoder(this.reactiveJwtDecoder()); //todo info if we wanna use public key directly
                        })
                        .and().build();
    }

//    @Bean
//    public ReactiveJwtDecoder reactiveJwtDecoder() {
//        try{
//            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//            byte[] decodedKey = Base64.getDecoder().decode(publicKey);
//
//            X509EncodedKeySpec x509 = new X509EncodedKeySpec(decodedKey);
//            RSAPublicKey rsaPublicKey = (RSAPublicKey) keyFactory.generatePublic(x509);
//
//            return NimbusReactiveJwtDecoder.withPublicKey(rsaPublicKey).build();
//
//        }catch (Exception ex){
//            log.info(publicKey);
//            throw new RuntimeException("Wrong public key");
//        }
//    }
}
