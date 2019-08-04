package service;

import domain.UserInfo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public interface UserService {

    // �û���¼
    public String login(String userName, String password);

    // ��ȡ�û�������Ϣ
    public ArrayList<UserInfo> getAllUsers();

    // ��֤��¼��Ϣ,�����û�ID
    public HashMap<String,Integer> confirmLoginInfo(String userName, String passWord) throws SQLException;

    // �����û�����
    public int updateUserType(int userId, int typeId);

    // �����û�
    public int addNewUser(String userName, String userType, String password) throws SQLException;

}
