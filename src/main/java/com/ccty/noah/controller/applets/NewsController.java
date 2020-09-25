package com.ccty.noah.controller.applets;

import com.ccty.noah.aop.NoahResult;
import com.ccty.noah.aop.target.NoahController;
import com.ccty.noah.domain.dto.PageDTO;
import com.ccty.noah.domain.dto.RoleDTO;
import com.ccty.noah.domain.dto.RoleListConditionDTO;
import com.ccty.noah.domain.dto.UserDTO;
import com.ccty.noah.domain.dto.applets.NewsConditionDTO;
import com.ccty.noah.domain.dto.applets.NewsDTO;
import com.ccty.noah.service.applets.NewsService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation(value = "获取网站资讯前五条")
    @GetMapping("/top")
    public NoahResult<List<NewsDTO>> getNewsTopFive(){
        return NoahResult.builderSuccess(newsService.getNewsTopFive());
    }

    @ApiOperation(value = "分页获取资讯列表")
    @GetMapping("/page")
    public NoahResult<PageInfo<NewsDTO>> getNewsByPage(NewsConditionDTO newsCondition){
        return NoahResult.builderSuccess(newsService.getNewsByPage(newsCondition));
    }

    @ApiOperation(value = "新增资讯")
    @PostMapping
    public NoahResult<Boolean> doInsertNews(@RequestBody @Validated NewsDTO news){
        newsService.doInsertNews(news);
        return NoahResult.builderSuccess(Boolean.TRUE);
    }

    @ApiOperation(value = "删除资讯")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value="资讯id",required = true,paramType = "query",dataType = "string")
    })
    @DeleteMapping
    public NoahResult<Boolean> doDeleteNews(@RequestParam("id")Long id){
        newsService.doDeleteNews(id);
        return NoahResult.builderSuccess(Boolean.TRUE);
    }

    @ApiOperation(value = "修改资讯")
    @PutMapping
    public NoahResult<Boolean> doUpdateNews(@RequestBody @Validated NewsDTO news){
        newsService.doUpdateNews(news);
        return NoahResult.builderSuccess(Boolean.TRUE);
    }
}
