package com.ccty.noah.service.applets;

import com.ccty.noah.domain.dto.applets.RunnerConditionDTO;
import com.ccty.noah.domain.dto.applets.RunnerDTO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author 缄默
 * @date   2020/12/22
 */
public interface RunnerService {

    /**
     * 发布跑腿订单
     * @param runner
     * @return
     */
    void publishRunnerOrder(RunnerDTO runner);

    /**
     * 查询跑腿订单
     * @param condition
     * @return
     */
    PageInfo<RunnerDTO> queryRunnerOrder(RunnerConditionDTO condition);

    /**
     * 骑手接收订单
     * @param orderId
     * @param riderId
     */
    void receiveRunnerOrder(Long orderId, Long riderId);

    /**
     * 结束跑腿订单
     * @param orderId
     */
    void finishRunnerOrder(Long orderId);
}
