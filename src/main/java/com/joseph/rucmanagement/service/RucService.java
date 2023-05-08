package com.joseph.rucmanagement.service;

import com.joseph.rucmanagement.client.LegalEntityClient;
import com.joseph.rucmanagement.dto.LegalEntityDto;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RucService {

    public static final String RUC_NO_REGISTRADO = "Ruc no registrado";

    private final LegalEntityClient legalEntityClient;

    public String validateLegalEntity(String ruc, String tipo, String token){
        LegalEntityDto response;
        try {
             response = legalEntityClient.validateLegalEntity(ruc, tipo, token);
        }
        catch (FeignException e){
            return "Error llamando al servicio";
        }

        if(response.getRuc() == null || response.getRazonSocial().equals(RUC_NO_REGISTRADO)){
            return "Invalido";
        }
        return "Valido";
    }

}

