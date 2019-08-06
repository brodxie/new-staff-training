package servlet.handler;

import com.alibaba.fastjson.JSONArray;
import service.PostService;
import service.serviceImpl.PostServiceImpl;
import servlet.ServletHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * 根据主贴id删除帖子
 */
public class DeletePostById implements ServletHandler {

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
        Integer postId = Integer.valueOf(request.getParameter("postId"));
        HashMap<String, Integer> deleteRow = postService.deletePostById(postId);
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        System.out.println("deletePostById postId:"+postId+ " deleteRow:"+deleteRow);
        response.getWriter().write(JSONArray.toJSON(deleteRow).toString());
    }
}
