package com.example.demo.service.impl;

import com.example.demo.exception.CustomServiceException;
import com.example.demo.model.dto.request.ProductSaveDTO;
import com.example.demo.model.dto.response.ProductCategoryResponseDTO;
import com.example.demo.model.dto.response.ProductCommentResponseDTO;
import com.example.demo.model.dto.response.ProductResponseDTO;
import com.example.demo.model.entity.Product;
import com.example.demo.model.entity.ProductCategory;
import com.example.demo.model.entity.ProductComment;
import com.example.demo.repository.ProductCategoryRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import com.example.demo.util.AppConstants;
import com.example.demo.util.AppConstants.Detail;
import com.example.demo.util.AppConstants.NotPresented;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.demo.util.ApplicationUtils.isStringEmpty;

/**
 * Created by IntelliJ IDEA.
 * User: sadeesha
 * Date: 2020-11-14
 */
@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductCategoryRepository productCategoryRepository;

    private final ModelMapper modelMapper;

    /**
     * Saves a new product after validating the data.
     * @param productSaveDTO the product details
     * @throws CustomServiceException if something is not right
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveProduct(ProductSaveDTO productSaveDTO) {
        if (isStringEmpty(productSaveDTO.getName()))
            throw new CustomServiceException(HttpStatus.CONFLICT.value(), NotPresented.PRODUCT_NAME);

        if (productRepository.existsByName(productSaveDTO.getName()))
            throw new CustomServiceException(HttpStatus.CONFLICT.value(), AppConstants.AlreadyExists.PRODUCT_NAME);

        if (productSaveDTO.getProductCategoryId() == 0)
            throw new CustomServiceException(HttpStatus.NOT_ACCEPTABLE.value(), NotPresented.PRODUCT_CATEGORY);

        Product product = modelMapper.map(productSaveDTO, Product.class);
        product.setStatus(Detail.PRODUCT_ACTIVE);

        product.setProductCategory(getProductCategory(productSaveDTO.getProductCategoryId()));

        productRepository.save(product);
    }

    /**
     * @return gets the products filtered by given params
     */
    @Override
    public Page<ProductResponseDTO> getProductsFiltered(String name, Integer productCategoryId, BigDecimal price, Pageable pageable) {
        return productRepository.findAllBySearchValue(name, productCategoryId, price, pageable).map(this::getProductResponse);
    }

    /**
     * Soft deletes a product
     * @param productId the product id
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteProduct(int productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new CustomServiceException(HttpStatus.NOT_FOUND.value(), AppConstants.NotFound.NO_PRODUCT_FOUND + productId));
        product.setStatus(Detail.PRODUCT_DELETED);
        productRepository.save(product);
    }

    @Override
    public List<ProductCategoryResponseDTO> getProductCategories() {
        return productCategoryRepository.findAll().stream().map(this::getCategoryResponse).collect(Collectors.toList());
    }

    /**
     * @param categoryId the category id to search
     * @return the product for the given id
     */
    private ProductCategory getProductCategory(int categoryId) {
        return productCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new CustomServiceException(HttpStatus.NOT_FOUND.value(), AppConstants.NotFound.NO_PRODUCT_CATEGORY_FOUND + categoryId));
    }

    private ProductResponseDTO getProductResponse(Product product) {
        ProductResponseDTO productResponse = modelMapper.map(product, ProductResponseDTO.class);
        productResponse.setComments(product.getProductComments().stream().map(this::getCommentResponse).collect(Collectors.toList()));
        productResponse.setCategory(getCategoryResponse(product.getProductCategory()));
        return productResponse;
    }

    private ProductCommentResponseDTO getCommentResponse(ProductComment productComment) {
        return modelMapper.map(productComment, ProductCommentResponseDTO.class);
    }

    private ProductCategoryResponseDTO getCategoryResponse(ProductCategory productCategory) {
        return modelMapper.map(productCategory, ProductCategoryResponseDTO.class);
    }
}
