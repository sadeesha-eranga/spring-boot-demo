package com.example.demo.model.dto.response;

import lombok.*;

import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 * User: sadeesha
 * Date: 2020-11-14
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString(callSuper = true)
public class ProductCommentResponseDTO {

    private int productCommentId;
    private String comment;
    private LocalDateTime createdAt;
}
