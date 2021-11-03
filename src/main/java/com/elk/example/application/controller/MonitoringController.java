package com.elk.example.application.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

  /**
   * Dummy endpoint.
   *
   * @return the http response {@link ResponseEntity}.
   */
  @GetMapping("/log")
  public ResponseEntity<Void> getCreate(@RequestParam String keyword) {
    log.info("Param: {}", keyword);
    return ResponseEntity.ok().build();
  }

  /**
   * Dummy endpoint.
   *
   * @return the http response {@link ResponseEntity}.
   */
  @PostMapping("/log")
  public ResponseEntity<Void> postCreate(@RequestParam String keyword) {
    log.info("Param: {}", keyword);
    return ResponseEntity.ok().build();
  }
}
