package com.api.Magic.Exception;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BusinessException extends RuntimeException{

    public BusinessException(String message, Throwable cause)  { super(message, cause); }
    public BusinessException(String message) { super(message); }
}
