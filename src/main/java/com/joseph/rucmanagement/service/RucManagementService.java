package com.joseph.rucmanagement.service;

import com.joseph.rucmanagement.client.LegalEntityClient;
import com.joseph.rucmanagement.dto.LegalEntityDto;
import com.joseph.rucmanagement.entity.LegalEntity;
import com.joseph.rucmanagement.exception.InvalidLegalEntityException;
import com.joseph.rucmanagement.exception.LegalEntityClientException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RucManagementService {

    public static final String RUC_NO_REGISTRADO = "Ruc no registrado";
    private static final Logger log = LoggerFactory.getLogger(RucManagementService.class);
    private final MongoTemplate mongoTemplate;
    private final ModelMapper modelMapper;
    private final LegalEntityClient legalEntityClient;

    public Boolean validateLegalEntity(String ruc){
        LegalEntityDto response;
        try {
            log.info("Validando Persona Juridica");
            response = legalEntityClient.getLegalEntity(ruc);
        }
        catch (FeignException e){
            log.error("Error al consumir servicio" );
            throw new LegalEntityClientException("No es posible conectar al servicio");
        }

        if(response.getRuc() == null || response.getRazonSocial().equals(RUC_NO_REGISTRADO)){
            return Boolean.FALSE;
        }
        log.info("Ruc {} validado", ruc);
        return Boolean.TRUE;
    }

    public void saveLegalEntity(LegalEntityDto legalEntityDto){
        log.info("Intentando guardar persona juridica");
        LegalEntity legalEntity = modelMapper.map(legalEntityDto, LegalEntity.class);
        try {
            mongoTemplate.save(legalEntity);
        } catch(DuplicateKeyException e){
            log.info("Ruc duplicado");
            throw new InvalidLegalEntityException("No es posible duplicar ruc");
        }

    }

    public HttpStatus saveFromExternal(String ruc) {
        LegalEntityDto legalEntityDto;
        try {
            legalEntityDto = legalEntityClient.getLegalEntity(ruc);
            if(legalEntityDto.getRuc() == null || legalEntityDto.getRazonSocial().equals(RUC_NO_REGISTRADO)){
                log.error("Ruc ingresado inválido");
                throw new InvalidLegalEntityException("No ha sido posible guardar el ruc ya que es inválido");
            }
            saveLegalEntity(legalEntityDto);
            log.info("Persona Juridica guardada");
            return HttpStatus.CREATED;
        }
        catch (FeignException e){
            log.error("Error al consumir servicio" );
            throw new LegalEntityClientException("No es posible conectar al servicio");
        }
    }
}

