package com.elk.example.application.monitoring;

import com.elk.example.application.model.LogItem;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.text.StringSubstitutor;

import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.SPACE;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * Creates log entries for the monitoring of the application.
 */
@Slf4j
public final class LogCreator {

  private static final String SEPARATOR = "|";
  private static final String DEFAULT_TEXT = "null";
  private static final String LOG_PATTERN = "${id} ${url} ${method} ${keyword} ${duration} ${response_code}";

  /**
   * Writes the log in the monitoring log file.
   */
  public static void registerMetric(LogItem logItem) {
    log.info(getLog(logItem));
  }

  private static String getLog(LogItem logItem) {
    Map<String, String> values = new HashMap<>();
    values.put("id", logItem.getId());
    values.put("url", cleanse(logItem.getUrl()));
    values.put("method", cleanse(logItem.getMethod()));
    values.put("keyword", cleanse(logItem.getKeyword()));
    values.put("duration", cleanse(logItem.getDuration()));
    values.put("response_code", cleanse(logItem.getResponseCode()));

    String logPattern = LOG_PATTERN.replace(SPACE, SEPARATOR);
    StringSubstitutor sub = new StringSubstitutor(values);
    return sub.replace(logPattern);
  }

  private static String cleanse(String value) {
    return isNotBlank(value) ? value : DEFAULT_TEXT;
  }
}
