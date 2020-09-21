package com.ccty.noah.controller.applets;

import com.ccty.noah.aop.NoahResult;
import com.ccty.noah.aop.target.NoahController;
import com.ccty.noah.domain.dto.UserRegisterDTO;
import com.ccty.noah.domain.dto.applets.WXUserLoginDTO;
import com.ccty.noah.service.applets.WXLoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 缄默
 * @date   2020/09/21
 */
@Api("微信登陆控制器")
@RequestMapping("/{version}/applets/api/login")
@NoahController
@Slf4j
public class WXLoginController {

    @Autowired
    private WXLoginService loginService;

    @ApiModelProperty(value = "微信登陆 首次登陆注册用户")
    @PostMapping("/login")
    public NoahResult<Boolean> doLogin(@RequestBody @Validated WXUserLoginDTO user){
        loginService.doLogin(user);
        return NoahResult.builderSuccess(Boolean.TRUE);
    }
}
