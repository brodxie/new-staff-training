package servlet.handler;

import service.UserService;
import service.serviceImpl.UserServiceImpl;
import servlet.ServletHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * 用户登录
 */
public class LoginHandler implements ServletHandler {

    UserService userService = new UserServiceImpl();

    @Override
    public String requestUri() {
        return "/login";
    }

    @Override
    public String requestMethod() {
        return "POST";
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        HashMap<String,Integer> userInfo = userService.confirmLoginInfo(username, password);
        if(userInfo != null){
            HttpSession session = request.getSession();
            session.setAttribute("userInfo", userInfo);
            response.sendRedirect("/post/postInfo");
        } else {
            request.setAttribute("message", "用户名或密码无效!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
