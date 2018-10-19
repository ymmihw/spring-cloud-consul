package com.ymmihw.spring.cloud.consul.https;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HttpsController {
  @Autowired
  private FeignHttpsClient client;

  @ResponseBody
  @RequestMapping("/https2")
  public String getGreeting() {
    return client.greeting();
  }
}
