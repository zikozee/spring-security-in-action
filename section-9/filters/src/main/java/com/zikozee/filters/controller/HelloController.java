package com.zikozee.filters.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Ezekiel Eromosei
 * @created : 27 Nov, 2021
 */

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello!";
    }
}
