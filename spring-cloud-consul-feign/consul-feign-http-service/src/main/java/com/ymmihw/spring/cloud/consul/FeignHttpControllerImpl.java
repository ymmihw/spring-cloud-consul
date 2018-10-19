package com.ymmihw.spring.cloud.consul;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignHttpControllerImpl implements FeignHttpController {
  @Override
  public String greeting() {
    return "from feignHttpService";
  }
}
