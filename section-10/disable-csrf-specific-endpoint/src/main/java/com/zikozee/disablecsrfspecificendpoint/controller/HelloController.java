package com.zikozee.disablecsrfspecificendpoint.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Ezekiel Eromosei
 * @created : 16 Jan, 2022
 */

@RestController
public class HelloController {

    @PostMapping(path = "hello")
    public String postHello(){
        return "Post Hello";
    }

    @PostMapping(path = "ciao")
    public String postCiao(){
        return "Post Ciao";
    }
}
