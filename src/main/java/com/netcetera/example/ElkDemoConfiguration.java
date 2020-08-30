package com.netcetera.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class ElkDemoConfiguration implements WebMvcConfigurer {

  private List<HandlerInterceptor> interceptors;

  @Autowired
  public void setInterceptors(List<HandlerInterceptor> interceptors) {
    this.interceptors = interceptors;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    interceptors.forEach(registry::addInterceptor);
  }
}
