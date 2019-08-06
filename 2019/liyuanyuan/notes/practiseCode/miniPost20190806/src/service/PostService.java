package service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import domain.PostInfo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public interface PostService {

    // 获取帖子信息
    public JSONArray getAllPosts();

    // 根据用户Id获取帖子信息
    public ArrayList<PostInfo> getPostsByUserId(int userId) throws SQLException;

    // 根据postId获取帖子详情
    public JSONArray getDetailsByPostId(int postId);

    // 根据postId删除主贴
    public HashMap<String, Integer> deletePostById(int postId);

    // 根据postId获取帖子信息
    public JSONArray getInfoByPostId(int postId);

    // 根据detailId删除子贴
    public int deleteDetailById(int postId);

}
