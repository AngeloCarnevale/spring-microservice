package com.angelo.authms.domain.dtos;

import org.springframework.http.HttpStatus;

public record ExceptionDTO (String message, HttpStatus statusCode){
}
