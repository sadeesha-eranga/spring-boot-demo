package com.example.demo.service;

import com.example.demo.model.dto.request.ProductSaveDTO;
import com.example.demo.model.dto.response.ProductCategoryResponseDTO;
import com.example.demo.model.dto.response.ProductResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: sadeesha
 * Date: 2020-11-14
 */
public interface ProductService {

    void saveProduct(ProductSaveDTO productSaveDTO);

    Page<ProductResponseDTO> getProductsFiltered(String name, Integer productCategoryId, BigDecimal price, Pageable pageable);

    void deleteProduct(int productId);

    List<ProductCategoryResponseDTO> getProductCategories();
}
