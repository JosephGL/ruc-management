package com.joseph.rucmanagement.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LegalEntityDto {
    @JsonProperty("ruc" )
    private String ruc;

    @JsonProperty("razon_social")
    private String razonSocial;

    @JsonProperty("estado")
    private String estado;

    @JsonProperty("direccion")
    private String direccion;

    @JsonProperty("ubigeo")
    private String ubigeo;

    @JsonProperty("departamento")
    private String departamento;

    @JsonProperty("provincia")
    private String provincia;

    @JsonProperty("distrito")
    private String distrito;

    @JsonProperty("tipo")
    private Integer tipo;

}