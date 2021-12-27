package com.zikozee.restrictingaccess.config;

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
 * @created : 27 Dec, 2021
 */

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService(){
        var manager = new InMemoryUserDetailsManager();

        var user1 = User.withUsername("john")
                .password("12345")
                .authorities("READ")
                .build();

        var user2 = User.withUsername("jane")
                .password("12345")
                .authorities("READ", "WRITE")
                .build();

        var user3 = User.withUsername("jim")
                .password("12345")
                .authorities("READ", "WRITE", "DELETE")
                .build();

        manager.createUser(user1);
        manager.createUser(user2);
        manager.createUser(user3);

        return manager;
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic();

        final String expression = "hasAuthority('READ') and !hasAnyAuthority('DELETE')";

        http
                .authorizeRequests()
                .anyRequest()
//                .hasAnyAuthority("WRITE", "READ");
//                .access(expression);
                .access("T(java.time.LocalTime).now().isBefore(T(java.time.LocalTime).of(21, 17, 0))");
    }
}
