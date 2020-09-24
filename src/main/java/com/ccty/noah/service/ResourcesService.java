package com.ccty.noah.service;

import com.ccty.noah.domain.dto.ResourcesDTO;
import com.ccty.noah.domain.dto.ResourcesListConditionDTO;
import com.github.pagehelper.PageInfo;

import java.util.List;

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
    void doDeleteResources(Long id);

    /**
     * 修改资源
     * @param resources
     */
    void doUpdateResources(ResourcesDTO resources);

    /**
     * 获取所有资源名称
     * @return
     */
    List<ResourcesDTO> getAllResourcesName();

    /**
     * 获取资源树
     * @param id
     * @return
     */
    List<ResourcesDTO> getResourcesTree(String id);
}
