package com.ccty.noah.service.applets;

import com.ccty.noah.domain.dto.applets.WXUserLoginDTO;

/**
 * @author 缄默
 * @date   2020/09/21
 */
public interface WXLoginService {

    /**
     * 微信登陆
     * @param login
     */
    void doLogin(WXUserLoginDTO login);
}
