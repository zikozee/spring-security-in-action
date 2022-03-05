package com.zikozee.postfilteringperfomance.controller;

import com.zikozee.postfilteringperfomance.model.Product;
import com.zikozee.postfilteringperfomance.repo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: Ezekiel Eromosei
 * @created: 05 March 2022
 */

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping(path = "products/{text}")
    public List<Product> findProductsContaining(@PathVariable(value = "text") String text){
        return productRepository.findProductByNameContains(text);
    }
}
