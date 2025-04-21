package org.sid.transactionservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "response-iso-service")
public interface ResponseISOFeignClient {
    @PostMapping("/api/response/save")
    String analyzeIsoMessage(@RequestBody String isoMessage);
}
