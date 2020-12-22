package com.ccty.noah.mapper;

import org.apache.ibatis.annotations.Mapper;
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
}
