package com.example.demo.model.dto.request;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.time.LocalDate;

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
public class ProductSaveDTO {

    private String name;
    private String description;
    @Min(0)
    private BigDecimal price;
    private LocalDate launchDate;

    private int productCategoryId;
}
