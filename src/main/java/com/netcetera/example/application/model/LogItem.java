package com.netcetera.example.application.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

/**
 * Class that holds the parameters used in the log entry.
 */
@Data
@Builder
public class LogItem {

  @NonNull
  private String id;
  private String url;
  private String method;
  private String keyword;
  private String duration;
  private String responseCode;
}
