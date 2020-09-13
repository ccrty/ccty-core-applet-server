package com.ccty.noah.service.applets;

import com.ccty.noah.domain.dto.applets.NewsDTO;

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
}
