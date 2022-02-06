package com.ezikozee.businesslogicserverscenarioone.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Ezekiel Eromosei
 * @created : 27 Nov, 2021
 */

@Slf4j
@RestController
public class TestController {

    @GetMapping(path = "test")
    public String test(){
        log.info("Authentication was successful");
        return "Test";
    }
}
