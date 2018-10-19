package com.ymmihw.spring.cloud.consul;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignHttpsControllerImpl implements FeignHttpsController {
  @Override
  public String greeting() {
    return "from feignHttpsService";
  }
}
