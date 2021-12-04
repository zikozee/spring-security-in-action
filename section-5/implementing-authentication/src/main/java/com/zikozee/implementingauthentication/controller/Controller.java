package com.zikozee.implementingauthentication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Ezekiel Eromosei
 * @created : 04 Dec, 2021
 */

@RestController
public class Controller {

    @GetMapping(path = "/hello")
    public String test(){
        return "Hello!";
    }
}
