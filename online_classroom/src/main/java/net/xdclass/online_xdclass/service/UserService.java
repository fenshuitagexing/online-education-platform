package net.xdclass.online_xdclass.service;

import java.util.Map;

public interface UserService {

    int addUser(Map<String, String> userInfo);

    String getTokenByPhoneAndPwd(String phone, String pwd);

//    User getUserInfoByPhone(String phone);
}
