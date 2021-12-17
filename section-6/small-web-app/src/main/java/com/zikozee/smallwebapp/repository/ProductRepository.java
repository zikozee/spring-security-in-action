package com.zikozee.smallwebapp.repository;

import com.zikozee.smallwebapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Ezekiel Eromosei
 * @created : 17 Dec, 2021
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
