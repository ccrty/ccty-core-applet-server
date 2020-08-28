package com.ccty.noah.service;

import com.ccty.noah.domain.dto.UserDTO;

/**
 * @author 缄默
 * @date   2020/08/27
 */
public interface UserService {
    /**
     * 校验用户名是否存在
     * @param user
     * @return
     */
    Boolean validUser(UserDTO user);
}
