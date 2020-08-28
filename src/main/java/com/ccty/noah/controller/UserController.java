package com.ccty.noah.controller;

import com.ccty.noah.aop.aspect.NoahResult;
import com.ccty.noah.aop.aspect.exception.NoahException;
import com.ccty.noah.aop.aspect.target.NoahController;
import com.ccty.noah.domain.constance.ExceptionEnum;
import com.ccty.noah.domain.dto.UserDTO;
import com.ccty.noah.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "校验用户信息")
    @PostMapping("/valid/userInfo")
    public NoahResult<Boolean> validUserInfo(@RequestBody UserDTO userDTO){
        Optional.ofNullable(userDTO).orElseThrow(() -> new NoahException(ExceptionEnum.USER_NULL_ERROR.getCode(), ExceptionEnum.USER_NULL_ERROR.getName()));
        Optional.ofNullable(userDTO.getName()).orElseThrow(() -> new NoahException(ExceptionEnum.USER_NAME_NULL_ERROR.getCode(), ExceptionEnum.USER_NAME_NULL_ERROR.getName()));
        return NoahResult.builderSuccess(userService.validUser(userDTO));
    }
}
