package com.zikozee.smallwebapp.controller;

import com.zikozee.smallwebapp.entity.Product;
import com.zikozee.smallwebapp.service.ProductService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author : Ezekiel Eromosei
 * @created : 17 Dec, 2021
 */

@Controller
@RequiredArgsConstructor
public class MainPageController {

    private final ProductService productService;

    @GetMapping(path = "main")
    public String main(Authentication authentication, Model model){
        model.addAttribute("username", authentication.getName());
        model.addAttribute("products", productService.findAll());
        return "main.html";
    }
}
