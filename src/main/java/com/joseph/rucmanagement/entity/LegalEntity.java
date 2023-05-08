package com.joseph.rucmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "legal_entities")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LegalEntity {
    @Id
    private String id;
    @Indexed(unique=true)
    @Field("ruc")
    private String ruc;
    @Field("razon_social")
    private String razonSocial;
    @Field("estado")
    private String estado;
    @Field("direccion")
    private String direccion;
    @Field("ubigeo")
    private String ubigeo;
    @Field("departamento")
    private String departamento;
    @Field("provincia")
    private String provincia;
    @Field("distrito")
    private String distrito;
    @Field("tipo")
    private Integer tipo;

}