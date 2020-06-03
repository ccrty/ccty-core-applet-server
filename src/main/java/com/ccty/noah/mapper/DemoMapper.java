package com.ccty.noah.mapper;

import com.ccty.noah.domain.database.DemoDO;
import org.springframework.stereotype.Component;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 缄默
 * @date 2019/10/14
 */
@Mapper
@Component
public interface DemoMapper {

    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    DemoDO queryUserInfoById(int id);
}
