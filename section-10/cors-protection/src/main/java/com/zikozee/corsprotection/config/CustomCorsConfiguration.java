package com.zikozee.corsprotection.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.List;

/**
 * @author : Ezekiel Eromosei
 * @created : 18 Jan, 2022
 */

public class CustomCorsConfiguration {

    private CustomCorsConfiguration(){}

    public static void corsConfig(CorsConfigurer<HttpSecurity> c) {
        CorsConfigurationSource source = request -> {
            CorsConfiguration configuration = new CorsConfiguration();
            configuration.setAllowedOrigins(permittedOrigins());
            configuration.setAllowedMethods(permittedMethods());
            return configuration;
        };
        c.configurationSource(source);
    }

    private static List<String> permittedOrigins(){
//        return List.of("http://localhost:8080" , "http://example.com", "http://example.org");
        return List.of("*");
    }

    private static List<String> permittedMethods(){
//        return List.of("GET", "POST", "PUT", "DELETE");
        return List.of("*");
    }
}
