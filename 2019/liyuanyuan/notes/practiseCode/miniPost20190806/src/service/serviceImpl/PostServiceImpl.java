package service.serviceImpl;

import com.alibaba.fastjson.JSONArray;
import dao.PostDao;
import domain.PostInfo;
import service.PostService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class PostServiceImpl implements PostService {

    // 获取帖子信息
    public JSONArray getAllPosts() {
        return PostDao.getAllPosts();
    }

    // 根据用户Id获取帖子信息
    public ArrayList<PostInfo> getPostsByUserId(int userId) throws SQLException {
        return PostDao.getPostsByUserId(userId);
    }

    // 根据postId获取帖子详情
    public JSONArray getDetailsByPostId(int postId) {
        return PostDao.getDetailsByPostId(postId);
    }

    // 根据postId删除主贴
    public HashMap<String, Integer> deletePostById(int postId) {
        return PostDao.deletePostById(postId);
    }

    // 根据postId获取帖子信息
    public JSONArray getInfoByPostId(int postId) {
        return PostDao.getInfoByPostId(postId);
    }

    // 根据detailId删除子贴
    public int deleteDetailById(int postId) {
        return PostDao.deleteDetailById(postId);
    }

}
