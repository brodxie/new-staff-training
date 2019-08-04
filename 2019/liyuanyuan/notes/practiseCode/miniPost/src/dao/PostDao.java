package dao;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import config.DataAccess;
import domain.PostDetail;
import domain.PostInfo;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class PostDao {

    // 获取帖子信息
    public static JSONArray getAllPosts() {
        try {
            QueryRunner runner = new QueryRunner(DataAccess.getDataSource());
            Connection conn = DataAccess.getConnection();
            String sql = "SELECT a.post_id AS postId,a.post_title AS postTitle,a.post_content AS postContent,a.user_id AS userId,b.user_name AS userName FROM tbl_post_info a,tbl_user_info b WHERE a.user_id = b.user_id";
            JSONArray json = (JSONArray) JSONArray.toJSON(runner.query(conn, sql, new MapListHandler()));
            return json;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 根据用户Id查询帖子信息
    public static ArrayList<PostInfo> getPostsByUserId(int userId) throws SQLException {
        try {
            QueryRunner runner = new QueryRunner(DataAccess.getDataSource());
            Connection conn = DataAccess.getConnection();
            String sql = "select post_id as postId, post_title as postTitle, post_content as postContent, user_id as userId from tbl_post_info where user_id = ?";
            ArrayList<PostInfo> tmpList = (ArrayList<PostInfo>)runner.query(conn, sql, new BeanListHandler<>(PostInfo.class), userId);
            return tmpList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 根据postId获取子贴列表
    public static JSONArray getDetailsByPostId(int postId) {
        try {
            QueryRunner runner = new QueryRunner(DataAccess.getDataSource());
            Connection conn = DataAccess.getConnection();
            String sql = "select detail_id as detailId, post_id as postId, detail_title as detailTitle, detail_content as detailContent from tbl_post_detail where post_id = ?";
            Object obj = runner.query(conn, sql, new MapListHandler(), postId);
            if (obj == null) {
                return null;
            } else {
                return (JSONArray) JSONArray.toJSON(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    // 根据postId删除主贴
    public static HashMap<String,Integer> deletePostById(int postId) {
        try {
            QueryRunner runner = new QueryRunner(DataAccess.getDataSource());
            Connection conn = DataAccess.getConnection();
            String sqlPost = "delete from tbl_post_info where post_id = " + postId;
            int rowI = runner.update(conn, sqlPost);
            String sqlDetail = "delete from tbl_post_detail where post_id = " + postId;
            int rowII = runner.update(conn, sqlDetail);
            HashMap<String,Integer> rowMap = new HashMap<>();
            rowMap.put("postRow",rowI);
            rowMap.put("detailRow",rowII);
            System.out.println("deletePostById row:"+rowMap);
            return rowMap;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    // 根据postId获取帖子信息
    public static JSONArray getInfoByPostId(int postId) {
        try {
            QueryRunner runner = new QueryRunner(DataAccess.getDataSource());
            Connection conn = DataAccess.getConnection();
            String sql = "select post_title as postTitle, post_content as postContent from tbl_post_info where post_id = ?";
            JSONArray json = (JSONArray) JSONArray.toJSON(runner.query(conn, sql, new MapListHandler(), postId));
            return json;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    // 根据detailId删除子贴
    public static int deleteDetailById(int detailId) {
        try {
            QueryRunner runner = new QueryRunner(DataAccess.getDataSource());
            Connection conn = DataAccess.getConnection();
            String sqlPost = "delete from tbl_post_detail where detail_id = " + detailId;
            return runner.update(conn, sqlPost);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
