package com.ccty.noah.service.applets;

import com.ccty.noah.domain.dto.PageDTO;
import com.ccty.noah.domain.dto.applets.NewsConditionDTO;
import com.ccty.noah.domain.dto.applets.NewsDTO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author 缄默
 * @date   2020/09/13
 */
public interface NewsService {

    /**
     * 获取网站资讯前五条
     * @return
     */
    List<NewsDTO> getNewsTopFive();

    /**
     * 分页获取网站资讯前五条
     * @param newsConditionDTO
     * @return
     */
    PageInfo<NewsDTO> getNewsByPage(NewsConditionDTO newsConditionDTO);

    /**
     * 新增资讯
     * @param news
     */
    void doInsertNews(NewsDTO news);

    /**
     * 删除资讯
     * @param id
     */
    void doDeleteNews(Long id);

    /**
     * 修改资讯
     * @param news
     */
    void doUpdateNews(NewsDTO news);
}
