package com.zikozee.applyingrestrictions.config;

import org.springframework.cglib.proxy.NoOp;
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
 * @created : 31 Dec, 2021
 */

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        var user1 = User.withUsername("john")
                .password("12345")
                .roles("ADMIN")
                .build();

        var user2 = User.withUsername("jane")
                .password("12345")
                .roles("MANAGER")
                .build();

        manager.createUser(user1);
        manager.createUser(user2);

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

        http
                .authorizeRequests()
                .mvcMatchers("/hello").hasRole("ADMIN")
                .mvcMatchers("/ciao").hasRole("MANAGER")
                .anyRequest().permitAll(); // permits all others:::: we could use .authenticated() to only allow authenticated users only to access
    }
}
