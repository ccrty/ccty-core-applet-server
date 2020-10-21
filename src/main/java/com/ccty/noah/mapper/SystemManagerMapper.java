package com.ccty.noah.mapper;

import com.ccty.noah.domain.database.CarouselDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 缄默
 * @date   2020/10/15
 */
@Mapper
@Component
public interface SystemManagerMapper {

    /**
     * 新增轮播图
     * @param carouselDO
     */
    void insertCarousel(CarouselDO carouselDO);

    /**
     * 修改轮播图
     * @param carousel
     */
    void updateCarousel(CarouselDO carousel);

    /**
     * 删除轮播图
     * @param id
     */
    void deleteCarousel(Long id);

    /**
     * 获取轮播图信息
     * @return
     */
    List<CarouselDO> queryCarouselList();
}
