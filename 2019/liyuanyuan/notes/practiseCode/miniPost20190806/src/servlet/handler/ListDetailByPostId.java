package servlet.handler;

import com.alibaba.fastjson.JSONArray;
import service.PostService;
import service.serviceImpl.PostServiceImpl;
import servlet.ServletHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// ��������id��ѯ��������
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

        // ����postId��ȡpostTitle��postContent
        JSONArray postInfo = postService.getInfoByPostId(postId);
        System.out.println("postInfo:"+postInfo);
        request.setAttribute("postInfo", postInfo);

        if (details.size() == 0) {
            request.setAttribute("postDetailMsg", "��������Ŷ��");
        } else {
            request.setAttribute("details", details);
        }
        request.getRequestDispatcher("/post/postDetail.jsp").forward(request, response);
    }
}
