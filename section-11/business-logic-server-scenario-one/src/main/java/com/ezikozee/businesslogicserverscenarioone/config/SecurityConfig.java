package com.ezikozee.businesslogicserverscenarioone.config;

import com.ezikozee.businesslogicserverscenarioone.BusinessLogicServerScenarioOneApplication;
import com.ezikozee.businesslogicserverscenarioone.authfilter.InitialAuthenticationFilter;
import com.ezikozee.businesslogicserverscenarioone.authprovider.JwtAuthenticationProvider;
import com.ezikozee.businesslogicserverscenarioone.authprovider.OtpAuthenticationProvider;
import com.ezikozee.businesslogicserverscenarioone.authprovider.UsernamePasswordAuthenticationProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;


/**
 * @author : Ezekiel Eromosei
 * @created : 29 Jan, 2022
 */

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    final JwtAuthenticationFilter jwtAuthenticationFilter = BusinessLogicServerScenarioOneApplication.getContext().getBean("jwtAuthenticationFilter", JwtAuthenticationFilter.class);

    final UsernamePasswordAuthenticationProvider usernamePasswordAuthenticationProvider=  BusinessLogicServerScenarioOneApplication.getContext().getBean("usernamePasswordAuthenticationProvider", UsernamePasswordAuthenticationProvider.class);
    final OtpAuthenticationProvider otpAuthenticationProvider =   BusinessLogicServerScenarioOneApplication.getContext().getBean("otpAuthenticationProvider", OtpAuthenticationProvider.class);
    final JwtAuthenticationProvider jwtAuthenticationProvider =   BusinessLogicServerScenarioOneApplication.getContext().getBean("jwtAuthenticationProvider", JwtAuthenticationProvider.class);


    @Value("${jwt.base.signing.key}")
    private String baseSigningKey;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable();

        http
                .addFilterAt(new InitialAuthenticationFilter(this.authenticationManager(), baseSigningKey), BasicAuthenticationFilter.class);

        http
                .authorizeRequests()
                .anyRequest()
                .authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(usernamePasswordAuthenticationProvider)
                .authenticationProvider(otpAuthenticationProvider)
                .authenticationProvider(jwtAuthenticationProvider);
    }

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
