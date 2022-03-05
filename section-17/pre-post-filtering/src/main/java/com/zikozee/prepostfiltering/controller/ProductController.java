package com.zikozee.prepostfiltering.controller;

import com.zikozee.prepostfiltering.model.Product;
import com.zikozee.prepostfiltering.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Ezekiel Eromosei
 * @created: 27 February 2022
 */

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping(path = "sell")
    public List<Product> sellProduct(){
        List<Product> products =
                List.of(new Product("beer", "nikolai"),
                        new Product("candy", "nikolai"),
                        new Product("chocolate", "julien"));

//        List<Product> products = new ArrayList<>();
//        products.add(new Product("beer", "nikolai"));
//        products.add(new Product("candy", "nikolai"));
//        products.add(new Product("chocolate", "julien"));
        return productService.sellProducts(products);

    }

}
