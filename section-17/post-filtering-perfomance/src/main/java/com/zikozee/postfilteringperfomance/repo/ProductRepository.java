package com.zikozee.postfilteringperfomance.repo;

import com.zikozee.postfilteringperfomance.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Ezekiel Eromosei
 * @created: 05 March 2022
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
//      todo info: BAD PERFOMANCE
//    @PostFilter("filterObject.owner == authentication.name")
//    List<Product> findProductByNameContains(String text);

    @Query("SELECT p from Product  p WHERE p.name LIKE %:text% AND " +
            "p.owner=?#{authentication.name}")
    List<Product> findProductByNameContains(String text);
}
