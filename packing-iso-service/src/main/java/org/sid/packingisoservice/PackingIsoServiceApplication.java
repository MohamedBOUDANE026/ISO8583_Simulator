package org.sid.packingisoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "org.sid.packingisoservice.feign")
@SpringBootApplication
@EnableDiscoveryClient
public class PackingIsoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PackingIsoServiceApplication.class, args);
    }

}
