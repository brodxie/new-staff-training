package servlet;

import com.alibaba.fastjson.JSONArray;
import domain.UserInfo;
import service.UserService;
import service.serviceImpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/userManage")
public class UserServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String method = request.getParameter("method");
        if(method.equalsIgnoreCase("getAllUserInfo")){
            getAllUserInfo(request, response);
        } else if (method.equalsIgnoreCase("updateUserType")) {
            updateUserType(request, response);
        } else if (method.equalsIgnoreCase("addNewUser")) {
            addNewUser(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

    // 获取所有用户信息
    public void getAllUserInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            ArrayList<UserInfo> userInfos = userService.getAllUsers();
            request.setAttribute("userInfoList", userInfos);
            request.getRequestDispatcher("/user/userManage.jsp").forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 修改用户类型（设为管理员）
    public void updateUserType(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("updateUserType action!");
        int userId = Integer.parseInt(request.getParameter("userId"));
     //   int typeId = Integer.parseInt(request.getParameter("typeId"));
        userService.updateUserType(userId,2);
        getAllUserInfo(request,response);
        System.out.println("updateUserType pass! userId:"+userId);
    }

    // 增加用户
    public void addNewUser(HttpServletRequest request, HttpServletResponse response) {
        try {
            String userName = request.getParameter("userName");
            String userType = request.getParameter("userType");
            String password = request.getParameter("password");
            userService.addNewUser(userName,userType,password);
            System.out.println("addNewUser action! userName:"+userName+" userType:"+userType+" password:"+password);
            getAllUserInfo(request,response);
            System.out.println("addNewUser pass!");
            request.setAttribute("addFeedInfo", "新用户添加成功!");
        } catch (ServletException | SQLException e) {
            e.printStackTrace();
            request.setAttribute("addFeedInfo", "新用户添加失败!");
        }
    }

}
