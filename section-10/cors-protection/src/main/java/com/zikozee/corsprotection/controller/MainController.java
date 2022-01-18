package com.zikozee.corsprotection.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : Ezekiel Eromosei
 * @created : 18 Jan, 2022
 */

@Slf4j
@Controller
public class MainController {

    @GetMapping
    public String main(){
        return "main.html";
    }

    @PostMapping(path = "test")
    @ResponseBody
//    @CrossOrigin(value = "${cors.value}")
    public String test(){
        log.info("Test method called");
        return "Hello";
    }
}
