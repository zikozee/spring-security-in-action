package com.zikozee.resourceserver.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @author : Ezekiel Eromosei
 * @created : 20 Feb, 2022
 */

@Configuration
@EnableResourceServer
public class ResourceServerConfig  extends ResourceServerConfigurerAdapter {

    @Value("${publicKey}")
    private String publicKey;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(this.tokenStore());
    }

    @Bean
    public TokenStore tokenStore(){
        return new JwtTokenStore(this.jwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter(){
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();

        converter.setVerifierKey(publicKey);
        return converter;
    }
}
