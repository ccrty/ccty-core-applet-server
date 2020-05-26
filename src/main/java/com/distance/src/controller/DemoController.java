package com.distance.src.controller;

import com.distance.src.aop.aspect.NoahResult;
import com.distance.src.aop.aspect.exception.NoahException;
import com.distance.src.domain.dto.DemoDTO;
import com.distance.src.aop.aspect.target.NoahController;
import com.distance.src.service.DemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 缄默
 * @date 2019/5/23
 */
@Api("示例控制器")
@RequestMapping("/{version}/api/applets")
@NoahController
@Slf4j
public class DemoController {

    @Autowired
    private DemoService demoService;

    @ApiOperation(value = "异常抛出示例", notes = "异常抛出示例")
    @GetMapping("/test")
    public NoahResult test(){
        throw new NoahException("001","示例");
    }

    @ApiOperation(value = "正常返回示例", notes = "正常返回示例")
    @GetMapping("/test1")
    public NoahResult<String> test1(){
        return NoahResult.builderSuccess(StringUtils.EMPTY);
    }

    @ApiOperation(value = "捕获Valid异常示例")
    @GetMapping("/test3")
    public NoahResult<String> test3(@Validated DemoDTO demoDTO){
        return NoahResult.builderSuccess(StringUtils.EMPTY);
    }

    @ApiOperation("获取用户信息示例")
    @GetMapping("/demo/{id}")
    public NoahResult<DemoDTO> test4(@PathVariable int id){
        DemoDTO demoDTO = demoService.queryUserInfoById(id);
        return NoahResult.builderSuccess(demoDTO);
    }
}
