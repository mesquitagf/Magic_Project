package com.api.Magic.Exception;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BusinessException extends RuntimeException{

    public BusinessException(String message, Throwable cause)  { super(message, cause); }
    public BusinessException(String message) { super(message); }

    public void validateIdField(String id){
        if (id.isEmpty() || id == null){
            throw new BusinessException("ID is null!");
        }
    }
}
