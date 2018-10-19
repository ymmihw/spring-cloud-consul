package com.ymmihw.spring.cloud.consul;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FeignClientApplication {
  public static void main(String[] args) {
    new SpringApplicationBuilder(FeignClientApplication.class).web(WebApplicationType.SERVLET)
        .run(args);
  }
}
