package com.ccty.noah.controller;

import com.ccty.noah.aop.NoahResult;
import com.ccty.noah.aop.target.NoahController;
import com.ccty.noah.domain.dto.RoleDTO;
import com.ccty.noah.domain.dto.RoleListConditionDTO;
import com.ccty.noah.domain.dto.UserDTO;
import com.ccty.noah.domain.dto.UserListConditionDTO;
import com.ccty.noah.service.RoleService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ryan & 缄默
 * @date 2020/09/15
 */
@Api("角色控制器")
@NoahController
@RequestMapping("/{version}/api/role")
public class RoleController {

    @Autowired
    private RoleService roleService;



    @ApiOperation(value = "检验角色名是否存在")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value="用户名",required = true,paramType = "query",dataType = "string")
    })
    @PostMapping("/valid/role/name")
    public NoahResult<Boolean> validRoleName(@RequestParam("name") String name){
        return NoahResult.builderSuccess(roleService.validRoleName(name));
    }

    @ApiOperation(value = "新增角色")
    @PostMapping
    public NoahResult<Boolean> doInsertRole(@RequestBody @Validated RoleDTO role){
        roleService.doInsertRole(role);
        return NoahResult.builderSuccess(Boolean.TRUE);
    }

    @ApiOperation(value = "获取角色列表")
    @GetMapping("/list")
    public NoahResult<PageInfo<RoleDTO>> getRoleListByCondition(RoleListConditionDTO condition){
        return NoahResult.builderSuccess(roleService.getRoleListByCondition(condition));
    }

    @ApiOperation(value = "删除角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value="角色id",required = true,paramType = "query",dataType = "string")
    })
    @DeleteMapping
    public NoahResult<Boolean> doDeleteRole(@RequestParam("id")Long id){
        roleService.doDeleteRole(id);
        return NoahResult.builderSuccess(Boolean.TRUE);
    }

    @ApiOperation(value = "修改角色")
    @PutMapping
    public NoahResult<Boolean> doUpdateRole(@RequestBody @Validated RoleDTO role){
        roleService.doUpdateRole(role);
        return NoahResult.builderSuccess(Boolean.TRUE);
    }

    @ApiOperation(value = "获取所有角色名")
    @GetMapping("/name/list")
    public NoahResult<List<RoleDTO>> getAllRoleName(){
        return NoahResult.builderSuccess(roleService.getAllRoleName());
    }
}
