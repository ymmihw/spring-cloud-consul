package com.ymmihw.spring.cloud.consul;

import org.springframework.web.bind.annotation.RequestMapping;

public interface FeignHttpController {
  @RequestMapping("/http")
  String greeting();
}
