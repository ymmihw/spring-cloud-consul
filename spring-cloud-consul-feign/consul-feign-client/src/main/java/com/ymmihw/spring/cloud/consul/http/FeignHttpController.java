package com.ymmihw.spring.cloud.consul.http;

import org.springframework.web.bind.annotation.RequestMapping;

public interface FeignHttpController {
  @RequestMapping("/http")
  String greeting();
}
