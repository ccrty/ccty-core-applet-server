package com.ccty.noah.controller;

import com.ccty.noah.aop.aspect.NoahResult;
import com.ccty.noah.aop.aspect.exception.NoahException;
import com.ccty.noah.aop.aspect.target.NoahController;
import com.ccty.noah.domain.constance.ExceptionEnum;
import com.ccty.noah.domain.dto.UserDTO;
import com.ccty.noah.service.UserService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
}
