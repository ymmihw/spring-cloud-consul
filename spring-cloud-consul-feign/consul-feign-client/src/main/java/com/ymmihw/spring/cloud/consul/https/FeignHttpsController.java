package com.ymmihw.spring.cloud.consul.https;

import org.springframework.web.bind.annotation.RequestMapping;

public interface FeignHttpsController {
  @RequestMapping("/https")
  String greeting();
}
