package com.waqas.blog.exception;

public class CustomException extends RuntimeException {

    public CustomException(String message) {
        super(String.valueOf(message));
    }

}

