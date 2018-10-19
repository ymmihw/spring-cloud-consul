package com.ymmihw.spring.cloud.consul.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HttpController {
  @Autowired
  private FeignHttpClient client;

  @ResponseBody
  @RequestMapping("/http2")
  public String getGreeting() {
    return client.greeting();
  }
}
