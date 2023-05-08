package com.joseph.rucmanagement.controller;

import com.joseph.rucmanagement.dto.LegalEntityDto;
import com.joseph.rucmanagement.service.RucService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/rucs")
@RequiredArgsConstructor
public class RucController {

    private final RucService rucService;

    @GetMapping("/validate")
    public ResponseEntity<Boolean> validateRuc(@RequestParam(value = "ruc") String ruc) {

        return new ResponseEntity<>(rucService.validateLegalEntity(ruc), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Void> registerLegalEntity(@RequestBody LegalEntityDto legalEntityDto) {
        rucService.saveLegalEntity(legalEntityDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/externalRegister")
    public ResponseEntity<Void> externalRegister(@RequestParam String ruc) {
        HttpStatus statusResponse = rucService.saveFromExternal(ruc);
        return ResponseEntity.status(statusResponse).build();
    }
}