package com.joseph.rucmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Sunat Caido")
public class LegalEntityClientException extends RuntimeException {

    public LegalEntityClientException(String message){
        super(message);
    }

}
