package com.github.brodxie.tieba.application.handler;

import com.github.brodxie.tieba.application.JSPPageServletHandler;

/**
 * @author xieyu
 */
public class GetLoginHandler extends JSPPageServletHandler {
    @Override
    protected String getJspPath() {
        return "/jsp/login.jsp";
    }

    @Override
    public String getUri() {
        return "/login";
    }
}
