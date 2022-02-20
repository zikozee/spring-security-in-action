package com.zikozee.resourceserver.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * @author : Ezekiel Eromosei
 * @created : 18 Feb, 2022
 */

@Slf4j
@Configuration
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {

    @Value("${publicKey}")
    private String publicKey;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.oauth2ResourceServer(
                c -> c.jwt(
                        j -> j.decoder(jwtDecoder())
                )
        );

        http.authorizeRequests()
                .anyRequest().authenticated();
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        try{
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] decodedKey = Base64.getDecoder().decode(publicKey);

            X509EncodedKeySpec x509 = new X509EncodedKeySpec(decodedKey);
            RSAPublicKey rsaPublicKey = (RSAPublicKey) keyFactory.generatePublic(x509);

            return NimbusJwtDecoder.withPublicKey(rsaPublicKey).build();

        }catch (Exception ex){
            log.info(publicKey);
            throw new RuntimeException("Wrong public key");
        }
    }

}
