package com.ccty.noah.service;

import com.ccty.noah.domain.dto.UserDTO;

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
     * @param userDTO
     * @return
     */
    UserDTO doLogin(UserDTO userDTO);
}
