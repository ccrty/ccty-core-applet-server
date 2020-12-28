package com.ccty.noah.controller.applets;

import com.ccty.noah.aop.NoahResult;
import com.ccty.noah.aop.target.NoahController;
import com.ccty.noah.domain.dto.applets.RunnerConditionDTO;
import com.ccty.noah.domain.dto.applets.RunnerDTO;
import com.ccty.noah.service.applets.RunnerService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public NoahResult<Boolean> publishRunnerOrder(@Valid RunnerDTO runnerDTO){
        runnerService.publishRunnerOrder(runnerDTO);
        return NoahResult.builderSuccess(Boolean.TRUE);
    }

    @ApiOperation(value = "获取跑腿订单")
    @GetMapping("/list")
    public NoahResult<PageInfo<RunnerDTO>> queryRunnerOrder(RunnerConditionDTO condition){
        return NoahResult.builderSuccess(runnerService.queryRunnerOrder(condition));
    }

    @ApiOperation(value = "骑手接收订单")
    @PostMapping("/receive")
    public NoahResult<Boolean> receiveRunnerOrder(@RequestParam("orderId")Long orderId,
                                                  @RequestParam("riderId")Long riderId){
        runnerService.receiveRunnerOrder(orderId,riderId);
        return NoahResult.builderSuccess(Boolean.TRUE);

    }

    @ApiOperation(value = "结束跑腿订单")
    @PostMapping("/finish")
    public NoahResult<Boolean> finishRunnerOrder(@RequestParam("orderId")String orderId){
        runnerService.finishRunnerOrder(orderId);
        return NoahResult.builderSuccess(Boolean.TRUE);
    }
}
