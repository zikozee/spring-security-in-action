package com.zikozee.smallwebapp.config;

import com.zikozee.smallwebapp.authprovider.AuthenticationProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/**
 * @author : Ezekiel Eromosei
 * @created : 17 Dec, 2021
 */

@Configuration
@RequiredArgsConstructor
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    private final AuthenticationProviderService authenticationProvider;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .defaultSuccessUrl("/main", true);

        http
                .authorizeRequests()
                .anyRequest().authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }
}
