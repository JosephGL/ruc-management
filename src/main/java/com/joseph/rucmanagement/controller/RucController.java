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

    public ResponseEntity<String> validateRuc(@RequestParam(value = "ruc") String ruc,
                                              @RequestParam(value = "tipo") String tipo,
                                              @RequestParam(value = "token") String token) {

        return new ResponseEntity<>(rucService.validateLegalEntity(ruc, tipo, token), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Void> registerLegalEntity(@RequestBody LegalEntityDto legalEntityDto) {
        // Lógica para registrar entidad legal
        // ...

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}