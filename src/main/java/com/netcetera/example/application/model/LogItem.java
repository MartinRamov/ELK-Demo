package com.netcetera.example.application.model;

import lombok.Builder;
import lombok.Data;

/**
 * Class that holds the parameters used in the log entry.
 */
@Data
@Builder
public class LogItem {

  private String id;
  private String url;
  private String method;
  private String keyword;
  private String duration;
  private String responseCode;
}
