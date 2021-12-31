package com.zikozee.applyingrestrictions.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Ezekiel Eromosei
 * @created : 31 Dec, 2021
 */

@RestController
public class HelloController {

    @GetMapping(path = "hello")
    public String hello(){
        return "Hello!";
    }

    @GetMapping(path="ciao")
    public String ciao(){
        return "Ciao!";
    }

    @GetMapping(path = "hola")
    public String hola(){
        return "Hola!";
    }
}
