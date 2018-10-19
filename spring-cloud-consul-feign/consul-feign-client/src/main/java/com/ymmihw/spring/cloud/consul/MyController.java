package com.ymmihw.spring.cloud.consul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
  @Autowired
  private FeignHttpClient httpClient;

  @ResponseBody
  @RequestMapping("/http2")
  public String getGreeting() {
    return httpClient.greeting();
  }
}
