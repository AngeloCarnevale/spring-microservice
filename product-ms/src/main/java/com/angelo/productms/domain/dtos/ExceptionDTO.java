package com.angelo.productms.domain.dtos;

import org.springframework.http.HttpStatus;

public record ExceptionDTO (String message, HttpStatus statusCode){
}
