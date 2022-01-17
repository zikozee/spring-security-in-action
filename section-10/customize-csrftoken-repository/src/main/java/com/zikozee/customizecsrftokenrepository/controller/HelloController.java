package com.zikozee.customizecsrftokenrepository.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Ezekiel Eromosei
 * @created : 16 Jan, 2022
 */

@RestController
public class HelloController {

    @GetMapping(path = "hello")
    public String hello(){
        return "hello";
    }

    @PostMapping(path = "hello")
    public String postHello(){
        return "Post Hello";
    }

    @PostMapping(path = "ciao")
    public String postCiao(){
        return "Post Ciao";
    }
}
