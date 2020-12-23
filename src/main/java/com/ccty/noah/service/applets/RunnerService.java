package com.ccty.noah.service.applets;

import com.ccty.noah.domain.dto.applets.RunnerDTO;

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
}
