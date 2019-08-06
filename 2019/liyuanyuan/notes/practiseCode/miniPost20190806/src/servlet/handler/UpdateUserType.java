package servlet.handler;

import service.UserService;
import service.serviceImpl.UserServiceImpl;
import servlet.ServletHandler;
import servlet.UserServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 修改用户类型（设为管理员）
public class UpdateUserType implements ServletHandler {

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
        System.out.println("updateUserType action!");
        int userId = Integer.parseInt(request.getParameter("userId"));
        //   int typeId = Integer.parseInt(handle.getParameter("typeId"));
        userService.updateUserType(userId,2);
        UserServlet.getAllUserInfo(request,response);
        System.out.println("updateUserType pass! userId:"+userId);
    }
}
