package servlet.handler;

import servlet.ServletHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostInfoPage implements ServletHandler {
    @Override
    public String requestUri() {
        return "/postInfo";
    }

    @Override
    public String requestMethod() {
        return "GET";
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getRequestDispatcher("/WEB-INF/jsp/post/postInfo.jsp").forward(request, response);
    }
}
