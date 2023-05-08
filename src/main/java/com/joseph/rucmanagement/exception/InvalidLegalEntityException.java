package com.joseph.rucmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Ruc inexistente")
public class InvalidLegalEntityException extends IllegalArgumentException{
    public InvalidLegalEntityException(String message){
        super(message);
    }
}
