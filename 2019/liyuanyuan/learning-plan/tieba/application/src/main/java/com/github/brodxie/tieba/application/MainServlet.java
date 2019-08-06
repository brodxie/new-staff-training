package com.github.brodxie.tieba.application;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xieyu
 */
@WebServlet(name = "mainServlet", urlPatterns = "/*")
public class MainServlet extends GenericServlet {
    private ServletHandlerHolder servletHandlerHolder = new ServletHandlerHolder();

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        httpService(request, response);
    }

    protected void httpService(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
            if (1 == 1) return;
            for (ServletHandler servletHandler : servletHandlerHolder.getServletHandlers()) {
                if (match(servletHandler, request)) {
                    servletHandler.handleRequest(request, response);
                    break;
                }
            }
        } catch (Exception e) {
            //TODO 应当处理异常
            e.printStackTrace();
        }
    }

    private boolean match(ServletHandler servletHandler, HttpServletRequest request) {
        String uri = request.getRequestURI();
        String method = request.getMethod();
        return StringUtils.equals(servletHandler.getUri(), uri) &&
                StringUtils.equals(servletHandler.getMethod(), method);
    }
}
