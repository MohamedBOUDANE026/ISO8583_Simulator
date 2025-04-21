package org.sid.transactionservice.feign;

import org.sid.transactionservice.dto.TransactionDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "packing-iso-service")
public interface PackingISOFeignClient {
    @PostMapping("/api/iso/generate")
    String generateIsoMessage(@RequestBody TransactionDTO transactionDTO);
}
