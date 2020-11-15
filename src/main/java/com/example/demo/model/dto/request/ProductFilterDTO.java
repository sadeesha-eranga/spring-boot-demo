package com.example.demo.model.dto.request;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Min;
import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: sadeesha
 * Date: 2020-11-14
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString(callSuper = true)
public class ProductFilterDTO {
    private String name;
    @Min(0)
    private BigDecimal price;
    private Integer productCategoryId;
    private String comment;
}
