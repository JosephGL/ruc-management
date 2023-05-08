package com.joseph.rucmanagement.client;

import com.joseph.rucmanagement.configuration.FeignClientConfig;
import com.joseph.rucmanagement.dto.LegalEntityDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "LegalEntityClient" , url = "${ruc.api.base-url}", configuration = FeignClientConfig.class)
public interface LegalEntityClient {

    @GetMapping("/validate")
    LegalEntityDto validateLegalEntity(@RequestParam String ruc,
                                       @RequestParam String tipo,
                                       @RequestParam String token);
}
