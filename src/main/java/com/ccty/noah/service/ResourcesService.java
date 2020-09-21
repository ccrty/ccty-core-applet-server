package com.ccty.noah.service;

import com.ccty.noah.domain.dto.ResourcesDTO;
import com.ccty.noah.domain.dto.ResourcesListConditionDTO;
import com.github.pagehelper.PageInfo;

/**
 * @author 缄默
 * @date   2020/09/21
 */
public interface ResourcesService {
    /**
     * 新增资源
     * @param resources
     */
    void doInsertResources(ResourcesDTO resources);

    /**
     * 根据条件查询资源列表
     * @param condition
     * @return
     */
    PageInfo<ResourcesDTO> getResourcesListByCondition(ResourcesListConditionDTO condition);

    /**
     * 删除资源
     * @param id
     */
    void doDeleteResources(Integer id);

    /**
     * 修改资源
     * @param resources
     */
    void doUpdateResources(ResourcesDTO resources);
}
