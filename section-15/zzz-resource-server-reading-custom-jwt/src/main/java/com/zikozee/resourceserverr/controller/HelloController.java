package com.zikozee.resourceserverr.controller;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Ezekiel Eromosei
 * @created : 18 Feb, 2022
 */

@RestController
public class HelloController {

    @GetMapping(path = "hello")
    public String hello(OAuth2Authentication oAuth2Authentication){
        OAuth2AuthenticationDetails details =
                (OAuth2AuthenticationDetails) oAuth2Authentication.getDetails();
        return "Hello! " + details.getDecodedDetails();
    }
}
