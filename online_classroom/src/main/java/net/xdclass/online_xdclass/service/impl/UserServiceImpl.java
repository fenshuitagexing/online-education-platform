package net.xdclass.online_xdclass.service.impl;

import net.xdclass.online_xdclass.model.entity.User;
import net.xdclass.online_xdclass.mapper.UserMapper;
import net.xdclass.online_xdclass.service.UserService;
import net.xdclass.online_xdclass.utils.CommonUtils;
import net.xdclass.online_xdclass.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public int addUser(Map<String, String> userInfo) {

        User user = parseToUser(userInfo);
        // Fixme: Optional
        if (null != user) {
            return userMapper.addUser(user);
        } else {
            return -1;
        }
    }

    @Override
    public String getTokenByPhoneAndPwd(String phone, String pwd) {

        User user = userMapper.getUserInfoByPhoneAndPwd(phone, CommonUtils.MD5(pwd));
        if (null == user) {
            return null;
        } else {
            return JwtUtils.genJsonWebToken(user);
        }
    }

    private User parseToUser(Map<String, String> userInfo) {

        if (userInfo.containsKey("phone")
            && userInfo.containsKey("pwd")
            && userInfo.containsKey("name")) {
            User user = new User(userInfo.get("name"),
                                userInfo.get("phone"),
                                new Date());
            user.setHeadshot(getRandomHeadshot());
            user.setPwd(CommonUtils.MD5(userInfo.get("pwd")));
            return user;
        } else {
            return null;
        }
    }

    private static final String [] headshots = {
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/12.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/11.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/13.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/14.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/15.jpeg"
    };

    private String getRandomHeadshot() {
        Random random = new Random();
        int index = random.nextInt(headshots.length);
        return headshots[index];
    }
}
