package com.netcetera.example.application.controller;

import com.netcetera.example.application.monitoring.MonitoringService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Monitoring Controller.
 */
@Slf4j
@RestController
@RequestMapping(
    name = "Monitoring Controller",
    path = "/demo",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
public class MonitoringController {

  @GetMapping("/log")
  public void test() {
    MonitoringService.log();
  }
}
