package com.zikozee.userdetails.config;

import com.zikozee.userdetails.user.User;
import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author : Ezekiel Eromosei
 * @created : 02 Dec, 2021
 */

@Configuration
public class ProjectConfig {

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource){
        //Option 1: Using our implemented InMemoryUserDetailsService :::--> remove Datasource parammeter
//        UserDetails user= new User("john", "12345", "read");
//        return new InMemoryUserDetailsService(List.of(user));

        //Option 2: Using spring defaults:--> schema : spring, two tables: users and authorities
       // return new JdbcUserDetailsManager(dataSource);

        //Option 3: we can override all the default name here
        String usersByUsernameQuery =
                "select username, password, enabled from gecko.entities where username = ?";
        String authsByUserQuery =
                "select username, authority from gecko.privileges where username = ?";

        var userDetailsManager = new JdbcUserDetailsManager(dataSource);
        userDetailsManager.setUsersByUsernameQuery(usersByUsernameQuery);
        userDetailsManager.setAuthoritiesByUsernameQuery(authsByUserQuery);
        return userDetailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
