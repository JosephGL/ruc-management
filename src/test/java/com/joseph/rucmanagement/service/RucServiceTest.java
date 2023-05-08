package com.joseph.rucmanagement.service;

import com.joseph.rucmanagement.client.LegalEntityClient;
import com.joseph.rucmanagement.dto.LegalEntityDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RucServiceTest {

    @Mock
    private LegalEntityClient legalEntityClient;

    @InjectMocks
    private RucService rucService;

    @Test
    void validateLegalEntityTest() {
        String ruc = "20600892470";
        String tipo = "tipo";
        String token = "token";

        LegalEntityDto legalEntityDto = new LegalEntityDto();
        legalEntityDto.setRuc("20600892470");
        legalEntityDto.setRazonSocial("SUPERDEPORTE PLUS PERU S.A.C.");
        legalEntityDto.setEstado("ACTIVO");
        legalEntityDto.setDireccion("AV. LARCO 1301 301      LIMA LIMA  MIRAFLORES");
        legalEntityDto.setUbigeo("150122");
        legalEntityDto.setDepartamento("LIMA");
        legalEntityDto.setProvincia("LIMA");
        legalEntityDto.setDistrito("MIRAFLORES");

        when(legalEntityClient.getLegalEntity(ruc)).thenReturn(legalEntityDto);

        Boolean result = rucService.validateLegalEntity(ruc);

        assertNotNull(result);
        assertEquals(Boolean.TRUE, result);
    }
}