package com.zikozee.reactiveappauthorization.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

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

        var uds = new  MapReactiveUserDetailsService(u);
        return uds;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http){
        return  http
                .authorizeExchange() //todo info non-reactive: authorizeRequests
                .pathMatchers(HttpMethod.GET, "/hello")  //todo info non-reactive: mvcMatchers()
                .authenticated()
                .anyExchange() //todo info non-reactive: anyRequests()
                .permitAll()
                .and()
                .httpBasic()
                .and().build();
    }
}
