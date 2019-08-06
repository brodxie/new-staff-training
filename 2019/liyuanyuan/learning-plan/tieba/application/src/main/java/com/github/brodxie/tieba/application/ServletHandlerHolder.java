package com.github.brodxie.tieba.application;

import com.github.brodxie.tieba.application.handler.GetLoginHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xieyu
 */
public class ServletHandlerHolder {
    private List<ServletHandler> servletHandlers = new ArrayList<>();

    public ServletHandlerHolder() {
        servletHandlers.add(new GetLoginHandler());
    }

    public List<ServletHandler> getServletHandlers() {
        return servletHandlers;
    }
}
