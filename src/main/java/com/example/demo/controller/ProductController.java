package com.example.demo.controller;

import com.example.demo.model.dto.request.ProductFilterDTO;
import com.example.demo.model.dto.request.ProductSaveDTO;
import com.example.demo.model.dto.response.CommonResponseDTO;
import com.example.demo.model.dto.response.ContentResponseDTO;
import com.example.demo.model.dto.response.ProductCategoryResponseDTO;
import com.example.demo.model.dto.response.ProductResponseDTO;
import com.example.demo.service.ProductService;
import com.example.demo.util.AppConstants.Created;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: sadeesha
 * Date: 2020-11-14
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1/products")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService productService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseDTO> saveProduct(@Valid @RequestBody ProductSaveDTO productSaveDTO) {
        log.info("End point:- Add new product\tRequest: {}", productSaveDTO);
        productService.saveProduct(productSaveDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CommonResponseDTO(HttpStatus.CREATED.value(), Created.PRODUCT_CREATED));
    }

    @PostMapping(path = "/search", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<ProductResponseDTO>> searchProducts(@RequestBody ProductFilterDTO productFilterDTO, Pageable pageable) {
        log.info("End point:- Filter products");
        Page<ProductResponseDTO> productResponses = productService.getProductsFiltered(productFilterDTO, pageable);
        return ResponseEntity.ok(productResponses);
    }

    @DeleteMapping(path = "/{productId}")
    public ResponseEntity<CommonResponseDTO> deleteProduct(@PathVariable(name = "productId") int productId) {
        log.info("End point:- Delete product\tRequest: {}", productId);
        productService.deleteProduct(productId);
        log.info("Product is deleted\tproductId: {}", productId);
        return ResponseEntity.ok(new CommonResponseDTO(HttpStatus.OK.value(), Created.PRODUCT_DELETED));
    }

    @GetMapping(path = "/categories", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ContentResponseDTO<List<ProductCategoryResponseDTO>>> getProductCategories() {
        log.info("End point:- Get product categories");
        List<ProductCategoryResponseDTO> categories = productService.getProductCategories();
        return ResponseEntity.ok(new ContentResponseDTO<>(categories));
    }
}
