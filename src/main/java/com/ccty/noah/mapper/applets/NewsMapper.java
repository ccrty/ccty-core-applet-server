package com.ccty.noah.mapper.applets;

import com.ccty.noah.domain.database.applets.NewsDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 缄默
 * @date 2020/09/13
 */
@Mapper
@Component
public interface NewsMapper {

    /**
     * 获取网站公告前五条
     * @return
     */
    List<NewsDO> queryNewsTopFive();

    List<NewsDO> queryNewsByPage();
}
