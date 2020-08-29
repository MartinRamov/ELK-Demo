package com.netcetera.example.application.monitoring;

import lombok.extern.slf4j.Slf4j;

/**
 * Creates log entries for the monitoring of the application.
 */
@Slf4j
public final class MonitoringService {

  public static final String DELIMITER = "|";

  /**
   * Writes the log in the monitoring log file.
   */
  public static void log() {
    log.info("XYZ");
  }
}
