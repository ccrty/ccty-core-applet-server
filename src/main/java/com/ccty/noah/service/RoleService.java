package com.ccty.noah.service;


import com.ccty.noah.domain.dto.RoleDTO;
import com.ccty.noah.domain.dto.RoleListConditionDTO;
import com.ccty.noah.domain.dto.RoleResourcesDTO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author ryan & 缄默
 * @date   2020/09/15
 */
public interface RoleService {
    /**
     * 校验角色名是否存在
     * @param name
     * @return
     */
    Boolean validRoleName(String name);

    /**
     * 新增角色
     * @param roleDTO
     * @return
     */
    void doInsertRole(RoleDTO roleDTO);

    /**
     * 根据条件获取角色列表
     * @param condition
     * @return
     */
    PageInfo<RoleDTO> getRoleListByCondition(RoleListConditionDTO condition);

    /**
     * 删除角色
     * @param id
     */
    void doDeleteRole(Long id);

    /**
     * 修改角色
     * @param role
     */
    void doUpdateRole(RoleDTO role);

    /**
     * 获取所有角色名称
     * @return
     */
    List<RoleDTO> getAllRoleName();

    /**
     * 角色绑定资源
     * @param roleResources
     */
    void roleBindResources(RoleResourcesDTO roleResources);

    /**
     * 根据角色id获取资源id
     * @param roleId
     * @return
     */
    List<Long> getResourcesIdByRoleId(Long roleId);
}
