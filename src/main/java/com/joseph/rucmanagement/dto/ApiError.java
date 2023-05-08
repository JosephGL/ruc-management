package com.joseph.rucmanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {
    @JsonProperty
    private HttpStatus status;
    @JsonProperty
    private String message;
    @JsonProperty
    private String error;
}