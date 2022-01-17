package com.zikozee.customizecsrftokenrepository.config;

import com.zikozee.customizecsrftokenrepository.repo.CustomCsrfTokenRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfTokenRepository;

/**
 * @author : Ezekiel Eromosei
 * @created : 16 Jan, 2022
 */

@Configuration
public class ProjectConfig  extends WebSecurityConfigurerAdapter {

    @Bean
    public CsrfTokenRepository csrfTokenRepository(){
        return  new CustomCsrfTokenRepository();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf(c -> {
                    c.csrfTokenRepository(this.csrfTokenRepository());
                    c.ignoringAntMatchers("/ciao");
                });

        http
                .authorizeRequests()
                .anyRequest().permitAll();
    }
}
