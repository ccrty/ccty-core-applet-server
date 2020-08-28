package com.ccty.noah.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author 缄默
 * @date   2020/08/27
 */
@Mapper
@Component
public interface UserMapper {

    /**
     * 根据用户名获取信息
     * @param username
     * @return
     */
    Integer queryInfoByUserName(String username);
}
