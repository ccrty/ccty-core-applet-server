package com.ccty.noah.controller.applets;

import com.ccty.noah.aop.NoahResult;
import com.ccty.noah.aop.target.NoahController;
import com.ccty.noah.domain.dto.CarouselDTO;
import com.ccty.noah.domain.dto.PageDTO;
import com.ccty.noah.service.applets.AppletsManagerService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author 缄默
 * @date   2020/10/22
 */
@Api("小程序管理控制器")
@RequestMapping("/{version}/applets/api/manager")
@NoahController
@Slf4j
public class AppletsManagerController {

    @Autowired
    private AppletsManagerService appletsManagerService;

    @ApiOperation(value = "查询轮播图")
    @GetMapping("/carousel/{type}")
    public NoahResult<List<String>> getCarouselList(@PathVariable("type")Integer type){
        return NoahResult.builderSuccess(appletsManagerService.getCarouselList(type));
    }
}
