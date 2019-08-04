package servlet;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import domain.PostInfo;
import service.PostService;
import service.serviceImpl.PostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet("/postView")
public class PostServlet extends HttpServlet {

    PostService postService = new PostServiceImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String method = request.getParameter("method");
        if(method.equalsIgnoreCase("getAllByUser")){
            getAllByUser(request, response);
        } else if(method.equalsIgnoreCase("listDetailByPostId")){
            listDetailByPostId(request, response);
        } else if (method.equalsIgnoreCase("deletePostById")) {
            deletePostById(request, response);
        } else if (method.equalsIgnoreCase("deleteDetailById")) {
            deleteDetailById(request, response);
        } else if (method.equalsIgnoreCase("getAllPosts")) {
            getAllPosts(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    // 获取所有帖子列表
    public void getAllPosts(HttpServletRequest request, HttpServletResponse response) {
        try {
            JSONArray postInfos = postService.getAllPosts();
            System.out.println("getAllPosts() json:"+postInfos);
            response.getWriter().write(postInfos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 根据用户Id获取帖子列表
    public void getAllByUser(HttpServletRequest request, HttpServletResponse response) {
        try {
            Integer userId = Integer.valueOf(request.getParameter("userId"));
            ArrayList<PostInfo> postInfos = postService.getPostsByUserId(userId);
            JSONArray json = (JSONArray) JSONArray.toJSON(postInfos);
            response.setContentType("text/html;charset=utf-8");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json.toString());
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    // 根据主贴id查询更贴详情
    public void listDetailByPostId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("listDetailByPostId() action!");
        Integer postId = Integer.valueOf(request.getParameter("postId"));
        System.out.println("test postId:"+postId);
        JSONArray details = postService.getDetailsByPostId(postId);
        System.out.println("details:"+details);

        // 根据postId获取postTitle和postContent
        JSONArray postInfo = postService.getInfoByPostId(postId);
        System.out.println("postInfo:"+postInfo);
        request.setAttribute("postInfo", postInfo);

        if (details.size() == 0) {
            request.setAttribute("postDetailMsg", "暂无子贴哦！");
        } else {
            request.setAttribute("details", details);
        }
        request.getRequestDispatcher("/post/postDetail.jsp").forward(request, response);
    }

    // 根据主贴id删除帖子
    public void deletePostById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer postId = Integer.valueOf(request.getParameter("postId"));
        HashMap<String, Integer> deleteRow = postService.deletePostById(postId);
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        System.out.println("deletePostById postId:"+postId+ " deleteRow:"+deleteRow);
        response.getWriter().write(JSONArray.toJSON(deleteRow).toString());
    }

    // 根据子贴id删除子贴
    public void deleteDetailById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer detailId = Integer.valueOf(request.getParameter("detailId"));
        int deleteRow = postService.deleteDetailById(detailId);
        System.out.println("deletePostById postId:"+detailId+ " deleteRow:"+deleteRow);
        response.getWriter().write(JSONArray.toJSON(deleteRow).toString());
    }
}
