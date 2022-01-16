package com.zikozee.corscsrfprotection.controller;

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
    public String getHello(){
        return "Get Hello!";
    }

    @PostMapping(path = "hello")
    public String posHello(){
        return "Post Hello";
    }
}
