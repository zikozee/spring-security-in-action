package com.ezikozee.businesslogicserverscenarioone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author : Ezekiel Eromosei
 * @created : 29 Jan, 2022
 */

@Configuration
public class ProjectConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
