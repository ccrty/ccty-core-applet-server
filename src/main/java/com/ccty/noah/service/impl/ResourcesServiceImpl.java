package com.ccty.noah.service.impl;

import com.ccty.noah.aop.target.NoahService;
import com.ccty.noah.domain.convertor.ResourcesConvertor;
import com.ccty.noah.domain.database.ResourcesDO;
import com.ccty.noah.domain.dto.ResourcesDTO;
import com.ccty.noah.domain.dto.ResourcesListConditionDTO;
import com.ccty.noah.mapper.ResourcesMapper;
import com.ccty.noah.service.ResourcesService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 缄默
 * @date   2020/09/21
 */
@NoahService
public class ResourcesServiceImpl implements ResourcesService {

    @Autowired
    ResourcesMapper resourcesMapper;
    @Autowired
    ResourcesConvertor resourcesConvertor;

    /**
     * 新增资源
     * @param resources
     */
    @Override
    public void doInsertResources(ResourcesDTO resources) {
        ResourcesDO resourcesDO = resourcesConvertor.DTOToDO(resources);
        resourcesMapper.insertResources(resourcesDO);
    }

    /**
     * 根据条件查询资源列表
     * @param condition
     * @return
     */
    @Override
    public PageInfo<ResourcesDTO> getResourcesListByCondition(ResourcesListConditionDTO condition) {
        Page page = PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        List<ResourcesDO> resourcesList = resourcesMapper.queryResourcesListByCondition(condition.getName());
        PageInfo pageInfo = new PageInfo<>(page.getResult());
        List<ResourcesDTO> resourcesDTOS = resourcesConvertor.DOListToDTO(resourcesList);
        pageInfo.setList(resourcesDTOS);
        return pageInfo;
    }

    /**
     * 删除资源
     * @param id
     */
    @Override
    public void doDeleteResources(Long id) {
        resourcesMapper.deleteResources(id);
    }

    /**
     * 修改资源
     * @param resources
     */
    @Override
    public void doUpdateResources(ResourcesDTO resources) {
        ResourcesDO resourcesDO = resourcesConvertor.DTOToDO(resources);
        resourcesMapper.updateResources(resourcesDO);
    }
}
