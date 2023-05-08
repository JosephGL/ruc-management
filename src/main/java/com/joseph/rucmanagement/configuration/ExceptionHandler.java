package com.joseph.rucmanagement.configuration;

import com.joseph.rucmanagement.dto.ApiError;
import com.joseph.rucmanagement.exception.InvalidLegalEntityException;
import com.joseph.rucmanagement.exception.LegalEntityClientException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(value = {InvalidLegalEntityException.class})
    protected ResponseEntity<Object> handleInvalidLegalEntityException(RuntimeException ex, WebRequest request) {
        ApiError error = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage(), ex.getClass().toString());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(value = {LegalEntityClientException.class})
    protected ResponseEntity<Object> handleLegalEntityClientException(RuntimeException ex, WebRequest request) {
        ApiError error = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex.getClass().toString());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
