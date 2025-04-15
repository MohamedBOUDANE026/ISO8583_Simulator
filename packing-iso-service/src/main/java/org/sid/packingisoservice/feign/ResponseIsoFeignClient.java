package org.sid.packingisoservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "response-iso-service", url = "${response-iso-service.url}")
public interface ResponseIsoFeignClient {
    @PostMapping("/api/response/save")
    void sendIsoMessage(@RequestBody String isoMessage);
}
