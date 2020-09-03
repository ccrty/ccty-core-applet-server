package com.ccty.noah.mapper;

import com.ccty.noah.domain.database.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @author 缄默
 * @date   2020/08/27
 */
@Mapper
@Component
public interface UserMapper {

    /**
     * 根据用户名获取信息
     * @param username
     * @return
     */
    Integer queryInfoByUserName(String username);

    /**
     * 根据用户名获取用户信息
     * @param name
     * @return
     */
    UserDO queryUserInfoByUserName(String name);

    /**
     * 根据用户名和密码获取用户信息
     * @param name
     * @param password
     * @return
     */
    UserDO queryInfoByUserNameAndPwd(@Param("name")String name,@Param("password") String password);
}
