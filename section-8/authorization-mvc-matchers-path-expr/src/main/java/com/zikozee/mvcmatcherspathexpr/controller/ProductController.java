package com.zikozee.mvcmatcherspathexpr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Ezekiel Eromosei
 * @created : 31 Dec, 2021
 */

@RestController
public class ProductController {

    @GetMapping(path = "product/{code}")
    public String productCode(@PathVariable(name = "code") String code){
        return code;
    }
}
