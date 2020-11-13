package com.ccty.noah.controller;

import com.ccty.noah.aop.NoahResult;
import com.ccty.noah.aop.target.NoahController;
import com.ccty.noah.domain.dto.CarouselDTO;
import com.ccty.noah.domain.dto.PageDTO;
import com.ccty.noah.domain.dto.RoleDTO;
import com.ccty.noah.service.SystemManagerService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 缄默
 * @date   2020/10/15
 */
@Api("系统管理控制器")
@NoahController
@RequestMapping("/{version}/api/system/manager")
public class SystemManagerController {

    @Autowired
    private SystemManagerService systemManagerService;

    @ApiOperation(value = "新增/修改轮播图")
    @PostMapping("/carousel")
    public NoahResult<Boolean> doInsertCarousel(MultipartFile file,Long id){
        systemManagerService.doUpdateCarousel(file,id);
        return NoahResult.builderSuccess(Boolean.TRUE);
    }


    @ApiOperation(value = "删除轮播图")
    @DeleteMapping("/carousel")
    public NoahResult<Boolean> doDeletedCarousel(MultipartFile file,Long id){
        systemManagerService.doDeletedCarousel(file,id);
        return NoahResult.builderSuccess(Boolean.TRUE);
    }

    @ApiOperation(value = "查询轮播图")
    @GetMapping("/carousel")
    public NoahResult<PageInfo<CarouselDTO>> getCarouselList(PageDTO page){
        return NoahResult.builderSuccess(systemManagerService.getCarouselList(page));
    }
}
