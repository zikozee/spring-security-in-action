package com.zikozee.formbasedlogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Ezekiel Eromosei
 * @created : 12 Dec, 2021
 */

@Controller
public class HelloController {

    @GetMapping(path = "home")
    public String home(){
        return "home.html";
    }
}
