package service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import domain.PostInfo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public interface PostService {

    // ��ȡ������Ϣ
    public JSONArray getAllPosts();

    // �����û�Id��ȡ������Ϣ
    public ArrayList<PostInfo> getPostsByUserId(int userId) throws SQLException;

    // ����postId��ȡ��������
    public JSONArray getDetailsByPostId(int postId);

    // ����postIdɾ������
    public HashMap<String, Integer> deletePostById(int postId);

    // ����postId��ȡ������Ϣ
    public JSONArray getInfoByPostId(int postId);

    // ����detailIdɾ������
    public int deleteDetailById(int postId);

}
