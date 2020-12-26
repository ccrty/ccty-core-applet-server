package com.ccty.noah.mapper.applets;

import com.ccty.noah.domain.database.applets.NewsDO;
import com.ccty.noah.domain.database.applets.RunnerConditionDO;
import com.ccty.noah.domain.database.applets.RunnerDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 缄默
 * @date 2020/12/22
 */
@Mapper
@Component
public interface RunnerMapper {

    /**
     * 插入跑腿订单
     * @param runner
     */
    void insertRunner(RunnerDO runner);

    /**
     * 查询订单信息
     * @param condition
     * @return
     */
    List<RunnerDO> queryRunnerList(RunnerConditionDO condition);

    /**
     * 修改订单状态和骑手id
     * @param orderId
     * @param riderId
     * @param code
     */
    void updateOrderStatusAndRiderId(@Param("orderId") Long orderId,@Param("riderId") Long riderId,@Param("code") Integer code);

    /**
     * 修改订单状态
     * @param orderId
     * @param code
     */
    void updateOrderStatusByBusId(@Param("orderId") String orderId,@Param("code") Integer code);

    /**
     * 查询骑手id和金额
     * @param orderId
     * @return
     */
    RunnerDO queryRiderIdAndPriceByBusId(String orderId);
}
