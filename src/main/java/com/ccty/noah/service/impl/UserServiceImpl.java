package com.ccty.noah.service.impl;

import com.ccty.noah.aop.aspect.exception.NoahException;
import com.ccty.noah.aop.aspect.target.NoahService;
import com.ccty.noah.domain.constance.ExceptionEnum;
import com.ccty.noah.domain.dto.UserDTO;
import com.ccty.noah.mapper.UserMapper;
import com.ccty.noah.service.UserService;
import org.apache.commons.lang.StringUtils;
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

    /**
     * 校验用户名
     * @param user
     * @return
     */
    @Override
    public Boolean validUser(UserDTO user) {
        if(StringUtils.isBlank(user.getPassword())){
            //校验用户
            Optional.ofNullable(userMapper.queryInfoByUserName(user.getName()))
                    .orElseThrow(() -> new NoahException(ExceptionEnum.USER_NAME_ERROR.getCode(), ExceptionEnum.USER_NAME_ERROR.getName()));
            return Boolean.TRUE;
        }else{
            //校验用户名密码
            throw new NoahException(ExceptionEnum.PASSWORD_ERROR.getCode(), ExceptionEnum.PASSWORD_ERROR.getName());
        }
    }
}
