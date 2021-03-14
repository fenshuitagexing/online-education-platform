package net.xdclass.online_xdclass.mapper;

import net.xdclass.online_xdclass.model.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    int addUser(User user);

    /**
     *
     * The @param is provided by MyBatis
     *
     * The parameter annotated with @Param must have a value string
     * matching the corresponding SQL query parameter name
     */
    User getUserInfoByPhone(@Param("phone") String phone);

    User getUserInfoByPhoneAndPwd(@Param("phone") String phone, @Param("pwd") String pwd);

    User getUserInfoById(@Param("user_id") Integer userId);
}
