package com.zikozee.httpbasic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * @author : Ezekiel Eromosei
 * @created : 12 Dec, 2021
 */

@Controller
public class HelloController {

    @GetMapping(path = "hello")
    public String hello(){
        return "Hello!";
    }
}
