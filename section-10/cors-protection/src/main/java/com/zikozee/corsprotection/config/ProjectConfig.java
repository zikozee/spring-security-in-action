package com.zikozee.corsprotection.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author : Ezekiel Eromosei
 * @created : 18 Jan, 2022
 */

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .cors(CustomCorsConfiguration::corsConfig);

        http
                .csrf()
                .disable();

        http
                .authorizeRequests()
                .anyRequest()
                .permitAll();
    }


}
