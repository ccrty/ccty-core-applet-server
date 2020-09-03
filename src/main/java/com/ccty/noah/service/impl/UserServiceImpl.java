package com.ccty.noah.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.ccty.noah.aop.aspect.exception.NoahException;
import com.ccty.noah.aop.aspect.target.NoahService;
import com.ccty.noah.domain.constance.ExceptionEnum;
import com.ccty.noah.domain.convertor.UserConvertor;
import com.ccty.noah.domain.database.UserDO;
import com.ccty.noah.domain.dto.UserDTO;
import com.ccty.noah.mapper.UserMapper;
import com.ccty.noah.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

/**
 * @author 缄默
 * @date   2020/08/27
 */
@NoahService
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserConvertor userConvertor;


    /**
     * 校验用户名是否存在
     * @param name 用户名
     * @return
     */
    @Override
    public Boolean validUserName(String name) {
        //用户不存在就抛出错误
        Optional.ofNullable(userMapper.queryInfoByUserName(name))
                .orElseThrow(() -> new NoahException(ExceptionEnum.USER_NAME_ERROR.getCode(), ExceptionEnum.USER_NAME_ERROR.getName()));
        return Boolean.TRUE;
    }

    /**
     * 根据用户名获取用户信息
     * @param name
     * @return
     */
    @Override
    public UserDTO getUserInfoByUserName(String name) {
        UserDO userDO = userMapper.queryUserInfoByUserName(name);
        UserDTO userDTO = userConvertor.userDOToUserDTO(userDO);
        Optional.ofNullable(userDTO)
                .orElseThrow(() -> new NoahException(ExceptionEnum.USER_NAME_ERROR.getCode(), ExceptionEnum.USER_NAME_ERROR.getName()));
        return userDTO;
    }

    /**
     * 登陆
     * @param user
     * @return
     */
    @Override
    public UserDTO doLogin(UserDTO user) {
        String password = SecureUtil.md5(user.getPassword());
        UserDO userDO = userMapper.queryInfoByUserNameAndPwd(user.getName(),password);
        UserDTO userDTO = userConvertor.userDOToUserDTO(userDO);
        Optional.ofNullable(userDTO)
                .orElseThrow(() -> new NoahException(ExceptionEnum.USER_PASSWORD_ERROR.getCode(), ExceptionEnum.USER_PASSWORD_ERROR.getName()));
        return userDTO;
    }

}
