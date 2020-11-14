package com.example.demo.model.dto.response;

import lombok.*;

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
public class CommonResponseDTO {

    private int code;
    private String message;
}
