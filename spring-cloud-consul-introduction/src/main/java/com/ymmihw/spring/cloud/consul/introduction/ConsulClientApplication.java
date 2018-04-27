package com.ymmihw.spring.cloud.consul.introduction;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsulClientApplication {
  public static void main(String[] args) {
    new SpringApplicationBuilder(ConsulClientApplication.class).web(WebApplicationType.SERVLET)
        .run(args);
  }
}
