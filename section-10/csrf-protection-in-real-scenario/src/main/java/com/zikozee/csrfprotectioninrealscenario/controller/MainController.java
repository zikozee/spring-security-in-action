package com.zikozee.csrfprotectioninrealscenario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author : Ezekiel Eromosei
 * @created : 16 Jan, 2022
 */

@Controller
public class MainController {

    @GetMapping(path = "main")
    public String main(){
        return "main.html";
    }
}
