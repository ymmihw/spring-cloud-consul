package com.ymmihw.spring.cloud.consul.https;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.cloud.openfeign.ribbon.CachingSpringLoadBalancerFactory;
import org.springframework.cloud.openfeign.ribbon.LoadBalancerFeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import feign.Client;
import feign.auth.BasicAuthRequestInterceptor;

@Configuration
public class FeignConfig {

  @Bean
  @ConditionalOnMissingBean
  public Client feignClient(CachingSpringLoadBalancerFactory cachingFactory,
      SpringClientFactory clientFactory) throws NoSuchAlgorithmException, KeyManagementException {
    SSLContext ctx = SSLContext.getInstance("TLSv1.2");
    X509TrustManager tm = new X509TrustManager() {
      @Override
      public void checkClientTrusted(X509Certificate[] chain, String authType)
          throws CertificateException {}

      @Override
      public void checkServerTrusted(X509Certificate[] chain, String authType)
          throws CertificateException {}

      @Override
      public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
      }
    };
    ctx.init(null, new TrustManager[] {tm}, null);
    return new LoadBalancerFeignClient(
        new Client.Default(ctx.getSocketFactory(),
            (hostname, sslSession) -> hostname.equalsIgnoreCase(sslSession.getPeerHost())),
        cachingFactory, clientFactory);
  }

  @Bean
  public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
    return new BasicAuthRequestInterceptor("admin", "admin");
  }
}
