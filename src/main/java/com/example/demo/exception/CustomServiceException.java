package com.example.demo.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by IntelliJ IDEA.
 * User: sadeesha
 * Date: 2020-11-14
 */
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CustomServiceException extends RuntimeException {

    private int code;
    private String message;

    public CustomServiceException(int code, String message) {
        super(message);
        this.message = message;
        this.code = code;
    }
}
