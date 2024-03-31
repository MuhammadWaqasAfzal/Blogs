package com.waqas.blog.exception;

public class ErrorResponse {
    private int status;
    private String message;

    // Constructors, getters, and setters
    public ErrorResponse() {
    }

    public ErrorResponse(int status, String message, long timeStamp) {
        this.status = status;
        this.message = message;
    }


}
