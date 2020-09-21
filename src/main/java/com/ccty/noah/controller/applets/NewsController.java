package com.ccty.noah.controller.applets;

import com.ccty.noah.aop.NoahResult;
import com.ccty.noah.aop.target.NoahController;
import com.ccty.noah.domain.dto.PageDTO;
import com.ccty.noah.domain.dto.UserDTO;
import com.ccty.noah.domain.dto.applets.NewsDTO;
import com.ccty.noah.service.applets.NewsService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author 缄默
 * @date   2020/08/25
 */
@Api("资讯控制器")
@RequestMapping("/{version}/applets/api/news")
@NoahController
@Slf4j
public class NewsController {

    @Autowired
    private NewsService newsService;

    @ApiModelProperty("获取网站资讯前五条")
    @GetMapping("/top")
    public NoahResult<List<NewsDTO>> getNewsTopFive(){
        return NoahResult.builderSuccess(newsService.getNewsTopFive());
    }

    @ApiOperation("分页获取资讯列表")
    @GetMapping("/page")
    public NoahResult<PageInfo<UserDTO>> getNewsByPage(PageDTO page){
        return NoahResult.builderSuccess(newsService.getNewsByPage(page));
    }
}
