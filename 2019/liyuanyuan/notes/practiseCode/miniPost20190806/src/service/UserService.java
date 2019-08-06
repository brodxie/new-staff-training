package service;

import domain.UserInfo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public interface UserService {

    // 用户登录
    public String login(String userName, String password);

    // 获取用户所有信息
    public ArrayList<UserInfo> getAllUsers();

    // 验证登录信息,返回用户ID
    public HashMap<String,Integer> confirmLoginInfo(String userName, String passWord) throws SQLException;

    // 更新用户类型
    public int updateUserType(int userId, int typeId);

    // 新增用户
    public int addNewUser(String userName, String userType, String password) throws SQLException;

}
