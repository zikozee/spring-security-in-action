package com.zikozee.securitycontext.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author : Ezekiel Eromosei
 * @created : 12 Dec, 2021
 */

@Configuration
@EnableAsync
public class ProjectConfig {

    @Bean
    public InitializingBean initializingBean(){
        return () -> SecurityContextHolder
                .setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
    }
}
