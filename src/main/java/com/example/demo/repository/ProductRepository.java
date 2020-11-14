package com.example.demo.repository;

import com.example.demo.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: sadeesha
 * Date: 2020-11-14
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {

    boolean existsByName(String name);

    @Query(value = "SELECT p FROM Product p " +
            "LEFT JOIN FETCH ProductComment pcm ON pcm.product = p " +
            "JOIN FETCH p.productCategory " +
            "WHERE (:name IS NULL OR p.name LIKE %:name%) " +
            "AND (:productCategoryId IS NULL OR p.productCategory.productCategoryId = :productCategoryId ) " +
            "AND (:price IS NULL OR p.price >= :price ) " +
            "AND p.status <> 'D' " +
            "AND (:comment IS NULL OR pcm.comment LIKE %:comment%) " +
            "GROUP BY p.productId",
            countQuery = "SELECT COUNT(DISTINCT p.productId) FROM Product p " +
                    "LEFT JOIN ProductComment pcm ON pcm.product = p " +
                    "JOIN p.productCategory " +
                    "WHERE (:name IS NULL OR p.name LIKE %:name%) " +
                    "AND (:productCategoryId IS NULL OR p.productCategory.productCategoryId = :productCategoryId ) " +
                    "AND (:price IS NULL OR p.price >= :price ) " +
                    "AND p.status <> 'D' " +
                    "AND (:comment IS NULL OR pcm.comment LIKE %:comment%) ")
    Page<Product> findAllBySearchValue(@Param("name") String name, @Param("productCategoryId") Integer productCategoryId,
                                       @Param("price") BigDecimal price, @Param("comment") String comment, Pageable pageable);
}
