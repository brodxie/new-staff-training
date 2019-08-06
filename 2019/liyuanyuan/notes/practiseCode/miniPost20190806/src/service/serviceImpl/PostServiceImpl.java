package service.serviceImpl;

import com.alibaba.fastjson.JSONArray;
import dao.PostDao;
import domain.PostInfo;
import service.PostService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class PostServiceImpl implements PostService {

    // ��ȡ������Ϣ
    public JSONArray getAllPosts() {
        return PostDao.getAllPosts();
    }

    // �����û�Id��ȡ������Ϣ
    public ArrayList<PostInfo> getPostsByUserId(int userId) throws SQLException {
        return PostDao.getPostsByUserId(userId);
    }

    // ����postId��ȡ��������
    public JSONArray getDetailsByPostId(int postId) {
        return PostDao.getDetailsByPostId(postId);
    }

    // ����postIdɾ������
    public HashMap<String, Integer> deletePostById(int postId) {
        return PostDao.deletePostById(postId);
    }

    // ����postId��ȡ������Ϣ
    public JSONArray getInfoByPostId(int postId) {
        return PostDao.getInfoByPostId(postId);
    }

    // ����detailIdɾ������
    public int deleteDetailById(int postId) {
        return PostDao.deleteDetailById(postId);
    }

}
