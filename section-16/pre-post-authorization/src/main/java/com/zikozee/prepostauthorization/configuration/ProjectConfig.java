package com.zikozee.prepostauthorization.configuration;

import com.zikozee.prepostauthorization.evaluator.DocumentsPermissionEvaluator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author : Ezekiel Eromosei
 * @created : 21 Feb, 2022
 */

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ProjectConfig extends GlobalMethodSecurityConfiguration {

    @Autowired
    private DocumentsPermissionEvaluator documentsPermissionEvaluator;

    @Bean
    public UserDetailsService userDetailsService(){
        var service = new InMemoryUserDetailsManager();

        var ud1 = User.withUsername("natalie")
                .password("12345")
                .authorities("read")
                .roles("admin") //you can't have both just for testing complex scenario
                .build();

        var ud2 = User.withUsername("emma")
                .password("12345")
                .authorities("write")
                .roles("manager") //you can't have both just for testing complex scenario
                .build();

        service.createUser(ud1);
        service.createUser(ud2);

        return service;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }


    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        DefaultMethodSecurityExpressionHandler expressionHandler = new DefaultMethodSecurityExpressionHandler();

        expressionHandler.setPermissionEvaluator(documentsPermissionEvaluator);

        return expressionHandler;
    }
}
