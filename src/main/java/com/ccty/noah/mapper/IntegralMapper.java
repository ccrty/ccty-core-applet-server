package com.ccty.noah.mapper;

import com.ccty.noah.domain.database.applets.IntegralDO;
import com.ccty.noah.domain.database.applets.IntegralRecordDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author 缄默
 * @date   2020/12/13
 */
@Mapper
@Component
public interface IntegralMapper {

    /**
     * 根据用户名获取积分总数
     * @param userId
     * @return
     */
    BigDecimal queryIntegralByUserId(Long userId);

    /**
     * 根据用户名获取积分信息
     * @param userId
     * @return
     */
    IntegralDO queryIntegralInfoByUserId(Long userId);

    /**
     * 修改用户可用积分
     * @param id
     * @param totalCost
     */
    void updateAvailableIntegralById(@Param("id")Long id,@Param("totalCost") BigDecimal totalCost);

    /**
     * 插入积分记录
     * @param integralRecord
     */
    void insertIntegralRecord(IntegralRecordDO integralRecord);

    /**
     * 查询冻结积分情况
     * @param orderId
     * @return
     */
    IntegralRecordDO queryFreezeByOrderId(String orderId);

    /**
     * 扣减总积分
     * @param integralId
     * @param operateIntegral
     */
    void updateTotalIntegral(@Param("integralId") Long integralId,@Param("operateIntegral") BigDecimal operateIntegral);

    /**
     * 修改积分记录状态
     * @param orderId
     * @param code
     */
    void updateIntegralRecordByBusId(@Param("orderId") String orderId,@Param("code") Integer code);

    /**
     * 增加总积分和可用积分
     * @param riderId
     * @param totalCost
     */
    void updateIntegralByUserId(@Param("riderId") Long riderId,@Param("totalCost") BigDecimal totalCost);

    /**
     * 查询积分id
     * @param riderId
     */
    Long queryIntegralIdByUserId(Long riderId);
}
