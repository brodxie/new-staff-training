package dao;

import config.DataAccess;
import domain.UserInfo;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class UserDao {

    // 1.查询全部用户信息
    public static ArrayList<UserInfo> getAllUser() {
        try {
            QueryRunner runner = new QueryRunner(DataAccess.getDataSource());
            Connection conn = DataAccess.getConnection();
            String sql = "SELECT user_id AS userId, user_name AS userName, user_type AS userType, a.create_time AS signInTime FROM tbl_user_info a, tbl_user_type b WHERE b.type_id = a.type_id";
            return (ArrayList<UserInfo>)runner.query(conn, sql, new BeanListHandler(UserInfo.class));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    // 2.验证用户信息
    public static int getUserId(String userName, String passWord) {
        try {
            QueryRunner runner = new QueryRunner(DataAccess.getDataSource());
            Connection conn = DataAccess.getConnection();
            System.out.println("getAUser userName:"+userName+" passWord:"+passWord);
            String sql = "select user_id as userId from tbl_user_info where user_name = ? and password = ?";
            String[] params = {userName, passWord};
            Object obj = runner.query(conn, sql, new ScalarHandler(), params);
            if (obj == null) {
                return 0;
            } else {
                return (int)obj;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    // 3. 更新用户类型
    public static int updateUserType(int userId, int typeId) {
        try {
            QueryRunner runner = new QueryRunner(DataAccess.getDataSource());
            Connection conn = DataAccess.getConnection();
            String sql = "UPDATE tbl_user_info SET type_id = "+typeId+" WHERE user_id = " + userId;
            int row = runner.update(conn, sql);
            System.out.println("updateUserType row:"+row);
            return row;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    // 4. 新增用户
    public static int addNewUser(String userName, String userType, String password) throws SQLException {
        QueryRunner runner = new QueryRunner(DataAccess.getDataSource());
        Connection conn = DataAccess.getConnection();
        String sql = "insert into tbl_user_info(user_name, type_id, password) values(?,?,?)";
        int typeId;
        if (userType.equals("超级管理员")) {
            typeId = 1;
        } else if (userType.equals("普通管理员")) {
            typeId = 2;
        } else {
            typeId = 3;
        }
        Object params[] = {userName, typeId, password};
        return runner.update(conn, sql, params);
    }

}
