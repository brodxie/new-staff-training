package servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ServletHandler {
    /**
     * 要处理的路径
     *
     * @return
     */
    String requestUri();

    /**
     * 要处理的method
     *
     * @return
     */
    String requestMethod();

    /**
     * 处理方法
     *
     * @param request
     * @param response
     */
    void handle(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
