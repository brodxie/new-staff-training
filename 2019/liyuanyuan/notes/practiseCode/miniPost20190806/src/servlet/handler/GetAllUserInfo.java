package servlet.handler;

import domain.UserInfo;
import service.UserService;
import service.serviceImpl.UserServiceImpl;
import servlet.ServletHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

// 获取所有用户信息
public class GetAllUserInfo implements ServletHandler {

    UserService userService = new UserServiceImpl();

    @Override
    public String requestUri() {
        return "/userManage";
    }

    @Override
    public String requestMethod() {
        return "POST";
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            ArrayList<UserInfo> userInfos = userService.getAllUsers();
            request.setAttribute("userInfoList", userInfos);
            request.getRequestDispatcher("/user/userManage.jsp").forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
