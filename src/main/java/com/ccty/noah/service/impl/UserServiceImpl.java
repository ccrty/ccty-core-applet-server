package com.ccty.noah.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.ccty.noah.aop.aspect.exception.NoahException;
import com.ccty.noah.aop.aspect.target.NoahService;
import com.ccty.noah.domain.constance.ExceptionEnum;
import com.ccty.noah.domain.convertor.UserConvertor;
import com.ccty.noah.domain.database.UserDO;
import com.ccty.noah.domain.database.UserListConditionDO;
import com.ccty.noah.domain.dto.UserDTO;
import com.ccty.noah.domain.dto.UserListConditionDTO;
import com.ccty.noah.mapper.UserMapper;
import com.ccty.noah.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
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
     * @param name
     * @param password
     * @return
     */
    @Override
    public UserDTO doLogin(String name,String password) {
        String passwordMd5 = SecureUtil.md5(password);
        UserDO userDO = userMapper.queryInfoByUserNameAndPwd(name,passwordMd5);
        UserDTO userDTO = userConvertor.userDOToUserDTO(userDO);
        Optional.ofNullable(userDTO)
                .orElseThrow(() -> new NoahException(ExceptionEnum.USER_PASSWORD_ERROR.getCode(), ExceptionEnum.USER_PASSWORD_ERROR.getName()));
        return userDTO;
    }

    /**
     * 根据条件查询用户列表
     * @param condition
     * @return
     */
    @Override
    public PageInfo<UserDTO> getUserListByCondition(UserListConditionDTO condition) {
        UserListConditionDO conditionDO = userConvertor.conditionDTOToDO(condition);
        Page page = PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        List<UserDO> userList = userMapper.queryUserListByCondition(conditionDO);
        PageInfo pageInfo = new PageInfo<>(page.getResult());
        List<UserDTO> userDTOS = userConvertor.userDOListToDTO(userList);
        pageInfo.setList(userDTOS);
        return pageInfo;
    }

}
