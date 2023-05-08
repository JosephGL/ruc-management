package com.joseph.rucmanagement.service;

import com.joseph.rucmanagement.client.LegalEntityClient;
import com.joseph.rucmanagement.dto.LegalEntityDto;
import com.joseph.rucmanagement.entity.LegalEntity;
import com.joseph.rucmanagement.exception.InvalidLegalEntityException;
import com.joseph.rucmanagement.exception.LegalEntityClientException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RucService {

    public static final String RUC_NO_REGISTRADO = "Ruc no registrado";

    private final MongoTemplate mongoTemplate;
    private final ModelMapper modelMapper;

    private final LegalEntityClient legalEntityClient;

    public Boolean validateLegalEntity(String ruc){
        LegalEntityDto response;
        try {
             response = legalEntityClient.getLegalEntity(ruc);
        }
        catch (FeignException e){
            throw new LegalEntityClientException("No es posible conectar al servicio");
        }

        if(response.getRuc() == null || response.getRazonSocial().equals(RUC_NO_REGISTRADO)){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public void saveLegalEntity(LegalEntityDto legalEntityDto){
        LegalEntity legalEntity = modelMapper.map(legalEntityDto, LegalEntity.class);
        try {
            mongoTemplate.save(legalEntity);
        } catch(DuplicateKeyException e){
            throw new InvalidLegalEntityException("No es posible duplicar ruc");
        }

    }

    public HttpStatus saveFromExternal(String ruc) {

        LegalEntityDto legalEntityDto;
        try {
            legalEntityDto = legalEntityClient.getLegalEntity(ruc);
            if(legalEntityDto.getRuc() == null || legalEntityDto.getRazonSocial().equals(RUC_NO_REGISTRADO)){
                throw new InvalidLegalEntityException("No ha sido posible guardar el ruc ya que es inválido");
            }
            saveLegalEntity(legalEntityDto);
            return HttpStatus.CREATED;
        }
        catch (FeignException e){
            throw new LegalEntityClientException("No es posible conectar al servicio");
        }
    }
}

