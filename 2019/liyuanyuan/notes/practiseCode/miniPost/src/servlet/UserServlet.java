package servlet;

import config.ToolConfig;
import domain.UserInfo;
import service.UserService;
import service.serviceImpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
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

    // ��ȡ�����û���Ϣ
    public void getAllUserInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            ArrayList<UserInfo> userInfos = userService.getAllUsers();
            request.setAttribute("userInfoList", userInfos);
            request.getRequestDispatcher("/user/userManage.jsp").forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // �޸��û����ͣ���Ϊ����Ա��
    public void updateUserType(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("updateUserType action!");
        int userId = Integer.parseInt(request.getParameter("userId"));
     //   int typeId = Integer.parseInt(request.getParameter("typeId"));
        userService.updateUserType(userId,2);
        getAllUserInfo(request,response);
        System.out.println("updateUserType pass! userId:"+userId);
    }

    // �����û�
    public void addNewUser(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html;charset=utf-8");
            String userName = ToolConfig.getNewString(request.getParameter("userName"));
            String userType = ToolConfig.getNewString(request.getParameter("userType"));
            String password = request.getParameter("password");

            userService.addNewUser(userName,userType,password);
            System.out.println("addNewUser action! userName:"+userName+" userType:"+userType+" password:"+password);
            getAllUserInfo(request,response);
            System.out.println("addNewUser pass!");
            request.setAttribute("addFeedInfo", "���û���ӳɹ�!");
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("addFeedInfo", "���û����ʧ��!");
        }
    }

}
