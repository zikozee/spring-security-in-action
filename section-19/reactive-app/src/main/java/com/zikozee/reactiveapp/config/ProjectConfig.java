package com.zikozee.reactiveapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author: Ezekiel Eromosei
 * @created: 02 April 2022
 */

@Configuration
public class ProjectConfig {
    
    @Bean
    public ReactiveUserDetailsService userDetailsService(){
        var u = User.withUsername("john")
                .password("12345")
                .authorities("read")
                .build();

        MapReactiveUserDetailsService uds = new MapReactiveUserDetailsService(u);

        return uds;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
