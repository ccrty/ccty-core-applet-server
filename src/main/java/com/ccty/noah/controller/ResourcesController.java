package com.ccty.noah.controller;

import com.ccty.noah.aop.NoahResult;
import com.ccty.noah.aop.target.NoahController;
import com.ccty.noah.domain.dto.ResourcesDTO;
import com.ccty.noah.domain.dto.ResourcesListConditionDTO;
import com.ccty.noah.service.ResourcesService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author 缄默
 * @date   2020/09/21
 */
@Api("角色控制器")
@NoahController
@RequestMapping("/{version}/api/resources")
public class ResourcesController {

    @Autowired
    private ResourcesService resourcesService;

    @ApiOperation(value = "新增资源")
    @PostMapping
    public NoahResult<Boolean> doInsertResources(@RequestBody @Validated ResourcesDTO resources){
        resourcesService.doInsertResources(resources);
        return NoahResult.builderSuccess(Boolean.TRUE);
    }

    @ApiOperation(value = "获取资源列表")
    @GetMapping("/list")
    public NoahResult<PageInfo<ResourcesDTO>> getResourcesListByCondition(ResourcesListConditionDTO condition){
        return NoahResult.builderSuccess(resourcesService.getResourcesListByCondition(condition));
    }

    @ApiOperation(value = "删除资源")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value="资源id",required = true,paramType = "query",dataType = "string")
    })
    @DeleteMapping
    public NoahResult<Boolean> doDeleteRole(@RequestParam("id")Long id){
        resourcesService.doDeleteResources(id);
        return NoahResult.builderSuccess(Boolean.TRUE);
    }

    @ApiOperation(value = "修改资源")
    @PutMapping
    public NoahResult<Boolean> doUpdateResources(@RequestBody @Validated ResourcesDTO resources){
        resourcesService.doUpdateResources(resources);
        return NoahResult.builderSuccess(Boolean.TRUE);
    }
}
