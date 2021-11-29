package com.zikozee.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Ezekiel Eromosei
 * @created : 29 Nov, 2021
 */

@RestController
public class Test {

    @GetMapping(path = "hello")
    public String test(){
        return "Test!";
    }
}
