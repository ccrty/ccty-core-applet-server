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
}
