package com.zikozee.businesslogic.config;

import com.zikozee.businesslogic.BusinessLogicServerApplication;
import com.zikozee.businesslogic.authfilter.InitialAuthenticationFilter;
import com.zikozee.businesslogic.authfilter.JwtAuthenticationFilter;
import com.zikozee.businesslogic.authprovider.OtpAuthenticationProvider;
import com.zikozee.businesslogic.authprovider.UsernamePasswordAuthenticationProvider;
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
//@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    final JwtAuthenticationFilter jwtAuthenticationFilter = BusinessLogicServerApplication.getContext().getBean("jwtAuthenticationFilter", JwtAuthenticationFilter.class);
    final UsernamePasswordAuthenticationProvider usernamePasswordAuthenticationProvider=  BusinessLogicServerApplication.getContext().getBean("usernamePasswordAuthenticationProvider", UsernamePasswordAuthenticationProvider.class);
    final OtpAuthenticationProvider otpAuthenticationProvider =   BusinessLogicServerApplication.getContext().getBean("otpAuthenticationProvider", OtpAuthenticationProvider.class);


//    private final JwtAuthenticationFilter jwtAuthenticationFilter;
//    private final UsernamePasswordAuthenticationProvider usernamePasswordAuthenticationProvider;
//    private final OtpAuthenticationProvider otpAuthenticationProvider;

    @Value("${jwt.base.signing.key}")
    private String baseSigningKey;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable();

        http
                .addFilterAt(new InitialAuthenticationFilter(this.authenticationManager(), baseSigningKey), BasicAuthenticationFilter.class)
                .addFilterAfter(jwtAuthenticationFilter, BasicAuthenticationFilter.class);

        http
                .authorizeRequests()
                .anyRequest()
                .authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(usernamePasswordAuthenticationProvider)
                .authenticationProvider(otpAuthenticationProvider);
    }

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
