package com.zikozee.clientappgithubsso.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author : Ezekiel Eromosei
 * @created : 12 Feb, 2022
 */

@Slf4j
@Controller
public class MainController {

    //todo info: direct injection
    @GetMapping
    public String main(OAuth2AuthenticationToken token){
        log.info("TOKEN: {}", token.getPrincipal());
        return "main.html";
    }

    @GetMapping(path = "context")
    public String mainContext(){
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication a = context.getAuthentication();
        log.info("TOKEN FROM CONTEXT: {}", a.getPrincipal());
        return "main.html";
    }
}
