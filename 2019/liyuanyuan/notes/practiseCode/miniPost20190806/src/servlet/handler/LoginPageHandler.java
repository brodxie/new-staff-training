package servlet.handler;

import servlet.ServletHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginPageHandler implements ServletHandler {
    @Override
    public String requestUri() {
        return "/login";
    }

    @Override
    public String requestMethod() {
        return "GET";
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
