package com.advance.aurore_rh.exceptions;

import org.springframework.http.HttpStatus;

public class BadRequestException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 752858877580882829L;

    public BadRequestException(HttpStatus badRequest, String configuration_requise, String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
