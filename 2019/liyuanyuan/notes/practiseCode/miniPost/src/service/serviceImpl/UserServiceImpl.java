package service.serviceImpl;

import dao.UserDao;
import domain.UserInfo;
import service.UserService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class UserServiceImpl implements UserService {

    @Override
    public String login(String userName, String password) {
        return null;
    }


    // 获取用户所有信息
    @Override
    public ArrayList<UserInfo> getAllUsers() {
        ArrayList<UserInfo> userInfos = UserDao.getAllUser();
        return userInfos;
    }

    // 验证登录信息
    @Override
    public int confirmLoginInfo(String userName, String passWord) {
        int tmpUserId = UserDao.getUserId(userName, passWord);
        return tmpUserId;
    }

    // 更新用户类型
    @Override
    public int updateUserType(int userId, int typeId) {
        return UserDao.updateUserType(userId,typeId);
    }

    // 新增用户
    @Override
    public int addNewUser(String userName, String userType, String password) throws SQLException {
        return UserDao.addNewUser(userName,userType,password);
    }

}
