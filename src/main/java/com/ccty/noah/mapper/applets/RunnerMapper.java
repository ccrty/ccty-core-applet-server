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
     * 修改订单状态
     * @param orderId
     * @param riderId
     * @param code
     */
    void updateOrderStatus(@Param("orderId") Long orderId,@Param("riderId") Long riderId,@Param("code") Integer code);
}
