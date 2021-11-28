package com.zikozee.filters.config;

import com.zikozee.filters.filter.AuthLoggingFilter;
import com.zikozee.filters.filter.RequestValidationFilter;
import com.zikozee.filters.filter.StaticKeyAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * @author : Ezekiel Eromosei
 * @created : 27 Nov, 2021
 */

@Configuration
@RequiredArgsConstructor
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    private final StaticKeyAuthenticationFilter staticFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(new RequestValidationFilter(), BasicAuthenticationFilter.class)
                .addFilterAfter(new AuthLoggingFilter(), BasicAuthenticationFilter.class)

                //todo info: here we are adding a filter at the position of the BasicAuthenticationFilter
                // NOTE: filters cannot be replaced, they only carry the same ORDER INDEX and execution_order is not guaranteed
                //       implement only what you need
                .addFilterAt(staticFilter, BasicAuthenticationFilter.class)

                .authorizeRequests()
                .anyRequest()
                .permitAll(); // todo info:  permitting all for testing purpose

    }
}
