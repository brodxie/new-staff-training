package servlet.handler;

import config.ToolConfig;
import service.UserService;
import service.serviceImpl.UserServiceImpl;
import servlet.ServletHandler;
import servlet.UserServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 增加用户
public class AddNewUser implements ServletHandler {

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
            response.setContentType("text/html;charset=utf-8");
            String userName = ToolConfig.getNewString(request.getParameter("userName"));
            String userType = ToolConfig.getNewString(request.getParameter("userType"));
            String password = request.getParameter("password");

            userService.addNewUser(userName,userType,password);
            System.out.println("addNewUser action! userName:"+userName+" userType:"+userType+" password:"+password);
            UserServlet.getAllUserInfo(request,response);
            System.out.println("addNewUser pass!");
            request.setAttribute("addFeedInfo", "新用户添加成功!");
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("addFeedInfo", "新用户添加失败!");
        }
    }
}
