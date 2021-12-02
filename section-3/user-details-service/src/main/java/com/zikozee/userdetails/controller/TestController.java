package com.zikozee.userdetails.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Ezekiel Eromosei
 * @created : 02 Dec, 2021
 */

@RestController
public class TestController {

    @GetMapping(path = "hello")
    public String hello(){
        return "Hello!";
    }
}
