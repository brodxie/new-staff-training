package servlet;

import com.alibaba.fastjson.JSONArray;
import domain.PostInfo;
import service.PostService;
import service.UserService;
import service.serviceImpl.PostServiceImpl;
import service.serviceImpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    PostService postService = new PostServiceImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String method = request.getParameter("method");
        if(method.equalsIgnoreCase("confirmUserInfo")){
            confirmUserInfo(request, response);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    // 验证用户信息
    public void confirmUserInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("userName");
        String password = request.getParameter("passWord");

        try {
            HashMap<String,Integer> userMap = userService.confirmLoginInfo(username, password);

            if(userMap != null){
                int userId = userMap.get("userId");
                int typeId = userMap.get("typeId");
                System.out.println(username + "---" + password+" 是否在？userId:"+userId + " typeId:"+typeId);

                HttpSession session = request.getSession();
                session.setAttribute("loginUserId", userId);
                session.setAttribute("loginUsername", username);
                session.setAttribute("loginTypeId", typeId);

                JSONArray postInfos = postService.getAllPosts();
                request.setAttribute("userId", userId);
                request.setAttribute("username", username);
                request.setAttribute("postInfos", postInfos);
                request.getRequestDispatcher("/post/postInfo.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "用户名或密码无效!");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
