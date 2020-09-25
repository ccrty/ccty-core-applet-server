package com.ccty.noah.service.applets.impl;

import com.ccty.noah.aop.target.NoahService;
import com.ccty.noah.domain.convertor.applets.NewsConvertor;
import com.ccty.noah.domain.database.applets.NewsDO;
import com.ccty.noah.domain.dto.PageDTO;
import com.ccty.noah.domain.dto.applets.NewsConditionDTO;
import com.ccty.noah.domain.dto.applets.NewsDTO;
import com.ccty.noah.mapper.applets.NewsMapper;
import com.ccty.noah.service.applets.NewsService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 缄默
 * @date   2020/09/13
 */
@NoahService
@Slf4j
public class NewServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;
    @Autowired
    private NewsConvertor newsConvertor;


    /**
     * 获取网站资讯前五条
     * @return
     */
    @Override
    public List<NewsDTO> getNewsTopFive() {
        List<NewsDO> newsList = newsMapper.queryNewsTopFive();
        return newsConvertor.newsDOToDTOs(newsList);
    }

    /**
     * 分页获取资讯列表
     * @param pageObj
     * @return
     */
    @Override
    public PageInfo<NewsDTO> getNewsByPage(NewsConditionDTO pageObj) {
        Page page = PageHelper.startPage(pageObj.getPageNum(), pageObj.getPageSize());
        List<NewsDO> newsList = newsMapper.queryNewsByPage(pageObj.getTitle(),pageObj.getType());
        PageInfo pageInfo = new PageInfo<>(page.getResult());
        List<NewsDTO> newsDTOS = newsConvertor.newsDOToDTOs(newsList);
        pageInfo.setList(newsDTOS);
        return pageInfo;
    }

    /**
     * 新增资讯
     * @param news
     */
    @Override
    public void doInsertNews(NewsDTO news) {
        NewsDO newsDO = newsConvertor.DTOToDO(news);
        newsMapper.insertNews(newsDO);
    }

    /**
     * 删除资讯
     * @param id
     */
    @Override
    public void doDeleteNews(Long id) {
        newsMapper.deleteNews(id);
    }

    /**
     * 修改资讯
     * @param news
     */
    @Override
    public void doUpdateNews(NewsDTO news) {
        NewsDO newsDO = newsConvertor.DTOToDO(news);
        newsMapper.updateNews(newsDO);
    }
}
