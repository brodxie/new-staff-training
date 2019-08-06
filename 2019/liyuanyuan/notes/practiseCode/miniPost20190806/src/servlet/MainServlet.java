package servlet;

import servlet.handler.LoginHandler;
import servlet.handler.LoginPageHandler;
import servlet.handler.PostInfoPage;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@WebServlet("/*")
public class MainServlet extends GenericServlet {
    private List<ServletHandler> servletHandlers = new ArrayList<>();

    public MainServlet() {
        servletHandlers.add(new PostInfoPage());
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        try {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            String uri = request.getRequestURI();
            String method = request.getMethod();
            for (ServletHandler servletHandler : servletHandlers) {
                if (Objects.equals(uri, servletHandler.requestUri()) &&
                        Objects.equals(method, servletHandler.requestMethod())) {
                    servletHandler.handle(request, response);
                    break;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
