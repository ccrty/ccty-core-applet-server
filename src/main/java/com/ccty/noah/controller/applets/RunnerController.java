package com.ccty.noah.controller.applets;

import com.ccty.noah.aop.NoahResult;
import com.ccty.noah.aop.target.NoahController;
import com.ccty.noah.domain.dto.applets.RunnerDTO;
import com.ccty.noah.service.applets.RunnerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

/**
 * @author 缄默
 * @date   2020/12/22
 */
@Api("跑腿订单控制器")
@NoahController
@RequestMapping("/{version}/applets/api/runner")
public class RunnerController {

    @Autowired
    private RunnerService runnerService;

    @ApiOperation(value = "发布跑腿订单")
    @PostMapping("/publish")
    public NoahResult<List<Boolean>> publishRunnerOrder(@Valid RunnerDTO runnerDTO){
        runnerService.publishRunnerOrder(runnerDTO);
        return NoahResult.builderSuccess(Boolean.TRUE);
    }
}
