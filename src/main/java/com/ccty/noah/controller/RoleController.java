package com.ccty.noah.controller;

import com.ccty.noah.aop.NoahResult;
import com.ccty.noah.domain.dto.RoleDTO;
import com.ccty.noah.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ryan
 * @date 2020/09/15
 */
@Api("角色资源控制器")
@RequestMapping("/{version/api/role}")
public class RoleController {

    @Autowired
    private RoleService roleService;



    @ApiModelProperty(value = "检验角色名是否存在")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value="用户名",required = true,paramType = "query",dataType = "string")
    })
    @PostMapping("/valid/role/name")
    public NoahResult<Boolean> valiRoleName(@RequestParam("name") String name){
        return NoahResult.builderSuccess(roleService.validRoleName(name));
    }

    public NoahResult<Boolean> doInsertRole(@RequestBody @Validated RoleDTO role){
        roleService.doInsertRole(role);
        return NoahResult.builderSuccess(Boolean.TRUE);
    }
}
