package com.zikozee.businesslogic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Ezekiel Eromosei
 * @created : 27 Nov, 2021
 */

@RestController
public class TestController {

    @GetMapping(path = "test")
    public String test(){
        return "Test";
    }
}
