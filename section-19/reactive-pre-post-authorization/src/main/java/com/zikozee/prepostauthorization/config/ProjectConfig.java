package com.zikozee.prepostauthorization.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
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
@EnableReactiveMethodSecurity
public class ProjectConfig {

    @Bean
    public ReactiveUserDetailsService userDetailsService(){
        var u1 = User.withUsername("john")
                .password("12345")
                .roles("ADMIN")
                .build();

        var u2 = User.withUsername("bill")
                .password("12345")
                .roles("REGULAR_USER")
                .build();


        var uds = new  MapReactiveUserDetailsService(u1, u2);
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
