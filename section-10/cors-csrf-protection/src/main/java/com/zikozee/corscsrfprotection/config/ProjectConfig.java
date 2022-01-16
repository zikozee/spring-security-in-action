package com.zikozee.corscsrfprotection.config;

import com.zikozee.corscsrfprotection.filter.CsrfTokenLogger;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;

/**
 * @author : Ezekiel Eromosei
 * @created : 16 Jan, 2022
 */

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilterAfter(new CsrfTokenLogger(), CsrfFilter.class)
                .authorizeRequests()
                .anyRequest().permitAll();
    }
}
