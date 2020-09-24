package com.ccty.noah.service.applets.impl;

import cn.hutool.crypto.SecureUtil;
import com.ccty.noah.aop.target.NoahService;
import com.ccty.noah.domain.constance.UserConst;
import com.ccty.noah.domain.convertor.applets.WXLoginConvertor;
import com.ccty.noah.domain.database.UserDO;
import com.ccty.noah.domain.dto.applets.WXUserLoginDTO;
import com.ccty.noah.mapper.UserMapper;
import com.ccty.noah.service.applets.WXLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 缄默
 * @date   2020/09/21
 */
@NoahService
@Slf4j
public class WXLoginServiceImpl implements WXLoginService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private WXLoginConvertor loginConvertor;

    /**
     * 微信登陆 首次登陆先注册
     * @param login
     */
    @Override
    public void doLogin(WXUserLoginDTO login) {
        //用户存在
        if(userMapper.queryInfoByUserName(login.getNickName(),UserConst.APPLETS_TYPE)!=null){
            // todo 前端需要的数据
            return;
        }
        UserDO user = loginConvertor.WXLoginDTOToUserDO(login);
        user.setName(login.getNickName());
        user.setLevel(UserConst.MEMBER_LEVEL_TOURIST);
        //设置初始密码
        user.setPassword(SecureUtil.md5(UserConst.INIT_PASSWORD));
        user.setType(UserConst.APPLETS_TYPE);
        userMapper.insertUser(user);
    }
}
