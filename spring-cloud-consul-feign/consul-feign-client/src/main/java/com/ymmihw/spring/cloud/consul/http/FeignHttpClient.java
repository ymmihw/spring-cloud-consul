package com.ymmihw.spring.cloud.consul.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient(name = "feignHttpService", fallback = FeignHttpClient.Fallback.class)
public interface FeignHttpClient extends FeignHttpController {
  @Component
  public static class Fallback implements FeignHttpClient {
    @Override
    public String greeting() {
      return "feignHttpService fallback";
    }
  }
}
