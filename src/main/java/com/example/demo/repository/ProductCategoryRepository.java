package com.example.demo.repository;

import com.example.demo.model.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * User: sadeesha
 * Date: 2020-11-14
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
}
