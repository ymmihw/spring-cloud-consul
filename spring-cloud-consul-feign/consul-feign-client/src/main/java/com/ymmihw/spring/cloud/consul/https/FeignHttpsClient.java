package com.ymmihw.spring.cloud.consul.https;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient(name = "feignHttpsService", fallback = FeignHttpsClient.Fallback.class)
public interface FeignHttpsClient extends FeignHttpsController {
  @Component
  public static class Fallback implements FeignHttpsClient {
    @Override
    public String greeting() {
      return "feignHttpsService fallback";
    }
  }
}
