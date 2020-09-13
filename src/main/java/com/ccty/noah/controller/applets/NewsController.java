package com.ccty.noah.controller.applets;

import com.ccty.noah.aop.aspect.NoahResult;
import com.ccty.noah.aop.aspect.target.NoahController;
import com.ccty.noah.service.applets.NewsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
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
    public NoahResult<List<NewsController>> getNewsTopFive(){
        return NoahResult.builderSuccess(newsService.getNewsTopFive());
    }
}
