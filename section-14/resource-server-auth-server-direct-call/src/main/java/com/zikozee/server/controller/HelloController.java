package com.zikozee.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Ezekiel Eromosei
 * @created : 18 Feb, 2022
 */

@RestController
public class HelloController {

    @GetMapping(path = "hello")
    public String hello(){
        return "Hello!";
    }
}
