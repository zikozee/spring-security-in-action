package com.zikozee.csrfprotectioninrealscenario.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author : Ezekiel Eromosei
 * @created : 16 Jan, 2022
 */

@Slf4j
@Controller
@RequestMapping("/product")
public class ProductController {

    @PostMapping(path = "add")
    public String add(@RequestParam String name){
        log.info("Adding product " + name);
        return "main.html";
    }
}
