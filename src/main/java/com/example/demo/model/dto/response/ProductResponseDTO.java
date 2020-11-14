package com.example.demo.model.dto.response;

import com.example.demo.model.dto.request.ProductSaveDTO;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: sadeesha
 * Date: 2020-11-14
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder()
@ToString(callSuper = true)
public class ProductResponseDTO extends ProductSaveDTO {

    private int productId;
    private char status;
    private ProductCategoryResponseDTO category;
    private List<ProductCommentResponseDTO> comments;
}
