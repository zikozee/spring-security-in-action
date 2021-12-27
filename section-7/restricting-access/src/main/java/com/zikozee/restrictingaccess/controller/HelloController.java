package com.zikozee.restrictingaccess.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Ezekiel Eromosei
 * @created : 27 Dec, 2021
 */

@RestController
public class HelloController {

    @GetMapping(path = "hello")
    public String hello(){
        return "Hello!";
    }
}
