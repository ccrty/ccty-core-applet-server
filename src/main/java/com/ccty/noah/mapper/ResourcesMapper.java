package com.ccty.noah.mapper;

import com.ccty.noah.domain.database.ResourcesDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @author 缄默
 * @date   2020/09/21
 */
@Component
@Mapper
public interface ResourcesMapper {


    /**
     * 插入资源
     * @param resourcesDO
     */
    void insertResources(ResourcesDO resourcesDO);

    /**
     * 根据条件获取资源列表
     * @param name
     * @return
     */
    List<ResourcesDO> queryResourcesListByCondition(@Param("name") String name);

    /**
     * 删除资源
     * @param id
     */
    void deleteResources(Long id);

    /**
     * 修改资源
     * @param resourcesDO
     */
    void updateResources(ResourcesDO resourcesDO);

    /**
     * 获取所有父级资源名称
     * @return
     */
    List<ResourcesDO> queryAllResourcesName();

    /**
     * 根据父id获取资源信息
     * @param id
     * @return
     */
    List<ResourcesDO> queryResourcesByParentId(String id);
}
