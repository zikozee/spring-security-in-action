package com.zikozee.prepostauthorization.controller;

import com.zikozee.prepostauthorization.service.NameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : Ezekiel Eromosei
 * @created : 21 Feb, 2022
 */

@RestController
public class HelloController {

    private final NameService nameService;

    public HelloController(NameService nameService) {
        this.nameService = nameService;
    }

    @GetMapping(path = "hello")
    public String hello(){
        return "Hello, " + nameService.getName();
    }

    @GetMapping(path = "secret/names/{name}")
    public List<String> names(@PathVariable(value = "name") String name){
        return nameService.getSecretNames(name);
    }
}
