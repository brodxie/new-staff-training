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


    // ��ȡ�û�������Ϣ
    @Override
    public ArrayList<UserInfo> getAllUsers() {
        ArrayList<UserInfo> userInfos = UserDao.getAllUser();
        return userInfos;
    }

    // ��֤��¼��Ϣ
    @Override
    public HashMap<String,Integer> confirmLoginInfo(String userName, String passWord) {
        HashMap<String,Integer> tmpUserMap = UserDao.getUserId(userName, passWord);
        return tmpUserMap;
    }

    // �����û�����
    @Override
    public int updateUserType(int userId, int typeId) {
        return UserDao.updateUserType(userId,typeId);
    }

    // �����û�
    @Override
    public int addNewUser(String userName, String userType, String password) throws SQLException {
        return UserDao.addNewUser(userName,userType,password);
    }

}
