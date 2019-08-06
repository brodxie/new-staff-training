package servlet.handler;

import com.alibaba.fastjson.JSONArray;
import service.PostService;
import service.serviceImpl.PostServiceImpl;
import servlet.ServletHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 根据子贴id删除子贴
 */
public class DeleteDetailById implements ServletHandler {

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
        Integer detailId = Integer.valueOf(request.getParameter("detailId"));
        int deleteRow = postService.deleteDetailById(detailId);
        System.out.println("deletePostById postId:"+detailId+ " deleteRow:"+deleteRow);
        response.getWriter().write(JSONArray.toJSON(deleteRow).toString());
    }
}
