package com.ccty.noah.mapper.applets;

import com.ccty.noah.domain.database.applets.NewsDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

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

    /**
     * 分页获取资讯信息
     * @return
     */
    List<NewsDO> queryNewsByPage(@Param("title")String title,@Param("type")Integer type);

    /**
     * 插入资讯
     * @param newsDO
     */
    void insertNews(NewsDO newsDO);

    /**
     * 删除资讯
     * @param id
     */
    void deleteNews(Long id);

    /**
     * 修改资讯
     * @param newsDO
     */
    void updateNews(NewsDO newsDO);
}
