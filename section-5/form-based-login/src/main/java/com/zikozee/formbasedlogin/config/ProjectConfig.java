package com.zikozee.formbasedlogin.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author : Ezekiel Eromosei
 * @created : 12 Dec, 2021
 */

@Configuration
@RequiredArgsConstructor
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    private final CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
    private final CustomAuthenticationFailureHandler customAuthenticationFailureHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
//                .defaultSuccessUrl("/home", true)
                        .successHandler(customAuthenticationSuccessHandler)
                        .failureHandler(customAuthenticationFailureHandler)
                                .and()
                                        .httpBasic(); // adding this ensures to support both httpBasic and formbased Login
        http
                .authorizeRequests()
                .anyRequest()
                .authenticated();
    }

    @Bean
    public UserDetailsService userDetailsService(){ // this overrides predefined username and password
        var userDetailsService =
                new InMemoryUserDetailsManager();

        var user = User.withUsername("mary")
                .password("12345")
                .authorities("write")
                .build();


        var user2 = User.withUsername("bill")
                .password("12345")
                .authorities("read")
                .build();

        userDetailsService.createUser(user);
        userDetailsService.createUser(user2);


        return userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

}
