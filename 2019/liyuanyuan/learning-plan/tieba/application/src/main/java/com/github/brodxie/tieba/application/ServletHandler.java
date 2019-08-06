package com.github.brodxie.tieba.application;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xieyu
 */
public interface ServletHandler {
    String getUri();

    String getMethod();

    void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
