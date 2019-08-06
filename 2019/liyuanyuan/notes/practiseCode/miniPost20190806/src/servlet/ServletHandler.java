package servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ServletHandler {
    /**
     * Ҫ�����·��
     *
     * @return
     */
    String requestUri();

    /**
     * Ҫ�����method
     *
     * @return
     */
    String requestMethod();

    /**
     * ������
     *
     * @param request
     * @param response
     */
    void handle(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
