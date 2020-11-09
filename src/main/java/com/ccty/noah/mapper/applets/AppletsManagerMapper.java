package com.ccty.noah.mapper.applets;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 缄默
 * @date 2020/10/22
 */
@Mapper
@Component
public interface AppletsManagerMapper {

    /**
     * 根据类型获取轮播图
     * @param type
     * @return
     */
    List<String> queryCarouselListByType(Integer type);
}
