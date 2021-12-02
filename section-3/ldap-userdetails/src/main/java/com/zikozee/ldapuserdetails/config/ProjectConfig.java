package com.zikozee.ldapuserdetails.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.ldap.DefaultLdapUsernameToDnMapper;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;
import org.springframework.security.ldap.userdetails.LdapUserDetailsManager;


/**
 * @author : Ezekiel Eromosei
 * @created : 02 Dec, 2021
 */


@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        //Creates a context source to specify the address of the LDAP server
        var cs = new DefaultSpringSecurityContextSource("ldap://127.0.0.1:33389/dc=springframework,dc=org");
        cs.afterPropertiesSet();

        //Creates the LdapUserDetailsManager instance
        LdapUserDetailsManager manager = new LdapUserDetailsManager(cs);

        // Sets a username mapper to instruct the  LdapUserDetailsManager on how to search for users
        manager.setUsernameMapper(
                new DefaultLdapUsernameToDnMapper("ou=groups", "uid"));

        // Sets the group search base that the app needs to search for users
        manager.setGroupSearchBase("ou=groups");
        return manager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}