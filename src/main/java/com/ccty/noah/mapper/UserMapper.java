package com.ccty.noah.mapper;

import com.ccty.noah.domain.database.UserDO;
import com.ccty.noah.domain.database.UserListConditionDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

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
     * @param type
     * @return
     */
    Integer queryInfoByUserName(@Param("username") String username,@Param("type")Integer type);

    /**
     * 根据用户名获取用户信息
     * @param name
     * @param type
     * @return
     */
    UserDO queryUserInfoByUserName(@Param("name") String name,@Param("type")Integer type);

    /**
     * 根据用户名和密码获取用户信息
     * @param name
     * @param password
     * @param type
     * @return
     */
    UserDO queryInfoByUserNameAndPwd(@Param("name")String name,@Param("password") String password,@Param("type") Integer type);

    /**
     * 根据条件获取用户信息
     * @param condition
     * @return
     */
    List<UserDO> queryUserListByCondition(UserListConditionDO condition);

    /**
     * 新增用户
     * @param userDO
     */
    void insertUser(UserDO userDO);

    /**
     * 根据手机号获取用户信息
     * @param phone
     * @param type
     * @return
     */
    UserDO queryInfoByPhone(@Param("phone") String phone,@Param("type") Integer type);

    /**
     * 用户授权角色
     * @param roleId
     * @param list
     */
    void userAuthRole(@Param("roleId") Long roleId,@Param("list") List<Long> list);
}
