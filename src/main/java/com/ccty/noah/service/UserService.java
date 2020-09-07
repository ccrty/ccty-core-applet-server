package com.ccty.noah.service;

import com.ccty.noah.domain.dto.UserDTO;
import com.ccty.noah.domain.dto.UserListConditionDTO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author 缄默
 * @date   2020/08/27
 */
public interface UserService {

    /**
     * 校验用户名是否存在
     * @param name
     * @return
     */
    Boolean validUserName(String name);

    /**
     * 根据用户名获取用户信息
     * @param name
     * @return
     */
    UserDTO getUserInfoByUserName(String name);

    /**
     * 登陆
     * @param name
     * @param password
     * @return
     */
    UserDTO doLogin(String name,String password);

    /**
     * 根据条件查询用户列表
     * @param condition
     * @return
     */
    PageInfo<UserDTO> getUserListByCondition(UserListConditionDTO condition);

    /**
     * 校验用户名是否重复
     * @param name
     * @return
     */
    Boolean reValidUserName(String name);
}
