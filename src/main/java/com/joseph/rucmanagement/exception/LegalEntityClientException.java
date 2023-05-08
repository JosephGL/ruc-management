package com.joseph.rucmanagement.exception;

public class LegalEntityClientException extends RuntimeException{

    public LegalEntityClientException(){
        super("No ha sido posible comunicarse con el servicio");
    }

}
