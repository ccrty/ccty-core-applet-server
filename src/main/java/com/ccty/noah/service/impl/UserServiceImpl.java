package com.ccty.noah.service.impl;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.crypto.SecureUtil;
import com.ccty.noah.aop.exception.NoahException;
import com.ccty.noah.aop.target.NoahService;
import com.ccty.noah.domain.constance.ExceptionEnum;
import com.ccty.noah.domain.constance.UserConst;
import com.ccty.noah.domain.convertor.UserConvertor;
import com.ccty.noah.domain.database.UserDO;
import com.ccty.noah.domain.database.UserListConditionDO;
import com.ccty.noah.domain.dto.CodeDTO;
import com.ccty.noah.domain.dto.UserDTO;
import com.ccty.noah.domain.dto.UserListConditionDTO;
import com.ccty.noah.domain.dto.UserRegisterDTO;
import com.ccty.noah.mapper.UserMapper;
import com.ccty.noah.service.UserService;
import com.ccty.noah.util.AliyunSmsUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author 缄默
 * @date   2020/08/27
 */
@NoahService
@Slf4j
public class UserServiceImpl implements UserService {

    private static Map<String, CodeDTO> codeCache = Maps.newConcurrentMap();

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserConvertor userConvertor;
    @Autowired
    private AliyunSmsUtils smsUtils;


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

    /**
     * 校验用户名是否重复
     * @param name 用户名
     * @return
     */
    @Override
    public Boolean reValidUserName(String name) {
        //用户不存在就抛出错误
        if(!ObjectUtils.isEmpty(userMapper.queryInfoByUserName(name))){
            throw new NoahException(ExceptionEnum.USER_REPEAT_ERROR.getCode(),ExceptionEnum.USER_REPEAT_ERROR.getName());
        }
        return Boolean.TRUE;
    }

    /**
     * 发送短信验证码
     * @param phone
     * @return
     */
    @Override
    public Boolean sendSMS(String phone) {
        String code = String.valueOf((int)((Math.random()*9+1)*100000));
        //发送短信
        smsUtils.sendSMS(phone,code);
        CodeDTO codeDTO = new CodeDTO(phone,code,new Date());
        //放入map
        codeCache.put(phone,codeDTO);
        return Boolean.TRUE;
    }

    /**
     * 校验短信验证码
     * @param phone
     * @param code
     * @return
     */
    private void validCode(String phone,String code) {
        //获取缓存数据
        CodeDTO codeDTO = codeCache.get(phone);
        if(ObjectUtils.isEmpty(codeDTO)){
            throw new NoahException(ExceptionEnum.CODE_INPUT_ERROR.getCode(),ExceptionEnum.CODE_INPUT_ERROR.getName());
        }
        //验证码不对
        if(!code.equals(codeDTO.getCode())){
            throw new NoahException(ExceptionEnum.CODE_INPUT_ERROR.getCode(),ExceptionEnum.CODE_INPUT_ERROR.getName());
        }
        //判断时间差
        long between = DateUtil.between(codeDTO.getTime(), new Date(), DateUnit.MINUTE);
        codeCache.remove(phone);
        if(between>5){
            throw new NoahException(ExceptionEnum.CODE_EXPIRED_ERROR.getCode(),ExceptionEnum.CODE_EXPIRED_ERROR.getName());
        }
    }

    /**
     * 注册用户
     * @param user
     */
    @Override
    public void doRegister(UserRegisterDTO user) {
        //校验短信验证码
        validCode(user.getPhone(),user.getCode());
        user.setPassword(SecureUtil.md5(user.getPassword()));
        user.setType(UserConst.MANAGER_TYPE);
        UserDO userDO = userConvertor.userDTOToDO(user);
        userMapper.insertUser(userDO);
    }

    /**
     * 手机号登陆
     * @param phone
     * @param code
     * @return
     */
    @Override
    public UserDTO doLoginByPhone(String phone,String code) {
        //校验短信验证码
        validCode(phone,code);
        //根据手机号获取用户信息
        UserDO userDO = userMapper.queryInfoByPhone(phone);
        UserDTO userDTO = userConvertor.userDOToUserDTO(userDO);
        Optional.ofNullable(userDTO)
                .orElseThrow(() -> new NoahException(ExceptionEnum.PHONE_ERROR.getCode(), ExceptionEnum.PHONE_ERROR.getName()));
        return userDTO;
    }

}
