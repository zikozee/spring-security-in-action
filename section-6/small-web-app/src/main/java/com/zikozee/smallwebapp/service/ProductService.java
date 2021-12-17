package com.zikozee.smallwebapp.service;

import com.zikozee.smallwebapp.entity.Product;
import com.zikozee.smallwebapp.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Ezekiel Eromosei
 * @created : 17 Dec, 2021
 */

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }
}
