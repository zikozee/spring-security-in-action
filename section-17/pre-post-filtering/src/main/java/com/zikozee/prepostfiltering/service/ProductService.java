package com.zikozee.prepostfiltering.service;

import com.zikozee.prepostfiltering.model.Product;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Ezekiel Eromosei
 * @created: 27 February 2022
 */

@Service
public class ProductService {

    @PreFilter("filterObject.owner == authentication.name")
    public List<Product> sellProducts(List<Product> products){
        // sell products and return the accessed(sold) products
        return products;
    }

    @PostFilter("filterObject.owner == authentication.name")
    public List<Product> getProducts(){
        List<Product> products = new ArrayList<>();
        products.add(new Product("beer", "nikolai"));
        products.add(new Product("candy", "nikolai"));
        products.add(new Product("chocolate", "julien"));
        return products;
    }
}
