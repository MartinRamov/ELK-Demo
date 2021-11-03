package com.elk.example.application.interceptor;

import com.elk.example.application.monitoring.LogCreator;
import com.elk.example.application.model.LogItem;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Custom endpoint interceptor.
 */
@Component
public class RequestInterceptor implements HandlerInterceptor {

  private static final String REQUEST_TIME = "REQUEST_TIME";
  private static final String REQUEST_ID = "REQUEST_ID";
  private static final String KEYWORD = "keyword";

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
    String id = UUID.randomUUID().toString();
    LocalDateTime requestTime = LocalDateTime.now();

    String url = request.getRequestURL().toString();
    String keyword = request.getParameter(KEYWORD);

    request.setAttribute(REQUEST_ID, id);
    request.setAttribute(REQUEST_TIME, requestTime);

    LogItem metric = LogItem.builder()
        .id(id)
        .url(url)
        .keyword(keyword)
        .method(request.getMethod())
        .build();
    LogCreator.registerMetric(metric);

    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request,
                         HttpServletResponse response,
                         Object handler,
                         ModelAndView modelAndView) {
    String id = (String) request.getAttribute(REQUEST_ID);
    LocalDateTime requestTime = (LocalDateTime) request.getAttribute(REQUEST_TIME);
    Long duration = Duration.between(requestTime, LocalDateTime.now()).toMillis();

    LogItem metric = LogItem.builder()
        .id(id)
        .duration(String.valueOf(duration))
        .responseCode(String.valueOf(response.getStatus()))
        .build();
    LogCreator.registerMetric(metric);
  }
}
