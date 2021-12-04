package com.zikozee.implementingauthentication.config;

import com.zikozee.implementingauthentication.user.User;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

/**
 * @author : Ezekiel Eromosei
 * @created : 04 Dec, 2021
 */

@Configuration
public class UserManagement {

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user= new User("john", "12345", "read");
        return new InMemoryUserDetailsService(List.of(user));
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
