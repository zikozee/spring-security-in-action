package com.zikozee.clientappgithubsso.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author : Ezekiel Eromosei
 * @created : 12 Feb, 2022
 */

@Configuration
public class ProjectConfigUsingPropertiesFile extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .oauth2Login();

        http
                .authorizeRequests()
                .anyRequest()
                .authenticated();
    }
}
