package com.github.brodxie.tieba.application;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xieyu
 */
public abstract class JSPPageServletHandler implements ServletHandler {
    @Override
    public String getMethod() {
        return "GET";
    }

    protected abstract String getJspPath();

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getRequestDispatcher(getJspPath()).forward(request, response);
    }
}
