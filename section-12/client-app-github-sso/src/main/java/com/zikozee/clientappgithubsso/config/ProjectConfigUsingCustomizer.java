//package com.zikozee.clientappgithubsso.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
//import org.springframework.security.oauth2.client.registration.ClientRegistration;
//import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
//import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
//
///**
// * @author : Ezekiel Eromosei
// * @created : 12 Feb, 2022
// */
//
//@Configuration
//public class ProjectConfigUsingCustomizer extends WebSecurityConfigurerAdapter {
//
//    @Value("${client.id}")
//    private String clientId;
//    @Value("${client.secret}")
//    private String clientSecret;
//
//
//    private ClientRegistrationRepository clientRegistrationRepository(){
//        var c = clientRegistration();
//        return new InMemoryClientRegistrationRepository(c);
//    }
//
//    private ClientRegistration clientRegistration(){
//        return CommonOAuth2Provider.GITHUB
//                .getBuilder("github")
//                .clientId(clientId)
//                .clientSecret(clientSecret)
//                .build();
//    }
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http
//                .oauth2Login(c -> {
//                    c.clientRegistrationRepository(clientRegistrationRepository());
//                });
//
//        http
//                .authorizeRequests()
//                .anyRequest()
//                .authenticated();
//    }
//}
