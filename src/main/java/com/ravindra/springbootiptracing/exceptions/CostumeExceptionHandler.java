package com.ravindra.springbootiptracing.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CostumeExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(IPNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleIPNotFoundException(IPNotFoundException ipNot) {
        ErrorDetails errorDetails = new ErrorDetails(601, ipNot.getMsg());
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
