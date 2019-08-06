package servlet.handler;

import com.alibaba.fastjson.JSONArray;
import service.PostService;
import service.serviceImpl.PostServiceImpl;
import servlet.ServletHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 获取所有帖子列表
public class GetAllPosts implements ServletHandler {

    PostService postService = new PostServiceImpl();

    @Override
    public String requestUri() {
        return "/postView";
    }

    @Override
    public String requestMethod() {
        return "POST";
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            JSONArray postInfos = postService.getAllPosts();
            System.out.println("getAllPosts() json:"+postInfos);
            request.setAttribute("postInfos", postInfos);
            request.getRequestDispatcher("/post/postInfo.jsp").forward(request, response);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }

    }
}
