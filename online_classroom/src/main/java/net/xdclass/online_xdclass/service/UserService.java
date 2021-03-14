package net.xdclass.online_xdclass.service;

import net.xdclass.online_xdclass.model.entity.User;

import java.util.Map;

public interface UserService {

    int addUser(Map<String, String> userInfo);

    String getTokenByPhoneAndPwd(String phone, String pwd);

    User getUserInfoById(Integer userId);

//    User getUserInfoByPhone(String phone);
}
