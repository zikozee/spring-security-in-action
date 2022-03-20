package com.zikozee.resourceserver.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.jwk.JwkTokenStore;

/**
 * @author: Ezekiel Eromosei
 * @created: 27 February 2022
 */

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ProjectConfig extends ResourceServerConfigurerAdapter {

    @Value("${claimAud}")
    private String claimAud;
    @Value("${jwkSetUri}")
    private String urlJwk;


    @Bean
    public SecurityEvaluationContextExtension securityEvaluationContextExtension() { //adds a SecurityEvaluationContextExtension bean to spring context
        return new SecurityEvaluationContextExtension();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(this.tokenStore());
        resources.resourceId(claimAud);
    }

    @Bean
    public TokenStore tokenStore(){
        return new JwkTokenStore(urlJwk);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .mvcMatchers(HttpMethod.DELETE, "/**")
                .hasAuthority("fitnessadmin")
                .anyRequest()
                .authenticated();
    }
}
