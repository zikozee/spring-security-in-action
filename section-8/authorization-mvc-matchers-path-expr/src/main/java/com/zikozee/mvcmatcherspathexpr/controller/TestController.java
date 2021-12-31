package com.zikozee.mvcmatcherspathexpr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Ezekiel Eromosei
 * @created : 31 Dec, 2021
 */

@RestController
public class TestController {

    @PostMapping(path = "a")
    public String postEndpointA(){
    return "Works!";
    }

    @GetMapping(path = "a")
    public String getEndpointA(){
        return "Works!";
    }

    @GetMapping(path = "a/b")
    public String getEndpointB(){
        return "Works!";
    }

    @GetMapping(path = "a/b/c")
    public String getEndpointC(){
        return "Works!";
    }
}
