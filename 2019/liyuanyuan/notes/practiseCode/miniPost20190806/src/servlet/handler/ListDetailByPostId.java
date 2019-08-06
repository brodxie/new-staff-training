package servlet.handler;

import com.alibaba.fastjson.JSONArray;
import service.PostService;
import service.serviceImpl.PostServiceImpl;
import servlet.ServletHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 根据主贴id查询更贴详情
public class ListDetailByPostId implements ServletHandler {

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
}
