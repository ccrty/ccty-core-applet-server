package com.ccty.noah.controller;

import com.ccty.noah.aop.aspect.NoahResult;
import com.ccty.noah.aop.aspect.target.NoahController;
import com.ccty.noah.domain.dto.UserDTO;
import com.ccty.noah.domain.dto.UserListConditionDTO;
import com.ccty.noah.service.UserService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 缄默
 * @date   2020/08/25
 */
@Api("用户控制器")
@RequestMapping("/{version}/api/user")
@NoahController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @ApiModelProperty("校验用户名是否存在")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名", required = true, paramType = "query", dataType = "string")
    })
    @PostMapping("/valid/name")
    public NoahResult<Boolean> validUserName(@RequestParam("name") String name){
        return NoahResult.builderSuccess(userService.validUserName(name));
    }

    @ApiModelProperty("根据用户名获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名", required = true, paramType = "path", dataType = "string")
    })
    @GetMapping("/userInfo/{name}")
    public NoahResult<UserDTO> getUserInfoByUserName(@PathVariable("name")String name){
        return NoahResult.builderSuccess(userService.getUserInfoByUserName(name));
    }

    @ApiOperation(value = "登陆")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名", required = true, paramType = "query", dataType = "string"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "query", dataType = "string")
    })
    @PostMapping("/login")
    public NoahResult<UserDTO> doLogin(@RequestParam("name")String name,@RequestParam("password")String password){
        return NoahResult.builderSuccess(userService.doLogin(name,password));
    }

    @ApiOperation("获取用户列表")
    @GetMapping("/list")
    public NoahResult<PageInfo<UserDTO>> getUserListByCondition(UserListConditionDTO condition){
        return NoahResult.builderSuccess(userService.getUserListByCondition(condition));
    }

    @ApiModelProperty("校验用户名是否重复")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名", required = true, paramType = "query", dataType = "string")
    })
    @PostMapping("/reValid/name")
    public NoahResult<Boolean> reValidUserName(@RequestParam("name") String name){
        return NoahResult.builderSuccess(userService.reValidUserName(name));
    }

    @ApiModelProperty("发送短信验证码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号", required = true, paramType = "query", dataType = "string")
    })
    @PostMapping("/SMS/code")
    public NoahResult<Boolean> sendSMS(@RequestParam("phone") String phone){
        return NoahResult.builderSuccess(userService.sendSMS(phone));
    }

    @ApiModelProperty("校验验证码是否正确")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号", required = true, paramType = "query", dataType = "string"),
            @ApiImplicitParam(name = "code", value = "验证码", required = true, paramType = "query", dataType = "string")
    })
    @PostMapping("/valid/code")
    public NoahResult<Boolean> validCode(@RequestParam("phone") String phone,@RequestParam("code") String code){
        return NoahResult.builderSuccess(userService.validCode(phone,code));
    }

    @ApiModelProperty("注册用户")
    @PostMapping("/register")
    public NoahResult<Boolean> doRegister(@RequestBody UserDTO user){
        userService.doRegister(user);
        return NoahResult.builderSuccess(Boolean.TRUE);
    }
}
