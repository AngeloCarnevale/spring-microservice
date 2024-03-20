package com.angelo.productms.infra.exceptions;

public class ValidatePriceException extends RuntimeException{
    public ValidatePriceException(String message) {
        super(message);
    }

    public ValidatePriceException(String message, Throwable cause) {
        super(message, cause);
    }
}
