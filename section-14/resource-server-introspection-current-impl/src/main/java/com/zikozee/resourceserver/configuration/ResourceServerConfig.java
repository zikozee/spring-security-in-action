package com.zikozee.resourceserver.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author : Ezekiel Eromosei
 * @created : 18 Feb, 2022
 */

@Configuration
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {

    @Value("${auth.token-info-uri}")
    private String tokenUri;

    @Value("${auth.client.client-id}")
    private String clientId;
    @Value("${auth.client.client-secret}")
    private String clientSecret;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .oauth2ResourceServer(c -> c.opaqueToken(
                        o -> {
                            o.introspectionUri(tokenUri);
                            o.introspectionClientCredentials(clientId, clientSecret);
                        }
                ));
    }
}
